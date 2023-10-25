package blog.controller;


import blog.entity.*;
import blog.service.ArticleService;
import blog.service.CategoryService;
import blog.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller @RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private TagService tagService;
    @Resource
    private CategoryService categoryService;


    @RequestMapping(value = "/{pageIndex}")
    public ModelAndView getListArticle(@PathVariable(value = "pageIndex", required = false) Integer page, @RequestParam(defaultValue = "10") int size){

        PageInfo<Article> pageInfo = articleService.getListArticle(page,size);

        ModelAndView mv = new ModelAndView("article/Article_List","pageInfo",pageInfo);
        mv.addObject("pageUrlPrefix","article");
        //System.out.println(pageInfo.getList().size());
        return mv;
    }
    @RequestMapping(value = "/toAddArticle",method = RequestMethod.GET)
    public String toAddArticle(ModelMap m){
        List<Category> categoryList = categoryService.getAllCategory();
        List<Tag> tagList = tagService.getAllTag();
        m.put("categoryList",categoryList);
        m.put("tagList",tagList);
        /*System.out.println(categoryList.toString());
        System.out.println(tagList.toString());*/
        return "article/Article_Add";
    }
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public String addArticle(Article article, HttpServletRequest request){
        //设置文章的作者
        User loginUser =(User) request.getSession().getAttribute("session_user");
        article.setArticleUserId(loginUser.getUserId());
        article.setUser(loginUser);
        //设置文章浏览次数
        article.setArticleViewCount(0);
        //设置文章类似篇数
        article.setArticleLikeCount(0);
        //设置文章评论数
        article.setArticleCommentCount(0);
        //设置文章创建时间\修改时间
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        //默认的排序
        article.setArticleOrder(1);
        //文章摘要
        String s =article.getArticleContent();
        article.setArticleSummary(s.length()>50?s.substring(0,50) :s );
        //一级分类id
        int  articleParentCategoryId =Integer.parseInt(request.getParameter("articleParentCategoryId"));
        //二级分类id
        int  articleChildCategoryId =Integer.parseInt(request.getParameter("articleChildCategoryId"));
        List<Category> categoryList=new ArrayList<>(2);
        categoryList.add(new Category(articleParentCategoryId) );
        categoryList.add(new Category(articleChildCategoryId) );
        article.setCategoryList(categoryList);
        //标签
        String [] tagIds= request.getParameterValues("articleTagIds");
        List<Tag> tagList=new ArrayList<>(tagIds.length);
        for(String tagId:tagIds) {
            tagList.add(new Tag(Integer.parseInt(tagId)));
        }
        article.setTagList(tagList);

        articleService.addArticle(article);
        //System.out.println(article.toString());
        return "forward:/article/1";
    }
    @RequestMapping(value = "/showArticle/{articleId}",method=RequestMethod.GET)
    public String showArticle(ModelMap m,@PathVariable(value = "articleId") Integer articleId){
        Article article = articleService.getArticleById(articleId);
        m.put("article",article);
        return "article/Article_Show";
    }
    @ResponseBody
    @RequestMapping(value = "/uploadimg")
    public String uploadArticleImg(MultipartHttpServletRequest request) throws IOException {
        //imgFile是固定写法
        MultipartFile imgFile = request.getFile("imgFile");
        //生成文件名
        String fileName=UUID.randomUUID().toString()+".jpg";
        //存入文件
        File destFile = new File("D:\\blogImg\\" + fileName);
        imgFile.transferTo(destFile);

        //生产映射路径
        String path="http://localhost:8080/upload/"+fileName;

        return "{\"error\":0,\"url\":\""+path+"\"}";
    }
}
