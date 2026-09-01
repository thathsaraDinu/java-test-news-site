package com.example.newsapp.controller;

import com.example.newsapp.entity.News;
import com.example.newsapp.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public String getNews(
            @PathVariable Long id,
            Model model) {

        News news = newsService.getNewsById(id);

        model.addAttribute("news", news);

        return "news-detail";
    }
}