package blog.mapper;

import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentMapper {

    List<Comment> getListRecentComment(Integer n);

}
