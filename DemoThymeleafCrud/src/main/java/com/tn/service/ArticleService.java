package com.tn.service;

import com.tn.entity.Article;


import java.util.List;

public interface ArticleService {

    List<Article> getAll();

    Article getById(Integer id);

    void delete(Integer id);
}
