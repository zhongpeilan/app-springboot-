package com.example.demo.entities;

import java.sql.Timestamp;

public class Article {
    private String release_people;
    private String release_time;
    private int article_reading;
    private String article_title;
    private String article_content;
    private int article_id;
    private String article_image1;
    private String article_image2;
    private int article_type;
    private int isbanner;
    private Timestamp uploadtime;


    public Article(){

    }

    public Article(String release_people, String release_time, int article_reading, String article_title, String article_content, int article_id, String article_image1, String article_image2, int article_type, int isbanner, Timestamp uploadtime) {
        this.release_people = release_people;
        this.release_time = release_time;
        this.article_reading = article_reading;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_id = article_id;
        this.article_image1 = article_image1;
        this.article_image2 = article_image2;
        this.article_type = article_type;
        this.isbanner = isbanner;
        this.uploadtime = uploadtime;
    }

    public String getRelease_people() {
        return release_people;
    }

    public void setRelease_people(String release_people) {
        this.release_people = release_people;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public int getArticle_reading() {
        return article_reading;
    }

    public void setArticle_reading(int article_reading) {
        this.article_reading = article_reading;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_image1() {
        return article_image1;
    }

    public void setArticle_image1(String article_image1) {
        this.article_image1 = article_image1;
    }

    public String getArticle_image2() {
        return article_image2;
    }

    public void setArticle_image2(String article_image2) {
        this.article_image2 = article_image2;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public int getIsbanner() {
        return isbanner;
    }

    public void setIsbanner(int isbanner) {
        this.isbanner = isbanner;
    }

    public Timestamp getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Timestamp uploadtime) {
        this.uploadtime = uploadtime;
    }
}

