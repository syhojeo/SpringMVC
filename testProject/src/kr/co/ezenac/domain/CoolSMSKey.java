package kr.co.ezenac.domain;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.ezenac.database.MapperInterface;

//한번만 apikey, apisecret 값을 DB에서 가져오기 위한 싱글톤 클래스

public class CoolSMSKey {
	
	@Autowired
	MapperInterface mapper;
	
	private String apiKey;
	private String apiSecret;
	
	private static CoolSMSKey coolsms = new CoolSMSKey();
	
	private CoolSMSKey() {
		
		String[] api =  mapper.getCoolSMS();
		
		apiKey = api[0];
		apiSecret = api[1];
	}
	
	public static CoolSMSKey getInstance() {
		return coolsms;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public String getApiSecret() {
		return apiSecret;
	}
	
}
