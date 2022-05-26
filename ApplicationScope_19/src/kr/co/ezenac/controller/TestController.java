package kr.co.ezenac.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezenac.beans.DataBean1;

@Controller
public class TestController {
	
	
	
	/*
	  	ServletContext
	  	웹 어플리케이션 단위로 정보를 서버 쪽에 유지할 수 있는 방법은 ServletContext 객체를 사용하는 것이다

	 */
	@Autowired
	ServletContext application;
	
	/*
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
	
		ServletContext application=request.getServletContext();
		application.setAttribute("data1", "문자열1");
		
		return "test1";
	}
	*/
	
	@GetMapping("/test1")
	public String test1() {
		application.setAttribute("data1", "문자열1");
		
		DataBean1 bean1=new DataBean1();
		bean1.setData1("data1");
		bean1.setData2("data2");
		
		application.setAttribute("bean1",bean1);
		
		return "test1";
	}
	
	
	/*
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
	
		ServletContext application=request.getServletContext();
		String data1=(String)application.getAttribute("data1");
		
		System.out.printf("data1 : %s\n",data1);
		
		return "result1";
	}
	*/
	
	
	@GetMapping("/result1")
	public String result1() {
		String data1=(String)application.getAttribute("data1");
		System.out.printf("data1 : %s\n",data1);
		
		DataBean1 bean1=(DataBean1)application.getAttribute("bean1");
		System.out.printf("bean1.data1 : %s\n",bean1.getData1());
		System.out.printf("bean1.data2 : %s\n",bean1.getData2());
		
		return "result1";
	}
	
	
}
	
















