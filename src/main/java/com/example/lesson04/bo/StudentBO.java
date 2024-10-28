package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	
	// JPA
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder().name(name).phoneNumber(phoneNumber).email(email)
				.dreamJob(dreamJob).createdAt(LocalDateTime.now()).build();    // @CreationTimestamp 있으면 생략가능하다.
		
		return studentRepository.save(student);
		
	}
	
	
	public Student selectStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		
		// 기존 데이터 조회 - id로 entity조회해서 가져옴
		// orElse optional이 없으면 null을 넣겠다.
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		
		// 그 데이터가 존재할 때 업데이트를 진행함. -> update jpa가 없어서 save()를 새로함.
		// pk의 유무에 따라 값이없을땐 insert 있으면 update를 해버림
		if (student != null) { // null이 아닐때만 업데이트를 해야하니까
			// 조회된 데이터가 있을 때 업데이트 진행
			
			// 변경할 내용을 엔티티에 세팅 후 save(id가 있어서) update
			student = student.toBuilder().dreamJob(dreamJob).build(); // 저장을 반드시 하거나 Args에 넣거나
			
			studentRepository.save(student);
		}
		
		return student;
	}
	
	
	// delete
	public void deleteStudentById(int id) {
		
		// 방법 1) 삭제할 대상 select -> 삭제
//		StudentEntity student =  studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법 2) 삭제할 대상 select -> 삭제
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
		
	}
	
}
