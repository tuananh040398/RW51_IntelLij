package com.tn.service;

import com.tn.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    void delete(Integer id);
}
