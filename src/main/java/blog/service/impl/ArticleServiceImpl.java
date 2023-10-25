package blog.service.impl;

import blog.common.PageUtil;
import blog.entity.Article;
import blog.entity.PageInfo;
import blog.mapper.ArticleMapper;
import blog.mapper.CategoryMapper;
import blog.mapper.TagMapper;
import blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private TagMapper tagMapper;
    @Override
    public List<Article> getListRecentArticle(Integer n) {
        List<Article> listRecentArticle = articleMapper.getListRecentArticle(n);
        return listRecentArticle;
    }

    @Override
    public PageInfo<Article> getListArticle(int page, int size) {
        PageHelper.startPage(page,size);
        List<Article> articleList = articleMapper.getAllArticle();
        int count = articleMapper.getAllArticleCount();
        PageInfo<Article> p=PageUtil.getPageInfo(size,page,count);
        /*System.out.println(p.getBeginRow());
        System.out.println(size);*/
        //List<Article> articleList = articleMapper.getListArticle(p.getBeginRow(),size);
        p.setList(articleList);
        return p;
    }

    @Override
    public void addArticle(Article article) {
        //插入文章，并得到自增主键
        articleMapper.addArticle(article);
        //Article和Category加入数据
        categoryMapper.addArticleCategory(article.getArticleId(),article.getCategoryList());
        //Article和Tag加入数据
        tagMapper.addArticleTag(article.getArticleId(),article.getTagList());

    }

    @Override
    public Article getArticleById(Integer articleId) {
        return articleMapper.getArticleById(articleId);
    }

}
