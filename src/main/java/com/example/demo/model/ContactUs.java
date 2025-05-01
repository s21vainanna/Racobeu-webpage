package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "contact_us")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactUs{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactUsId;

	@Column
	@NotBlank
	@Size(max = 100, message = "Name must be less than 100 characters")
	private String name;

	@NotBlank
	@Size(max = 100, message = "Email must be less than 100 characters")
	@Column
	@Email
	private String email;

	@NotBlank
	@Size(max = 1000, message = "Message must be less than 1000 characters")
	@Column
	private String message;


	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //automatiski šodienas datumu
	private Date savedDate;

}
