package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	/*
	 * ViewResolver
	 * 
	 * 컨트롤러에서 전달 받은 View의 이름을 토대로 jsp를 찾아 선택하고 jsp 데이터를 분석해 응답 결과를 만들어 전달한다
	 * ViewResolver가 사용할 View의 이름을 지정하는 방법과 jsp를 통해 응답 결과를 만들 때 필요한 데이터를 전달
	 * 
	 * 
	 * Model
	 * 
	 * Model 객체를 주입 받아 세팅하면 HttpServletRequest 객체에 담겨 이를 JSP로 전달할 수 있다
	 * 
	 * ModelAndView
	 * 
	 * ModelAndView는 Model에 값을 세팅하는 기능과 view의 이름을 지정하는 기능을 모두 가지고 있다
	 * 
	 * ViewResolver에 의해 JSP가 실행되고 응답 결과가 만들어진다
	 * 
	 * Controller에서 View 를 저장할 때 ViewResolver 가 사용할 데이터를 Request
	 */
	
	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		request.setAttribute("data1", 100);
		request.setAttribute("data2", 200);
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model) {
		//request.setAttribute처럼 jsp 에서 사용가능하다
		model.addAttribute("data1", 300);
		model.addAttribute("data2", 400);
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("data1", 500);
		mv.addObject("data2", 600);
		
		mv.setViewName("test4");
		
		return mv; 
	}
}
