package blog.service;

import blog.entity.Comment;
import blog.entity.User;

import java.util.List;

public interface CommentService {

    List<Comment> getListRecentComment(Integer n);
}
