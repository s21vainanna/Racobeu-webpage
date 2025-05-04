package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;
import com.example.demo.model.NewsArticle;

@Repository
public interface NewsArticleRepository extends CrudRepository<NewsArticle, Integer> {
	
	// atrod visas ziņas pec valodas koda
	// SELECT * FROM news_article WHERE language_id = ?
	// NewsArticle.Language.languageCode
	ArrayList<NewsArticle> findAllByLanguageLanguageCode(String languageCode);

}
