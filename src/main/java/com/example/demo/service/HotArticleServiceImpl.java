package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.dao.ArticleMapper;
import com.example.demo.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotArticleServiceImpl implements IHotArticleService{

    @Autowired
    ArticleMapper articleMapper;
    @Override
    public List<Article> expandArticle(int article_type) {
        return articleMapper.expandArticle(article_type);
    }

    @Override
    public boolean addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public boolean deleteArticle(int article_id) {
        return articleMapper.deleteArticle(article_id);
    }

    @Override
    public List<Article> searchArticle(String keyword) {
        return articleMapper.searchArticle(keyword);
    }

    @Override
    public List<Article> getdata() {
        return articleMapper.getdata();
    }

    @Override
    public List<Article> rebanner() {
        return articleMapper.rebanner();
    }

}
