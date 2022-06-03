package kr.co.ezenac.controller;

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

import kr.co.ezenac.database.MapperInterface;
import kr.co.ezenac.domain.CoolSMSKey;
import kr.co.ezenac.domain.LoginStatus;
import kr.co.ezenac.domain.User;

@Controller
public class LoginController {
	
	@Autowired
	MapperInterface mapper;

	//로그인
	@PostMapping("/login.do")
	public String loginDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login/login";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		User user;
		
		try {
			validate(userid, pwd);
			user = mapper.findUser(userid);
		}catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			e.printStackTrace();
			return url;
		}
		
		LoginStatus result = user.login(pwd);
		
		if (result == LoginStatus.LOGIN_SUCCESS) {
			makeSession(request, user);
			request.setAttribute("message", "로그인 되었습니다.");
			url = "index";
		} else if (result == LoginStatus.PASSWORD_WRONG) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}
		return url;
	}
	
	//아이디 찾기
	@GetMapping("/findId")
	public String findId() {
		
		return "login/findId";
	}
	
	//비밀번호 찾기
	@GetMapping("/findPassword")
	public String findPassword() {
		
		return "login/findPassword";
	}
	
	private void makeSession(HttpServletRequest request, User user) {
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user);
		session.setAttribute("name", user.getName());
		session.setAttribute("userid", user.getUserid());
		session.setAttribute("password",user.getPassword());
		session.setAttribute("birth", user.getBirth());
		session.setAttribute("email",user.getEmail());
		session.setAttribute("phone",user.getPhone());
		session.setAttribute("registDate", user.getRegistDate());
		session.setAttribute("addr", user.getAddr());
		session.setAttribute("deli", user.getDeli());
		session.setAttribute("point", user.getPoint());
		session.setAttribute("admin", user.getAdmin());
	}
	
	private void validate(String userid, String pwd) {
		if (userid == null || userid == "") {
			throw new IllegalArgumentException("아이디가 비워있습니다.");
		}
		else if(pwd == null || pwd == "") {
			throw new IllegalArgumentException("패스워드가 비워있습니다.");
		}
	}
}
