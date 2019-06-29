package com.myblog.myblog.service;

import com.myblog.myblog.entity.Article;
import com.myblog.myblog.entity.PageGrounp;
import com.myblog.myblog.repositoty.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public PageGrounp<Article> findBy(Integer page, Integer size){
        Pageable of = PageRequest.of(page - 1, size);
        Page<Article> all = articleRepository.findAll(of);
        PageGrounp<Article> pageGrounp=new PageGrounp<Article>();
        pageGrounp.setList(all.getContent());
        pageGrounp.setSize(size);//每页记录数
        long totalElements = all.getTotalElements();
        pageGrounp.setPageSize(all.getTotalPages());//总页数
        pageGrounp.setTotalElements((int)totalElements);//总记录数
        pageGrounp.setTotalPages(page);//当前页
        return pageGrounp;
    }
    /**
     分页查询
     * @param page
     * @param size
     * @param article
     * @return
     */
   public PageGrounp<Article> findByCriteria(Integer page, Integer size,Article article){
        Pageable pageAble= PageRequest.of(page - 1, size);
       Page<Article> all = articleRepository.findAll((Specification<Article>) (root, criteriaQuery, criteriaBuilder) -> {
           List<Predicate> list = new ArrayList<>();
           if (article.getTitle() != null && article.getTitle() != "") {
               Predicate title = criteriaBuilder.like(root.get("title").as(String.class), "%" + article.getTitle() + "%");
               list.add(title);
           }
           if (article.getSubTitle() != null && article.getSubTitle() != "") {
               Predicate subtitle = criteriaBuilder.like(root.get("subTitle").as(String.class), "%" + article.getSubTitle() + "%");
               list.add(subtitle);
           }
           if (article.getArticle() != null && article.getArticle() != "") {
               Predicate article1 = criteriaBuilder.like(root.get("article").as(String.class), "%" + article.getArticle() + "%");
               list.add(article1);
           }

           return criteriaBuilder.and(list.toArray(new Predicate[0]));

       }, pageAble);
       PageGrounp<Article> pageGrounp=new PageGrounp<>();
       pageGrounp.setList(all.getContent());
      pageGrounp.setSize(size);//每页记录数
       long totalElements = all.getTotalElements();

       pageGrounp.setPageSize(all.getTotalPages());//总页数
       pageGrounp.setTotalElements((int)totalElements);//总记录数
       pageGrounp.setTotalPages(page);//当前页
       return pageGrounp;
   }

    /**
     * 增加或修改
     * @param article
     * @return
     */
   public Article add(Article article){
       return  articleRepository.save(article);
    }

    /**
     * 删除
     * @param id
     */
   public void delete(Integer id){
        articleRepository.deleteById(id);
    }

    /**
     * 查出单个
     * @param id
     * @return
     */
    public Article findByOne(Integer id){
       return  articleRepository.getOne(id);
    }
}
