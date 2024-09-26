package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 여러 페이지 겹치는 것만
@RequestMapping("/lesson01/ex01") // 클래스에 있는 패스를 먼저 읽어 들인다.
@Controller // spring bean으로 등록
public class Lesson01Ex01Controller {

	//singleton 디자인으로 생성된다.
	
	
	//http://localhost:8080/lesson01/ex01/1
	// String 을 브라우저에 출력 
	@ResponseBody // return되는 String은 Response body에 넣어지고 HTML 응답
	@RequestMapping("/1")
	public String ex01_1() {
		return "<h2>문자열을 ResponseBody에 보내는 예제</h2>";
	}
	
	
	//http://localhost:8080/lesson01/ex01/2
	// map 리턴 -> JSON String
	// responsebody 두번째 사용방법 
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2(){
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 10);
		map.put("포도", 80);
		map.put("귤", 15);
		
		// map을 return하면 json String이 된다.
		// web starter에 jackson 라이브러리가 있기 때문
		return map;
	}
	
}
