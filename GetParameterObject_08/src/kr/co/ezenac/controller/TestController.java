package kr.co.ezenac.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezenac.bean.DataBean1;
import kr.co.ezenac.bean.DataBean2;

@Controller
public class TestController {
	/*
	 	Map으로 주입받기
	 	
	 	클라이언트가 전달하는 모든 파라미터의 데이터를 한번에 Map으로 받을 수 있다
	 	단, 동일명으로 2개 이상의 파리미터는 하나만 저장된다
	 	동일 명으로 전달되는 파라미터가 2개 이상이라면 List로 주입 받아야 한다
	 	
	 */
	
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
//		String data3 = map.get("data3");
//		String data33 = map.get("data3");
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		for (String str : data3) {
			System.out.printf("data3 : %s\n", str);
		}
//		System.out.printf("data3 : %s\n", data3);
//		System.out.printf("data33 : %s\n", data33);
		
		return "result";
	}
	
	//RequestParam 의 경우 Map 만 Integer 변환이 불가능하다 (List는 잘됨)
//	@GetMapping("/test1")
//	public String test1(@RequestParam Map<String, Integer> map, @RequestParam List<Integer> data3) {
//		int data1 = map.get("data1"); //여기부터 에러발생 쿼리스트링이 Integer로 형변환이 되지않는다
//		int data2 = map.get("data2");
////		int data3 = map.get("data3");
//		int data33 = map.get("data3");
//
//		System.out.printf("data1 : %d\n", data1);
//		System.out.printf("data2 : %d\n", data2);
//		for (int num : data3) {
//			System.out.printf("data3 : %d\n", num);
//		}
////		System.out.printf("data3 : %s\n", data3);
//		System.out.printf("data33 : %d\n", data33);
//		
//		return "result";
//	}
	
	/*
	 * ModelAttribute 어노테이션을 사용하면 파라미터를 객체로 주입받을 수 있다
	 * 전달되는 파라미터의 이름과 동일한 프로퍼티에 자동으로 주입된다 (mapping 되므로 필드명을 request의 Parameter명과 일치시켜줘야한다)
	 * 이 어노테이션은 생략 가능하다!! (매개변수에 객체만 써줘도 됨)
	 * 이러한 객체를 커맨드 객체 (Command Object) 라고 부른다
	 * 객체를 받을 때에는 형변환이 자동으로 이루어진다
	 */
	@GetMapping("/test2")
	public String test2(@ModelAttribute DataBean1 bean1, @ModelAttribute DataBean2 bean2) {
		System.out.printf("data1 : %d\n", bean1.getData1());
		System.out.printf("data2 : %d\n", bean1.getData2());
		for (int num : bean1.getData3()) {
			System.out.printf("data3 : %d\n", num);
		}
		
		System.out.printf("data1 : %d\n", bean2.getData1());
		System.out.printf("data2 : %d\n", bean2.getData2());
		
		return "result";
	}
}
