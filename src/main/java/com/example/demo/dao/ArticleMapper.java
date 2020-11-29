package com.example.demo.dao;

import com.example.demo.common.Result;
import com.example.demo.entities.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@Mapper
public interface ArticleMapper {
    //批量获得新闻/活动/项目
    @Select("select * from hotarticle where article_type=#{article_type}")
    public List<Article> expandArticle(int article_type);
    //添加新闻/活动/项目
    @Insert("insert into hotarticle (release_people,release_time,article_title," +
            "article_content,article_image1,article_image2,article_type,isbanner) " +
            "values " +
            "(#{article.release_people},#{article.release_time},#{article.article_title},#{article.article_content},#{article.article_image1}," +
            "#{article.article_image2},#{article.article_type},#{article.isbanner})")
    public boolean addArticle(@Param("article") Article article);
    //删除新闻/活动/项目
    @Delete("delete from hotarticle where article_id=#{article_id}")
    public boolean deleteArticle(@Param("article_id") int article_id);

    //按关键字查询(在活动板块中）
    @Select("select * from hotarticle where article_title like concat('%',#{keyword},'%') ")
    public List<Article> searchArticle(@Param("keyword") String keyword);

    //获取表中全部内容
    @Select("select * from hotarticle")
    public List<Article> getdata();

    @Select("select * from hotarticle order by uploadtime desc limit 4")
    public List<Article> rebanner();

}
