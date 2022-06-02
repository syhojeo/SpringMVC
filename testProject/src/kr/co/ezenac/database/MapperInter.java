package kr.co.ezenac.database;

import org.apache.ibatis.annotations.Select;

import kr.co.ezenac.domain.CoolSMSKey;

public interface MapperInter {
	
	@Select("select * from smsapikey")
	CoolSMSKey getCoolSMS();
}
