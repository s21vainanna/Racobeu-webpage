package com.example.demo.model;

import java.sql.Date;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass // nepieciešams, lai mantotās klases iegūtu šīs klases laukus
@Getter
@Setter
@ToString
public abstract class PostBase {
	/*  bāzes klase NewsArticle un WebsiteSection klasēm
	  lai saturētu kopīgos laukus un tos
	  nebūtu jāraksta divreiz
	*/

	@NotBlank
	@Size(max = 100, message = "Title must be less than 100 characters")
	@Column
	private String title;

	@Size(max = 500, message = "Short into must be less than 500 characters")
	@Column
	private String shortIntro;

	@NotBlank
	@Column(columnDefinition = "TEXT") // atļauj glabāt garu tekstu
	private String text;

	@Lob // atļauj glabāt attēlu
	@Basic(fetch = FetchType.LAZY) // neieladet attelu uzreiz, bet tikai ja nepieciešams
    @Column(columnDefinition = "MEDIUMBLOB") // atļauj glabāt attēlu
    private byte[] image;


	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") // pēc noklusejuma šodienas datums
	private Date createdDate;


	@ManyToOne
	@JoinColumn(name = "author_id")
	private Administrator author; // lietotājs, kurš pievienoja šo sadaļu

	@URL
	@Size(max = 100, message = "Youtube video must be less than 100 characters")
	@Column
	private String youtubeVideo;
}
