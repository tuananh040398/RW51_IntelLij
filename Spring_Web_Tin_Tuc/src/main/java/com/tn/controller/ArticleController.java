package com.tn.controller;

import com.tn.dto.ArticleDTO;
import com.tn.entity.Article;
import com.tn.repository.ArticleRepository;
import com.tn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String getAll(Model model){
        List<Article> articles = articleService.getAll();

        List<ArticleDTO> articleDTOS = new ArrayList<>();
        articles.forEach(obj -> {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(obj.getId());
            articleDTO.setCategoryName(obj.getCategory().getCategoryName());

            articleDTOS.add(articleDTO);
        });

        model.addAttribute("listArticle", articleDTOS);
        return "article-list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);

        articleService.delete(id);
        return "redirect:/article";
    }

}
