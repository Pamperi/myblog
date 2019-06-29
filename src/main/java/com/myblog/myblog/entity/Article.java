package com.myblog.myblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})//这行代码的作用在于告诉你的jsonplug组件，在将你的代理对象转换为json对象时，忽略value对应的数组中的属性
@Entity
@Table(name = "article")
public class Article implements Serializable {
    @GeneratedValue
    @Id
    private Integer id;
    private String article;
    private String title;
    @Column(name = "subtitle")
    private String subTitle;

    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
