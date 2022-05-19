package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ezenac.beans.DataBean1;



@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");
		
		//request 객체와 함께 result1 요청
		return "forward:/result1";
	}
	
	// result1에 대한 요청이 들어왔을때
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		String data1 = (String)request.getAttribute("data1");
		System.out.printf("data1 : %s\n", data1);
		
		return "result1";
	}
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2", "문자열2");
		
		return "forward:/result2";
	}
	
	//모델을 통해 Attribute에 값을 넣었지만 사용은 똑같이 request로 해야한다
	@GetMapping("/result2")
	public String result2(HttpServletRequest request) {
		String data2 = (String)request.getAttribute("data2");
		System.out.printf("data2 : %s\n", data2);
		
		return "result2";
	}
	
	//객체타입으로 반환하고 싶을때는 ModelAndView를 사용한다
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		mv.addObject("data3", "문자열3");
		mv.setViewName("forward:/result3");
		return mv;
	}
	
	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		String data3 = (String)request.getAttribute("data3");
		System.out.printf("data3 : %s\n", data3);
		
		return "result3";
	}
	
	//DataBean 객체를 이용하여 model.addAttribute 하기
	@GetMapping("/test4")
	public String test4(Model model) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		model.addAttribute("bean1", bean1);
		
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	//Databean1을 Model로 만들어준다
	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
		//Model 객체와 같이 addAttribute를 하지 않고
		//바로 setter 메서드를 사용해도 request에 저장이 되어 사용할 수 있다
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");
		
		//return "test5";
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
	public String result5(HttpServletRequest request) {
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result5";
	}
}
