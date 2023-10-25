package blog.controller;

import blog.entity.Category;
import blog.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/getSubList")
    public List<Category> getSubList(Integer parentId){
        System.out.println(parentId);
        List<Category> categoryList = categoryService.getSubList(parentId);
        return categoryList;
    }
}
