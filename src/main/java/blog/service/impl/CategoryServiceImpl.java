package blog.service.impl;

import blog.entity.Category;
import blog.entity.User;
import blog.mapper.CategoryMapper;
import blog.mapper.UserMapper;
import blog.service.CategoryService;
import blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper mapper;

    @Override
    public List<Category> getAllCategory() {

        return mapper.getAllCategory();
    }

    @Override
    public List<Category> getSubList(Integer parentId) {
        return mapper.getSubList(parentId);
    }
}
