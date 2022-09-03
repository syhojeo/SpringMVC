package kr.co.EZHOME.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import kr.co.EZHOME.dto.CoolSMSKey;
import kr.co.EZHOME.dto.UserDTO;

public interface UserMapper {

	@Select("select * from usertbl where userid=#{userId}")
	UserDTO findUser(String userId);
	
	@Select("select * from smsapikey")
	CoolSMSKey getCoolSMS();
	
	@Select("select userid from usertbl where phone=#{phone}")
	String checkUserPhone(String phone);
}
