package com.example.demo.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class RadioAstronomy_Institutions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int radioAstronomy_institutions_id;
	
	@NotBlank
	@Pattern(regexp = "[A-Z][a-z ]+", message = "Only letters allowed")
	private String name;
	
	@NotBlank
	@Pattern(regexp = "[A-Za-z0-9.,'\\- ]+", message = "Location can include letters, numbers, spaces, commas, and hyphens")
	private String location;
	
	@NotBlank
    @Size(min = 4, max = 10000, message = "Description must be between 4 and 10000 characters")
    @Pattern(regexp = "[A-Za-z .:!]+", message = "Description can only contain letters, spaces, and punctuation")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "racobeu_id")
	private Racobeu racobeu;
	
	@OneToMany(mappedBy = "radioAstronomy_Institutions")
	@ToString.Exclude
	private Collection<Radioteleskopi> radioteleskopi;
	
	@OneToMany(mappedBy = "radioAstronomy_Institutions")
	@ToString.Exclude
	private Collection<Scientific_Research> scientific_researches;

    public RadioAstronomy_Institutions(String name, String location, String description, Racobeu racobeu) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.racobeu = racobeu;
    }

}


