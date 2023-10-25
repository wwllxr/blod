package blog.controller;

import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.PageInfo;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Controller @RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String userName=request.getParameter("userName");
        String userPass=request.getParameter("userPass");
        //得到登录用户
        User user=userService.getUserByNameOrEmail(userName);

        if(user!=null) {
            if(user.getUserPass().equals(userPass)) {
                //得到最近文章
                List<Article> listRecentArticle = articleService.getListRecentArticle(5);
                //得到最近评论
                List<Comment> listRecentComment = commentService.getListRecentComment(5);

                request.setAttribute("listRecentArticle",listRecentArticle);
                request.setAttribute("listRecentComment",listRecentComment);
                request.getSession().setAttribute("session_user", user);
                return "index";
            }
            else {
                request.setAttribute("msg", "密码错误");
                return "login";
            }
        }
        else {
            request.setAttribute("msg", "账号或密码错误");
            return "login";
        }
    }

    @RequestMapping("/userList/{page}")
    public ModelAndView userList(@PathVariable(value = "page")Integer page){
        PageInfo<User> pageInfo=userService.getUserList(page,10);

        ModelAndView mv = new ModelAndView("user/User_List", "pageInfo", pageInfo);
        mv.addObject("pageUrlPrefix","user/userList");

        return mv;
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "forward:/user/userList/1";
    }

    @ResponseBody
    @RequestMapping("/uploadImg")
    public Map<String,Object> uploadImg(MultipartFile file,HttpServletRequest request) throws IOException {
        //生成文件名
        String fileName=file.getOriginalFilename();
       //拿到当前时间
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        File destFile = new File("D:\\idea-workspace\\blog\\src\\main\\webapp\\resources\\uploads\\"+year+"\\"+month);
        if(!destFile.exists()){
            destFile.mkdirs();
        }
        File destFile1=new File(destFile,fileName);
        file.transferTo(destFile1);
        //返回路径
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        data.put("src","resources/uploads/" + year + "/" + month + "/" + fileName);
        res.put("code",0);
        res.put("data",data);
        return res;
    }
}
