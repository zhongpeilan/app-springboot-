package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.common.ResultMain;
import com.example.demo.dao.AuditDao;
import com.example.demo.entities.Article;
import com.example.demo.netty.server.ChattingServer;
import com.example.demo.service.HotArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class articleController {

    @Autowired
    HotArticleServiceImpl hotArticleService;
    @Autowired
    AuditDao auditDao;

    ChattingServer simpleChatServer=new ChattingServer(8585);

    //查询活动/新闻/项目
    @PostMapping("expandArticle")
    public Result expandArticle(@RequestHeader("article_type") String article_type){
        int articletype=Integer.parseInt(article_type);
        if(articletype==5){
            List<Article> rebanner = hotArticleService.rebanner();
            return ResultMain.success(rebanner);

        }else {
            //根据文章类型 获取相应的所有文章
            List<Article> hotArticles=hotArticleService.expandArticle(articletype);
            if(hotArticles!=null){
                return ResultMain.success(hotArticles);
            }else{
                return ResultMain.error("获取"+article_type+"类型信息出错");
            }
        }
    }
    //增加活动/新闻/项目
    @PostMapping("addArticle")
    public Result addArticle(@RequestBody Article article){
        String s=null;
        if(article!=null){
            switch (article.getArticle_type()){
                case 0:s="新闻";
                case 1:s="活动";
                case 2:s="项目";
            }
            if(hotArticleService.addArticle(article)){
                //若添加成功
                System.out.println(article.getArticle_type());
                simpleChatServer.sendMessageToAllUser("增加了"+s+":"+article.getArticle_title());
                return ResultMain.success("发布"+s+"成功");
            }else
                return ResultMain.error("发布"+s+"失败");
        }else
            return ResultMain.error("请添加相关信息！");
    }
    /*//删除活动/新闻/项目
    @PostMapping("deleteArticle")
    public Result deleteArticle(@RequestBody Article article) {

        if (article != null) {
            if (hotArticleService.deleteArticle(article)) {
                //若删除成功
                return ResultMain.success("删除成功");
            } else
                return ResultMain.error("删除失败");
        } else
            return ResultMain.error("操作有误");
    }*/
    //删除活动/新闻/项目
    @PostMapping("deleteArticle")
    public Result deleteArticle(@RequestHeader("article_id") int article_id) {

        if (article_id != 0){
            if (hotArticleService.deleteArticle(article_id)){
                //若删除成功
                simpleChatServer.sendMessageToAllUser("删除了");
                return ResultMain.success("删除成功");
            } else
                return ResultMain.error("删除失败");
        } else
            return ResultMain.error("操作有误");
    }
    //按关键字查询 活动
    @PostMapping("searchArticle")
    public Result searchArticle(@RequestHeader("keyword") String keyword){
        if(keyword!=null){
            List<Article> list=hotArticleService.searchArticle(keyword);
            if(list!=null){
                return ResultMain.success(list);
            }
            return ResultMain.error("未查到与此关键字相关的活动");
        }
        return ResultMain.error("关键字不能为空");
    }
    //返回表中所有内容
    @PostMapping("getdata")
    public Result getdata(){
        List<Article> list=hotArticleService.getdata();
        if(null!=list){
            return ResultMain.success(list);
        }else
            return ResultMain.error("无内容");
    }
    //新增banner
    @PostMapping("setbanner")
    public Result setbanner(@RequestBody List<Integer> id){

        auditDao.setbanner(id);
        return ResultMain.success("成功");
    }

    /*//发送消息
    @GetMapping("sendMsg")
    public Result sendMsg(){
        simpleChatServer.sendMessageToAllUser("dhjkdndjkndkddlkmdl");
        return ResultMain.success("发送成功");
    }*/
}
