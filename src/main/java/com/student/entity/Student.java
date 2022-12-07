package com.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="student-details")
public class Student {
	
	@Id
	private String id;
	
	@Column(nullable=false)
	@NotNull
	@NotEmpty(message = "Firstname can not be empty")
	private String  firstName;
	
	@Column(nullable=false)
	@NotNull
	@NotEmpty(message = "Lastname can not be empty")
	private String lastName;
	
	@Column(unique=true, nullable=false)
	@Email(message="Email should be formatted")
	private String email;
	
	@Column(unique=true, length=10)
	private Long mobile;
	

}
