package kr.co.ezenac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PhoneController {
	
	@GetMapping("sendMessage.do")
	public String sendMessageDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String certificationNumber;
		SendMessage send = new SendMessage();
		//발송횟수
		int sendCount = sendCount(request);
		//발송횟수가 5회 이하일 경우에만 재발송을 해준다
		if (sendCount < 5) {
			certificationNumber = send.sendMessage(request.getParameter("phone"));
			request.setAttribute("certificationNumber", certificationNumber);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/join/phoneCheck.jsp");
		return "join/phoneCheck";
	}
}
