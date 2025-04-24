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
public class Departments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int department_id;
	
	@NotBlank
	@Pattern(regexp = "[A-Z][a-z ]+", message = "Only letters allowed")
	private String name;
	
	@NotBlank
    @Size(min = 4, max = 10000, message = "Description must be between 4 and 10000 characters")
    @Pattern(regexp = "[A-Za-z .:!]+", message = "Description can only contain letters, spaces, and punctuation")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "racobeu_id")
	private Racobeu racobeu;
	
	@OneToMany(mappedBy = "departments")
	@ToString.Exclude
	private Collection<Events> events;
	
	public Departments(String name, String description, Racobeu racobeu) {
		this.name = name;
		this.description = description;
		this.racobeu = racobeu;
	}

}
