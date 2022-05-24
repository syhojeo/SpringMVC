package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.ezenac.beans.DataBean1;

@Controller
//session Attribute를 통해 해당 이름에 session 적용
@SessionAttributes({"sessionBean1", "sessionBean2"})
public class TestController {
	//session에서 sessionBena1 객체 생성
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}
	
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
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {

			DataBean1 bean1 = new DataBean1();
			bean1.setData1("문자열4");
			bean1.setData2("문자열5");
			
			session.setAttribute("bean1", bean1);
			
			return "test4";

	}
	
	@GetMapping("/result4")
	//public String result4(HttpSession session) {
	//세션에 이미 bean1 객체가 있다면 DataBean1에 주입 (없을경우 session을 찾지 못했다는 missing 에러가 뜬다)
		public String test4(@SessionAttribute("bean1") DataBean1 bean1) {
		//DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	//result4 와 다르게 sessionBean1, sessionBean2를 위에서 정의해놨기 때문에 (18~26줄 , sessionAttributes 설정)
	//session을 test4에서와 같이 만들지 않고도 missing 메시지가 뜨지않고 사용가능하다
	
	//1. 18~26줄에서 sessionBean1 을 정의 및 저장
	//2. 매개변수 DataBean1 sessionBean1, sessionBean2 를 씀으로써 1번 자동주입  + @modelAttribute 적용 이름은 "sessionBean1"
	//3. sessionBean1.setData1을 통한 데이터 입력
	//modelAttribute 어노테이션을 통해 requestScope, sessionScope 모두 사용가능
	public String test5(@ModelAttribute("sessionBean1")DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2")DataBean1 sessionBean2)	 {
		sessionBean1.setData1("문자열6");
		sessionBean1.setData2("문자열7");
		
		sessionBean2.setData1("문자열8");
		sessionBean2.setData2("문자열9");
		
		return "test5";
	}
}
