package kr.co.ezenac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ezenac.beans.DataBean;
import kr.co.ezenac.database.MapperInterface;

@Controller
public class TestController {
	
	@Autowired
	MapperInterface mapper1;
	
	@GetMapping("/input_data")
	public String input_data() {
		
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(DataBean dataBean) {
		mapper1.insert_data(dataBean);
		
		return "input_pro";
	}
	
}
