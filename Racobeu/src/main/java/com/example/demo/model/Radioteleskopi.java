package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Radioteleskopi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int radioteleskopi_id;
	
	@NotBlank
	@Pattern(regexp = "[A-Z][a-z ]+", message = "Only letters allowed")
	private String name;
	
	@NotBlank
    @Size(min = 4, max = 10000, message = "Description must be between 4 and 10000 characters")
    @Pattern(regexp = "[A-Za-z .:!]+", message = "Description can only contain letters, spaces, and punctuation")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "radioAstronomy_institutions_id")
	private RadioAstronomy_Institutions radioAstronomy_Institutions;
	
	public Radioteleskopi( String name, String description, RadioAstronomy_Institutions radioAstronomy_Institutions ) {
		this.name = name;
		this.description = description;
		this.radioAstronomy_Institutions = radioAstronomy_Institutions;
	}

}
