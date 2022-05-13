package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	@GetMapping(value="/test1")
	public String test1(HttpServletRequest request) {
		
		String data1=request.getParameter("data1");
		String data2=request.getParameter("data2");
		//String data3=request.getParameter("data3");
		String[] data3=request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		//System.out.println("data3 : " + data3);
		
		for (String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		
		return "result";
	}
	
	@PostMapping(value="/test2")
	public String test2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String data3[] = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		//null 일때 for each 문을 통해 가져오려하면 null pointer exception 이 발생함
		if (data3 != null) {
			for (String str1 : data3) {
				System.out.println("data3 : " + str1);
			}
		}
		
		return "result";
	}
	
	//WebRequest 사용
	@GetMapping(value="/test3")
	public String test3(WebRequest request) {
		
		String data1=request.getParameter("data1");
		String data2=request.getParameter("data2");
		String[] data3=request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for (String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		
		return "result";
	}
	
	//Get 방식으로 test4/100/200/300 이런식으로 값만 넘어올경우 => 이 경우 test? 가아닌 test/ 으로 get방식 요청해야함
	//그래야 매핑에서 문제가 생기지 않는다
	@GetMapping(value="/test4/{data1}/{data2}/{data3}") 
	public String test4(@PathVariable int data1, 
						@PathVariable int data2, 
						@PathVariable int data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		return "result";
	}
	
	/*
	 *	@RequestParam 
	 * 	파라미터 데이터를 직접 주입 받을 수 있다
	 *	지정된 변수의 이름과 파라미터 이름이 같을 경우
	 *	가능한 경우 형 변환도 처리한다
	 *	value : 파라미터 이름과 변수의 이름이  다를 경우 파라미터 이름을 지정한다
	 *	required : false를 설정하면 지정된 이름의 파라미터가 없을 경우 null이 주입된다
	 */
	
	//@RequestParam
	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int [] data3) {
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for (int num : data3) {
			System.out.println("data3 : " + num);
		}
		
		return "result";
	}
	
	
	//@RequestParam 변수 이름 바꾸기
	@GetMapping("/test6")
	public String test6(@RequestParam(value="data1") int value1,
						@RequestParam(value="data2") int value2,
						@RequestParam(value="data3") int [] value3) {
		
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		
		for (int num : value3) {
			System.out.println("value3 : " + num);
		}
		
		return "result";
	}
	
	//required = false 의 경우 변수값에 null을 넣어줌으로 무조건 String 타입에만 사용할 수 있다
	//int 타입은 null을 저장할 수 없기 때문이다
	
	@GetMapping("/test7")
	public String test7(@RequestParam int data1,
						@RequestParam(required=false) String data2,
						@RequestParam(defaultValue= "0") int data3) {

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);


		return "result";
			
	}

}
