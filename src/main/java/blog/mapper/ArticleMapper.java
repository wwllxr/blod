package blog.mapper;

import blog.entity.Article;
import blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleMapper {

    List<Article> getListRecentArticle(Integer n);
    Article getArticleById(Integer id);
    List<Article> getListArticle(int beginRow, int size);

    int getAllArticleCount();

    List<Article> getAllArticle();

    int addArticle(Article article);
}
