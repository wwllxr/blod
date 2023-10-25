package blog.service;

import blog.entity.Category;
import blog.entity.Tag;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();


    List<Category> getSubList(Integer parentId);
}
