package com.example.demo.model;



import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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
public class Racobeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int racobeu_id;
	
	@NotBlank
	@Pattern(regexp = "[A-Z][a-z ]+", message = "Only letters allowed")
	private String name;
	
	@NotBlank
    @Size(min = 4, max = 10000, message = "Description must be between 4 and 10000 characters")
	@Pattern(regexp = "[A-Za-zĀ-Žā-ž0-9 -.:!,()“”\\r\\n+–—]+", message = "Description can only contain letters, spaces, and punctuation")
	private String description;
	
	@Positive(message = "Contact number must be positive")
	private int contacts;
	
	@OneToMany(mappedBy = "racobeu")
	@ToString.Exclude
	private Collection<Events> events;
	
	@OneToMany(mappedBy = "racobeu")
	@ToString.Exclude
	private Collection<Departments> departments;
	
	@OneToMany(mappedBy = "racobeu")
	@ToString.Exclude
	private Collection<RadioAstronomy_Institutions> radioAstronomy_Institutions;
	
	public Racobeu(String name, String description, int contacts) {
        this.name = name;
        this.description = description;
        this.contacts = contacts;
    }
}
