package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class lesson07Ex02RestController {

	// 이번에만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/select1")
	public List<StudentEntity> select1(){
		
		// 1) 전체 조회
		//return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
		//return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개 행 조회
		//return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 "유재석" 인 데이터 조회
		//return studentRepository.findByName("유재석");
		
		// 5) 이름이 "유재석" "조세호" 인 데이터 조회
		// in문으로 일치하는 이름 값 조회
		//return studentRepository.findByNameIn(List.of("유재석" , "조세호"));
		
		// 6) 여러 컬럼 값과 일치하는 데이터 조회
		// 이름 : 조세호 , 장래희망 : 변호사
		//return studentRepository.findByNameAndDreamJob("조세호" , "변호사");
		
		// 7) email 에 naver 가 포함된 데이터 조회하기 - like %naver%
		//return studentRepository.findByEmailContains("naver");
		
		// 8) 이름이 룰로 시작하는게 있는지 조회 - like 룰%
		//return studentRepository.findByNameStartingWith("룰");
		
		// 9) id 구간이 2 ~ 5까지 조회 id >= 2 and id <= 5 // between id 2 and 5
		return studentRepository.findByIdBetween(2 , 5);
		
		
		
	}
	
	
	// 
		@GetMapping("/select2")
		public List<StudentEntity> select2(){
			
			// 장래희망이 '변호사' 조회
			return studentRepository.findByDreamJob("변호사");
			
			
		}
	
}
