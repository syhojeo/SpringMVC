package kr.co.ezenac.domain;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.ezenac.dto.UserDTO;

@Component
@RequestScope
public class User {
	
	@Autowired
	UserDTO userDTO;
	
	private String name;
	private String userid;
	private String pwd;
	private String birth;
	private String email;
	private String phone;
	private String registDate;
	private String addr;
	private String deli;
	private int point;
	private int admin;
	
	public User() {
		
	}
	
	public LoginStatus login(String inputPassword) {
		
		if(pwd != null && pwd.equals(inputPassword)) {
			return LoginStatus.LOGIN_SUCCESS;
		}else {
			return LoginStatus.PASSWORD_WRONG;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		if (userid == null) {
			throw new IllegalArgumentException("아이디가 비워있습니다.");
		}
		this.userid = userid;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		if (birth == null) {
			this.birth = null;
		}
		this.birth = birth.toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		if (registDate == null) {
			this.registDate = null;
		}
		this.registDate = registDate.toString();
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDeli() {
		return deli;
	}

	public void setDeli(String deli) {
		this.deli = deli;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
	
}

