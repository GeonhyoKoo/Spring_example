package com.example.lesson04.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Student {

	
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJob;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
}
