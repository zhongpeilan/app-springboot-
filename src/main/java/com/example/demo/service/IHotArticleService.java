package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entities.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IHotArticleService {
    //查询新闻/广告/项目
    public List<Article> expandArticle(int article_type);

    //添加新闻/广告/项目
    public boolean addArticle(Article article);

    /*//删除新闻/广告/项目
    public boolean deleteArticle(Article article);*/
    //删除新闻/广告/项目
    public boolean deleteArticle(int article_id);

    //按关键字查询
    public List<Article> searchArticle(String keyword);
    //获取表中全部内容
    public List<Article> getdata();
    //获取前四个banner
    public List<Article> rebanner();

}
