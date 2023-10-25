package blog.service;

import blog.entity.Article;
import blog.entity.PageInfo;
import blog.entity.User;

import java.util.List;

public interface ArticleService {

    List<Article> getListRecentArticle(Integer n);
    PageInfo<Article> getListArticle(int page, int size);

    void addArticle(Article article);

    Article getArticleById(Integer articleId);
}
