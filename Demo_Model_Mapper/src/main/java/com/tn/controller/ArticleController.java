package com.tn.controller;

import com.tn.dto.ArticleDTO;
import com.tn.entity.Article;
import com.tn.repository.ArticleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ArticleRepository articleRepo;

    @GetMapping
    public List<Article> getAll(){

        return articleRepo.findAll();
    }

    @GetMapping("getById")
    public ArticleDTO getById(){
        Article article = articleRepo.findById(4).get();
        System.out.println("article");
        System.out.println(article);

        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        System.out.println("articleDTO");
        System.out.println(articleDTO);

//        ArticleDTO articleDTO = new ArticleDTO();
//        articleDTO.setId(article.getId());
//        articleDTO.setArticleName(article.getArticleName());
//        articleDTO.setDescription(article.getDescription());

        return articleDTO;
    }

}
