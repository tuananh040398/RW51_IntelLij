package com.tn.controller;

import com.tn.entity.Article;
import com.tn.repository.ArticleRepository;
import com.tn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepo;

    @GetMapping
    public String getAll(Model model){
        List<Article> articles = articleService.getAll();
        System.out.println(articles);

        System.out.println(778);

        model.addAttribute("listArticle", articles);

        return "article-list";
    }

    @GetMapping("add")
    public String add(){
        return "article-add";
    }

//    Cách 1
    @PostMapping("save")
    public String save(@ModelAttribute Article article){
        articleRepo.save(article);

        return "redirect:/article";
    }

//    Cách 2
//    @PostMapping("save")
//    public String save(@RequestParam String articleName, @RequestParam String description){
//        System.out.println(articleName);
//        System.out.println(description);
//        return "redirect:/article";
//    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Article article = articleService.getById(id);
        model.addAttribute("article", article);
        return "article-edit";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Article article){
        System.out.println(article);
        articleRepo.save(article);
        return "redirect:/article";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);

        articleService.delete(id);

        return "redirect:/article";
    }
}
