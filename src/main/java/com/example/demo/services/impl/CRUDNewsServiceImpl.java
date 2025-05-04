package com.example.demo.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.model.NewsArticle;
import com.example.demo.repo.NewsArticleRepository;

@Service
public class CRUDNewsServiceImpl implements com.example.demo.ifaces.CRUDNewsService {

	@Autowired
	private NewsArticleRepository newsArticleRepository;

	@Override
	public NewsArticle selectById(int id) throws Exception {
		NewsArticle newsArticle = newsArticleRepository.findById(id).orElse(null);

		if (newsArticle == null) {
			throw new Exception("NewsArticle not found");
		}
		return newsArticle;
	}

	@Override
	public ArrayList<NewsArticle> selectAllNewsArticle() {
		return (ArrayList<NewsArticle>) newsArticleRepository.findAll();
	}

	@Override
	public NewsArticle saveNewsArticle(NewsArticle section) {
		NewsArticle newsArticle = new NewsArticle();
		newsArticle.setNewsArticleId(section.getNewsArticleId());
		newsArticle.setImage(section.getImage());
		newsArticle.setShortIntro(section.getShortIntro());
		newsArticle.setText(section.getText());
		newsArticle.setTitle(section.getTitle());
		newsArticle.setAuthor(section.getAuthor());
		newsArticle.setCreatedDate(section.getCreatedDate());
		newsArticle.setLanguage(section.getLanguage());
		newsArticle.setCreatedDate(new Date(System.currentTimeMillis()));
		newsArticle.setYoutubeVideo(section.getYoutubeVideo());
		return newsArticleRepository.save(newsArticle);
	}

	@Override
	public void deleteNewsArticle(int id) throws Exception {
		if (!newsArticleRepository.existsById(id)) {
			throw new Exception("NewsArticle not found");
		}

		newsArticleRepository.deleteById(id);
	}

	@Override
	public ArrayList<NewsArticle> selectAllNewsArticleByCurrentLanguage() {
		String currentLanguage = getCurrentLanguage();
		return newsArticleRepository.findAllByLanguageLanguageCode(currentLanguage);
	}

	// nosaka patreizejo lietotaja valodu
	private String getCurrentLanguage() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        return currentLocale.getLanguage();
    }

}
