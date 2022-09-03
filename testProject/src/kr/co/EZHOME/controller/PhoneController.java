package kr.co.EZHOME.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.EZHOME.domain.DataStatus;
import kr.co.EZHOME.domain.Phone;



@Controller
public class PhoneController {
	
	@Autowired
	Phone phone;
	
	@GetMapping("/sendMessage.do")
	public String sendMessageDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//발송횟수
		int sendCount = sendCount(request);
		//발송횟수가 5회 이하일 경우에만 재발송을 해준다
		if (sendCount < 5) {
			return "forward:/sendOne";
		}
		
		//발송횟수가 5회 이상일 경우 문자 발송없이 join 창으로
		return "join/phoneCheck";
	}
	
	@PostMapping("/checkUser.do")
	public String checkUserDo(HttpServletRequest request) {
		DataStatus result;
		String message = "";

		// 1. 해당 핸드폰 번호가 있는 userid 가 있는지 DB에 접근해 확인하기
		result = phone.checkPhoneUser(request.getParameter("phone"));
		// 핸드폰번호가 있는 유저가 존재할때
		if (result == DataStatus.Exist) {
			message = "이미 회원가입이 완료된 휴대폰 번호입니다";
		}
		// 핸드폰번호가 있는 유저가 존재하지 않을때
		else {
			message = "휴대폰 번호 인증이 완료되었습니다";
		}
		
		request.setAttribute("message", message);
		return "join/phoneCheckResult";
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
