package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.NewsArticle;
import com.example.demo.model.Section;

public interface CRUDNewsService {
	NewsArticle selectById(int id) throws Exception;

	ArrayList<NewsArticle> selectAllNewsArticleByCurrentLanguage();

	ArrayList<NewsArticle> selectAllNewsArticle();

	NewsArticle saveNewsArticle(NewsArticle section);

	void deleteNewsArticle(int id) throws Exception;
}
