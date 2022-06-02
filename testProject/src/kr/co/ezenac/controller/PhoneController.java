package kr.co.ezenac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PhoneController {
	
	@GetMapping("/sendMessage.do")
	public String sendMessageDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//발송횟수
		int sendCount = sendCount(request);
		//발송횟수가 5회 이하일 경우에만 재발송을 해준다
		if (sendCount < 5) {
			return "forward:/sendOne";
		}
		
		//발송횟수가 5회 이상일 경우 문자 발송없이 join 창으로
		return "join/phoneCheck";
	}
	
	public int sendCount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int count = 1;
		//처음 전송했을떄 1로 초기화
		if (!(request.getParameter("first") == null)) {
			session.setAttribute("sendCount", 1);
		}
		//발송횟수가 1회 이상일경우 이전 session 값 가져와서 +1
		else {
			count = (Integer)session.getAttribute("sendCount") + 1;
			session.setAttribute("sendCount", count);
		}
		
		return count;
	}
}
