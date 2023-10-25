package blog.service.impl;

import blog.entity.Comment;
import blog.entity.User;
import blog.mapper.ArticleMapper;
import blog.mapper.CommentMapper;
import blog.service.ArticleService;
import blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private  ArticleMapper articleMapper;
    @Override
    public List<Comment> getListRecentComment(Integer n) {
        List<Comment> listRecentComment = commentMapper.getListRecentComment(n);
        //articleMapper.getArticleById()
        return listRecentComment;
    }
}
