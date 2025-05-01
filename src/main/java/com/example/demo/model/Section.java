package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "section")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Section extends PostBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sectionId;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "website_category_id")
	private Category category; // sadaļas atkarīgas pēc kategorijas


}
