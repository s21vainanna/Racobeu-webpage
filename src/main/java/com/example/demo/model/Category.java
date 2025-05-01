package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "language_id")
	private Language language; // kategorijas atkarigas no valodas

	@Column
	@NotBlank
	@Size(max = 100, message = "Title must be less than 100 characters")
	@Pattern(regexp = "[A-Z][a-z0-9 ]+", message = "Only letters and numbers allowed")
	private String title;

	// piekļut pie sadaļām caur kategorijas objektu
	@OneToMany(mappedBy = "category", orphanRemoval = true)
	@ToString.Exclude
	private java.util.List<Section> sections;

}
