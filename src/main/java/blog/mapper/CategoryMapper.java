package blog.mapper;

import blog.entity.Category;
import blog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CategoryMapper {
    List<Category> getAllCategory();
    void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryList") List<Category> categoryList);

    List<Category> getSubList(Integer parentId);
}
