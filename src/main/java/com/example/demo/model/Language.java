package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "language")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageId;

	@Column()
	@Size(max = 100, message = "Name must be less than 100 characters")
	@NotBlank
	@Pattern(regexp = "[A-Z][a-z ]+", message = "Only letters allowed")
	private String name;

	@NotBlank
	@Size(max = 2, message = "Code must be less than 2 characters")
	@Pattern(regexp = "[A-Z][a-z ]+", message = "Only letters allowed")
	@Column(unique = true)
	private String languageCode;


}
