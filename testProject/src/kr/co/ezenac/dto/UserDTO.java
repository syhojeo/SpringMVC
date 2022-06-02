package kr.co.ezenac.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserDTO {
	private String name;
	private String userid;
	private String pwd;
	private String birth;
	private String email;
	private String phone;
	private String registDate;
	private String addr;
	private String deliAddr;
	private int point;
	private int admin;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String name, String userid, String pwd, String birth, String email, String phone, String registDate,
			String addr, String deliAddr, int point, int admin) {
		super();
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.registDate = registDate;
		this.addr = addr;
		this.deliAddr = deliAddr;
		this.point = point;
		this.admin = admin;
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
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDeliAddr() {
		return deliAddr;
	}
	public void setDeliAddr(String deliAddr) {
		this.deliAddr = deliAddr;
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
	
	
	public Date transformDate(String birth) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		
		//Date로 변경하기 위해서 날짜 형식을 yyyy-mm-dd로 변경
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			tempDate = beforeFormat.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String으로 반환
		String transDate = afterFormat.format(tempDate);
		
		// 반환된 String 값을 Date로 변경
		Date d = Date.valueOf(transDate);
		
		return d;
	}
	

}
