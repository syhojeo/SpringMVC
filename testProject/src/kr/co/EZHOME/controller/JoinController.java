package kr.co.EZHOME.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JoinController {

	@GetMapping("/terms")
	public String terms() {
		
		return "join/terms";
	}
}
