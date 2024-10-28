package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString  			// 출력할 때 해쉬값이 아닌 값으로 나옴 domain도 가능
@AllArgsConstructor  // parameter 모두 있는 생성자
@NoArgsConstructor   // parameter 없는 생성자(기본)
@Builder(toBuilder = true)			// setter 대신 사용 , (처음 세팅만됨 그냥 builder) , toBuilder = true 필드 수정 허용
@Getter
@Entity				// 이 객체는 entity다. DB - JPA 통신
@Table(name ="new_student")
public class StudentEntity {
	
	@Id  // pk 식별자 , unique 키가 여러개인걸 찾아보자
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // insert 시 방금 들어간 id 가져옴.  
	private int id;
	private String name;
	
	@Column(name="phoneNumber")   // 컬럼명이 카멜 케이스일때 알려주는 것
	private String  phoneNumber;
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@CreationTimestamp   // 값이 null이어도 insert되는 시간으로 들어감
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // insert/update 그 시간으로 들어감
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
	
}
