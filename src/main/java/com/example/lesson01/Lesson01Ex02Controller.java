package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 이동
@Controller // spring bean, html로 보낼 때는 @ResponseBody 절대 있으면 안됨
public class Lesson01Ex02Controller {

	// http://localhost/lesson01/ex02
	
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// return 되는 String 은 HTML 의 경로
		// @ResponseBody가 없어야 한다.
		
		// templates/  lesson01/ex02  .html
		return "lesson01/ex02"; // response, html view 경로 위에 주소와 전혀 상관 없
	}
	
}
