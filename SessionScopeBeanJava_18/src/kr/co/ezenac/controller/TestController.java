package kr.co.ezenac.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;
import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.DataBean4;

@Controller
public class TestController {
	// SessionScope  처음 요청시 한번만 주입
	@Autowired
	DataBean1 sessionBean1;
	
	// SessionScope  처음 요청시 한번만 주입
	@Resource(name="sessionBean2")
	DataBean2 sessionBean2;
	
	@Autowired
	DataBean3 sessionBean3;
	
	@Resource(name="sessionBean4")
	DataBean4 sessionBean4;
	
	
	
	@GetMapping("/test1")
	public String test1() {
		sessionBean1.setData1("data1");
		sessionBean1.setData2("data2");
		
		sessionBean2.setData3("data3");
		sessionBean2.setData4("data4");
		
		return "test1";
	}
	
	@GetMapping("/result1")
	//public String result1() {
	  public String result1(Model model) {
		System.out.printf("sessionBean1.data1 : %s\n",sessionBean1.getData1());
		System.out.printf("sessionBean1.data2 : %s\n",sessionBean1.getData2());
		
		System.out.printf("sessionBean2.data3 : %s\n",sessionBean2.getData3());
		System.out.printf("sessionBean2.data4 : %s\n",sessionBean2.getData4());
		
		model.addAttribute("sessionBean1",sessionBean1);
		model.addAttribute("sessionBean2",sessionBean2);
		
		return "result1";
	}
	
}
