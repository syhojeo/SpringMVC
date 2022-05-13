package kr.co.ezenac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	//get 방식만
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String Test1_get() {
		
		return "test1";
	}
	
	//post방식만
	@RequestMapping(value="/test2",method=RequestMethod.POST)
	public String Test2_post( ) {
		
		return "test2";
	}
	
	// get
	@RequestMapping(value="/test3",method=RequestMethod.GET)
	public String Test3_get( ) {
		
		return "test3_get";
	}
	
	//post (value가 위와 같아도 문제(ambiguous)가 발생하지 않는다 method 방식이 다르기 때문)
	@RequestMapping(value="/test3",method=RequestMethod.POST)
	public String Test3_post( ) {
		
		return "test3_post";
	}
	
	//RequestMapping 이 아닌 GetMapping으로 미리 방식지정
	@GetMapping("/test4")
	public String test4() {
		
		return "test4";
	}
	
	//post
	@PostMapping("/test5")
	public String test5() {
		
		return "test5";
	}
	
	//요청명이 test6로 같더라도 get 방식의 요청인지, post 방식의 요청인지에 따라 메서드 분류
	@GetMapping("/test6")
	public String test6_get() {
		
		return "test6_get";
	}
	
	@PostMapping("/test6")
	public String test6_post() {
		
		return "test6_post";
	}
	
	//두가지 한번에
	@RequestMapping(value="/test7", method= {RequestMethod.GET, RequestMethod.POST})
	public String test7() {
		
		return "test7";
	}
	
	//get 방식으로 들어오던지 post 방식으로 오던지 post 방식처럼 처리할때
	@GetMapping("/test8")
	public String test8_get() {
		
		return test8_post();
	}
	
	@PostMapping("/test8")
	public String test8_post() {
		
		return "test8";
	}
}
