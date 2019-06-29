package com.myblog.myblog.controller;

import com.myblog.myblog.Until.Result;
import com.myblog.myblog.entity.Article;
import com.myblog.myblog.entity.PageGrounp;
import com.myblog.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/findBy.do")
    @ResponseBody
    public PageGrounp<Article> findBy(Integer page, Integer size){
        System.out.println(page+"        "+size);
        return articleService.findBy(page,size);
    }
    @RequestMapping(value = "/findByCriteria.do")
    @ResponseBody
    public PageGrounp<Article> findAll(Integer page, Integer size, @RequestBody Article article){
        System.out.println(article.getTitle()+""+article.getSubTitle());
        return articleService.findByCriteria(page,size,article);
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public Result save(@RequestBody Article article){
        article.setTime(new Date());
        Article add = articleService.add(article);
        if(add ==null){
            return new Result("操作失败",false);
        }else{
            return  new Result("操作成功",true);
        }
    }
    @RequestMapping(value = "/del.do")
    @ResponseBody
    public Result delete(Integer id){
        try {
            articleService.delete(id);
        }catch (Exception e){
            return  new Result("删除失败",false);
        }
        return new Result("删除成功",true);
    }

    @RequestMapping(value = "/findByOne.do")
    @ResponseBody
    public Article findByOne(Integer id){
        return articleService.findByOne(id);
    }
}
