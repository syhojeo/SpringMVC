package kr.co.ezenac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String test1() {
		
		return "test1";
	}
	
	//  "/test2" 에 대한 요청이 들어오면 "test2"(test2.jsp)를 리턴해준다
	@RequestMapping(value="/test2",method=RequestMethod.GET)
	public String test2() {
		
		return "test2";
	}
}
