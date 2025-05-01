package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "administrators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrator{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Only letters and numbers allowed")
	@Column(unique = true) // nedrikst but divi lietotaji ar vienu lietotājvardu
	private String username;

	@NotBlank
	@Column
	private String password;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //automatiski šodienas datumu
	private Date registationDate;

}
