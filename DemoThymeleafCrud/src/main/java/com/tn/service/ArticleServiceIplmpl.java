package com.tn.service;

import com.tn.entity.Article;
import com.tn.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceIplmpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepo;

    @Override
    public List<Article> getAll() {
        return articleRepo.findAll();
    }

    @Override
    public Article getById(Integer id) {
        Article article = articleRepo.findById(id).get();
        return article;
    }

    @Override
    public void delete(Integer id) {
        articleRepo.deleteById(id);
    }

}
