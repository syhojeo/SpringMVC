package kr.co.EZHOME.domain;
//package kr.co.ezenac.domain;
//
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.annotation.RequestScope;
//
//import kr.co.ezenac.dao.UserDAO;
//import kr.co.ezenac.dto.UserDTO;
//
//@Service
//public class User {
//	
//	@Autowired
//	private UserDAO udao;
//
//	public LoginStatus login(String userid, String inputPassword, HttpServletRequest request)throws Exception {
//		//userid 로 찾기
//		UserDTO udto = udao.findUser(userid);
//		
//
//		//DB pwd
//		String pwd = udto.getPwd();
//		
//		//DB의 pwd와 input pwd가 같은지 확인 
//		if(pwd.equals(inputPassword)) {
//			//로그인한 유저의 정보 session 에 넣기
//			makeSession(request, udto);
//			return LoginStatus.LOGIN_SUCCESS;
//		}else {
//			return LoginStatus.PASSWORD_WRONG;
//		}
//	}
//
//	private void makeSession(HttpServletRequest request, UserDTO udto) {
//		HttpSession session = request.getSession();
//		session.setAttribute("name", udto.getName());
//		session.setAttribute("userid", udto.getUserid());
//		session.setAttribute("password",udto.getPwd());
//		session.setAttribute("birth", udto.getBirth());
//		session.setAttribute("email",udto.getEmail());
//		session.setAttribute("phone",udto.getPhone());
//		session.setAttribute("registDate", udto.getRegistDate());
//		session.setAttribute("addr", udto.getAddr());
//		session.setAttribute("deli", udto.getDeli());
//		session.setAttribute("point", udto.getPoint());
//		session.setAttribute("admin", udto.getAdmin());
//	}
//	
//	public Date transformDate(String birth) {
//		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
//		
//		//Date로 변경하기 위해서 날짜 형식을 yyyy-mm-dd로 변경
//		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
//		
//		java.util.Date tempDate = null;
//		
//		try {
//			tempDate = beforeFormat.parse(birth);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		// java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String으로 반환
//		String transDate = afterFormat.format(tempDate);
//		
//		// 반환된 String 값을 Date로 변경
//		Date d = Date.valueOf(transDate);
//		
//		return d;
//	}
//
//	
//	
//}
//
