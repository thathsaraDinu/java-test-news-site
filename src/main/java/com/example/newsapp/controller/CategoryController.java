package com.example.newsapp.controller;

import com.example.newsapp.entity.Category;
import com.example.newsapp.entity.News;
import com.example.newsapp.service.CategoryService;
import com.example.newsapp.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final NewsService newsService;

    public CategoryController(
            CategoryService categoryService,
            NewsService newsService) {

        this.categoryService = categoryService;
        this.newsService = newsService;
    }

    @GetMapping
    public String getCategories(Model model) {

        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("categories", categories);

        return "categories";
    }

    @GetMapping("/{id}/news")
    public String getNewsByCategory(
            @PathVariable Long id,
            Model model) {

        List<News> news = newsService.getNewsByCategory(id);

        model.addAttribute("news", news);
        model.addAttribute("category",
                categoryService.getCategoryById(id));

        return "category-news";
    }
}