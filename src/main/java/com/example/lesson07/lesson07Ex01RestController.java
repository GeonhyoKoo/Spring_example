package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C : create
	@GetMapping("/create")
	public StudentEntity create() {
		
		String name = "룰룰루";
		String phoneNumber = "01030421230";
		String email = "rrr123@naver.com";
		String dreamJob = "트레이너";
		
		// save 가 된 객체를 return하므로 id값이 채워진 상태로 돌아온다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	
	
	// U : update
	@GetMapping("/update")
	public StudentEntity update() {
		
		// id가 4번인 dreamJob을 디자이너로 변경
		return studentBO.updateStudentDreamJobById(4 , "디자이너");
		
	}
	
	
	// D : delete
	@GetMapping("/delete")
	public String delete() {
		// id 4번 삭제
		
		studentBO.deleteStudentById(4);
		
		return "삭제 완료"; 
	}
	
	
	
}
