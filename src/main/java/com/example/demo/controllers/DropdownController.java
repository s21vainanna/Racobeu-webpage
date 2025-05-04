package com.example.demo.controllers;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.ifaces.CRUDCategoryService;
import com.example.demo.ifaces.CRUDNewsService;
import com.example.demo.ifaces.CRUDSectionService;
import com.example.demo.model.NewsArticle;
import com.example.demo.model.Section;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DropdownController {

    @Autowired
    private CRUDCategoryService categoryService;
    @Autowired
    private CRUDSectionService sectionService;
    @Autowired
    private CRUDNewsService newsArticleService;

    @GetMapping("/section/{sectionId}") // http://localhost:8080/section/1
    public String selectSection(@PathVariable("sectionId") int sectionId, Model model) throws Exception {
        Section section = sectionService.selectById(sectionId);
        model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
        model.addAttribute("section", section);

        // pārvērš attēlu no bytes[] uz base64, lai to  varētu parādīt caur HTML
        if (section.getImage() == null || section.getImage().length == 0) {
            model.addAttribute("imageBase64", null);
        } else {
            String base64Image = Base64.getEncoder().encodeToString(section.getImage());
            model.addAttribute("imageBase64", base64Image);
        }

        // izgūst ID no youtube linka
        if (section.getYoutubeVideo() != null) {
            String videoId = null;
            if (section.getYoutubeVideo().startsWith("https://www.youtube.com/watch?v=")) {
                videoId = section.getYoutubeVideo().replace("https://www.youtube.com/watch?v=", "");
            }
            else if (section.getYoutubeVideo().startsWith("https://youtu.be/")) {
                videoId = section.getYoutubeVideo().replace("https://youtu.be/", "");
            }
            model.addAttribute("youtubeVideoId", videoId);
        }

        return "section-page";
    }

    @GetMapping("/news/{newsId}") // http://localhost:8080/news/1
    public String selectNews(@PathVariable("newsId") int newsId, Model model) throws Exception {
        NewsArticle section = newsArticleService.selectById(newsId);
        model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
        model.addAttribute("section", section);

        // pārvērš attēlu no bytes[] uz base64, lai to  varētu parādīt caur HTML
        if (section.getImage() == null || section.getImage().length == 0) {
            model.addAttribute("imageBase64", null);
        } else {
            String base64Image = Base64.getEncoder().encodeToString(section.getImage());
            model.addAttribute("imageBase64", base64Image);
        }

        // izgūst ID no youtube linka
        if (section.getYoutubeVideo() != null) {
            String videoId = null;
            if (section.getYoutubeVideo().startsWith("https://www.youtube.com/watch?v=")) {
                videoId = section.getYoutubeVideo().replace("https://www.youtube.com/watch?v=", "");
            }
            else if (section.getYoutubeVideo().startsWith("https://youtu.be/")) {
                videoId = section.getYoutubeVideo().replace("https://youtu.be/", "");
            }
            model.addAttribute("youtubeVideoId", videoId);
        }

        return "news-page";
    }

    @GetMapping("/news") // http://localhost:8080/news
    public String selectNewslist(Model model) throws Exception {
        model.addAttribute("newsArticles", newsArticleService.selectAllNewsArticleByCurrentLanguage());
        return "news-list";
    }

}
