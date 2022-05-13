package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ezenac.beans.DataBean;

@Controller
public class TestController {
	/*
	 * 커맨드 객체
	 * 클라이언트가 전달해 주는 파라미터 데이터를 주입 받기 위해 사용하는 객체
	 * 커맨드 객체는 HttpServletRequest 객체에 자동으로 저장되고 jsp로 전달된다
	 * 이 때, HttpServletRequest 객체에 저장되는 이름은 클래스 이름으로 결정된다
	 * HttpServletRequest에 저장되는 이름을 지정하고 싶다면 ModelAttribute 어노테이션에 지정하면된다
	 * 
	 */
	
	@PostMapping("/test1")
//	public String test1(@ModelAttribute DataBean bean) {
	//생략가능
	public String test1(DataBean bean) {
		System.out.printf("data1 : %s\n", bean.getData1());
		System.out.printf("data2 : %s\n", bean.getData2());
		
		return "test1";
	}
	
	@PostMapping("/test2")
	public String test2(@ModelAttribute("testData") DataBean bean) {
		System.out.printf("data1 : %s\n", bean.getData1());
		System.out.printf("data2 : %s\n", bean.getData2());
		return "test2";
	}
	
}
