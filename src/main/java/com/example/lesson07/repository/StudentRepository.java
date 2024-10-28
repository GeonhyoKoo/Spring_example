package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity , Integer>{
	
	// 순수한 JPA vs Spring Data JPA
	// Spring Data JPA
	
	// public StudentEntity save(StudentEntity studentEntity);
	
	// public StudentEntity findById(int id);
	// 정확하게는 public Optional<StudentEntity> findById(int id);
	// 이 감싸져있음 optional은 널인지 아닌지를 판별해주는 방식
	
	// public void delete(StudentEntity studentEntity);
	
	
	// 조회
	// jpa가 제공하는 기본 메소드 : 전체 가져오기
	// public List<StudentEntity> findAll();
	
	
	// 상세 조회 만들기 -> method를 규칙에 맞게 만들기
	// ex02/select1 -> 메소드 규칙 -> JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String nnnn); // 변수명은 상관없음 메소드로 검사하기 때문에
	public List<StudentEntity> findByNameIn(List<String> names); // 변수명은 상관없음 메소드로 검사하기 때문에
	public List<StudentEntity> findByNameAndDreamJob(String e , String dj); // 변수명은 상관없음 메소드로 검사하기 때문에
	public List<StudentEntity> findByEmailContains(String keyword); // 변수명은 상관없음 메소드로 검사하기 때문에
	public List<StudentEntity> findByNameStartingWith(String keyword); // 변수명은 상관없음 메소드로 검사하기 때문에
	public List<StudentEntity> findByIdBetween(int s , int e); // 변수명은 상관없음 메소드로 검사하기 때문에
	
	
	// ex02/select2 -> JPQL (쿼리문처럼 생겼지만 엔티티에 조회) - SQL 쿼리문 아님
	// * 은 엔티티의 모든 것 , s 는 앞에 as 별칭 생략가능해서 생략한 것
//	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob")
//	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
	// ex02/select2 -> sql 쿼리문 - native query 
	// EntityManager 안쓰고 직접 DB에 쿼리날릴꺼다 -> native query
	// nativeQuery는 기본으론 false
	@Query(value = "select * from new_student where dreamJob = :dreamJob" , nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
	
	
}

