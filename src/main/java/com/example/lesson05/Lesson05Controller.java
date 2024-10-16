package com.example.lesson05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("peach");
		fruits.add("mango");
		fruits.add("watermelon");
		
		model.addAttribute("fruits" , fruits);
		
		// List<Map>
		List<Map<String , Object>> users = new ArrayList<>();
		Map<String , Object> user1 = new HashMap<>();
		user1.put("name", "구건효");
		user1.put("age", 32);
		user1.put("hobby", "게임");
		users.add(user1);
		
		Map<String , Object> user2 = new HashMap<>();
		user2.put("name", "김기랑");
		user2.put("age", 20);
		user2.put("hobby", "등산");
		users.add(user2);
		
		model.addAttribute("users", users);
		
		
		return "lesson05/ex02";
	}
	
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date date = new Date();
		model.addAttribute("date", date);
		
		// 연월일까지만 있는 타입 , 시간이 빠진 , 우리나라 시간 기준
		LocalDate localDate = LocalDate.now();
		model.addAttribute("localDate", localDate);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		model.addAttribute("localDateTime", localDateTime);
		
		// utc time, 국제 표준 시간으로 기준
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		model.addAttribute("zonedDateTime", zonedDateTime);
		
		
		return "lesson05/ex03";
	}
	
	
}
