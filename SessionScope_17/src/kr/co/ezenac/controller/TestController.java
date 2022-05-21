package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test1")
//	public String test1(HttpServletRequest request) {
//		HttpSession session = request.getSession();
	//직접 session으로 받기
	public String test1(HttpSession session) {
		session.setAttribute("data1", "문자열1");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data2", "문자열2");
		
		return "redirect:result1";
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data3", "문자열3");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
//	public String result1(HttpServletRequest request) {
//		HttpSession session = request.getSession();
	//직접 session으로 받기
	public String result1(HttpSession session) {
		String data1 = (String)session.getAttribute("data1");
		String data2 = (String)session.getAttribute("data2");
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		
		return "result1";
	}
}
