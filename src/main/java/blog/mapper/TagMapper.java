package blog.mapper;

import blog.entity.Tag;
import blog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TagMapper {
    void addArticleTag(@Param("articleId") Integer articleId, @Param("tagList") List<Tag> tagList);

    List<Tag> getAllTag();
}
