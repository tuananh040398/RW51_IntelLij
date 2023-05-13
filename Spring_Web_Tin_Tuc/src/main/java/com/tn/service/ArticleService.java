package com.tn.service;

import com.tn.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAll();

    void delete(Integer id);
}
