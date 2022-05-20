package kr.co.ezenac.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;
import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.DataBean4;


@Controller
public class TestController {

	@Autowired //타입을 통한 자동 주입
	@Lazy // 서버가 시작할때 자동으로 주입해주는걸 막아준다 (충돌이 일어나기 때문에 Lazy를 넣어야 에러가 뜨지 않는다)
			// 요청이발생하지도 않았을때 주입되기 때문에 반드시 넣어줘야한다
	DataBean1 requestBean1;
	
	@Resource(name="requestBean2") //이름을 통한 주입을 했을때에는 model 을 통해 request에 값을 넣어주지 않아도 된다
	@Lazy
	DataBean2 requestBean2;
	
	@Autowired
	@Lazy
	DataBean3 requestBean3;
	
	@Resource(name="requestBean4")
	@Lazy
	DataBean4 requestBean4;
	
	@GetMapping("/test1")
	public String test1() {
		requestBean1.setData1("문자열1");
		requestBean1.setData2("문자열2");
		
		requestBean2.setData3("문자열3");
		requestBean2.setData4("문자열4");
		
		requestBean3.setData5("문자열5");
		requestBean3.setData6("문자열6");
		
		requestBean4.setData7("문자열7");
		requestBean4.setData8("문자열8");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.printf("requestBean1.data1 : %s\n", requestBean1.getData1());
		System.out.printf("requestBean1.data2 : %s\n", requestBean1.getData2());
		
		System.out.printf("requestBean2.data3 : %s\n", requestBean2.getData3());
		System.out.printf("requestBean2.data4 : %s\n", requestBean2.getData4());
		
		System.out.printf("requestBean3.data5 : %s\n", requestBean3.getData5());
		System.out.printf("requestBean3.data6 : %s\n", requestBean3.getData6());
		
		System.out.printf("requestBean4.data7 : %s\n", requestBean4.getData7());
		System.out.printf("requestBean4.data8 : %s\n", requestBean4.getData8());
		
		model.addAttribute("requestBean1", requestBean1);
		//이름을 통한 자동주입이 되었기 때문에 model을 통해서 request에 값을 넣으면 에러가 발생한다 (주의!)
//		model.addAttribute("requestBean2", requestBean2);
		model.addAttribute("requestBean3", requestBean3);
		//ComponentScan은 ByName 이어도 model을 통한 requet값을 넣어줘야한다
		model.addAttribute("requestBean4", requestBean4);
		return "result1";
	}
}
