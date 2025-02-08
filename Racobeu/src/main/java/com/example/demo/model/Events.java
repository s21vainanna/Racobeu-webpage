package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int events_id;
	
	@NotNull(message = "Date is required")
	private Date date;
	
	@NotBlank
    @Size(min = 4, max = 10000, message = "Description must be between 4 and 10000 characters")
    @Pattern(regexp = "[A-Za-z .:!]+", message = "Description can only contain letters, spaces, and punctuation")
	private String description;
	
	@NotBlank(message = "Spot is required")
	@Pattern(regexp = "[A-Za-z0-9.,'\\- ]+", message = "Spot can include letters, numbers, spaces, commas, and hyphens")
	@Size(min = 2, max = 100, message = "Spot must be between 2 and 100 characters")
	private String spot;
	
	@ManyToOne
	@JoinColumn(name = "racobeu_id")
	private Racobeu racobeu;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Departments departments;
	
	public Events(Date date, String description, String spot, Racobeu racobeu, Departments departments) {
	    this.date = date;
	    this.description = description;
	    this.spot = spot;
	    this.racobeu = racobeu;
	    this.departments = departments;
	}

}
