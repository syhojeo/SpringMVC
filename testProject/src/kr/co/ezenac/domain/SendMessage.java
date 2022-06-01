package kr.co.ezenac.domain;

import java.util.HashMap;
import java.util.Random;

import net.nurigo.sdk.message.model.Message;


public class SendMessage {
       
        //메시지 보내기
        public String sendMessage(String phone) {
        	//api key 받아오기
        	CoolSMSKey coolSMSKey = CoolSMSKey.getInstance();
        	
        	String api_key = coolSMSKey.getApiKey();
            String api_secret = coolSMSKey.getApiSecret();
            Message coolsms = new Message(api_key, api_secret);
        	
            String certificationNumber = MakeCertificationNumber();
            
            //첫 번째 발송의 경우 phone 에 -가 있기 때문에 split을 해준다
            if (phone.length() == 13) {
            	String[] phoneSplit = phone.split("-");
            	phone = phoneSplit[0] + phoneSplit[1] + phoneSplit[2];
            }
            // 4 params(to, from, type, text) are mandatory. must be filled
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("to", phone);
            params.put("from", "01039333062");
            params.put("type", "SMS");
            params.put("text", "[" + certificationNumber + "] 이젠, 집에서 인증번호를 입력해주세요.");
            params.put("app_version", "test app 1.2"); // application name and version

            try {
            	JSONObject obj = (JSONObject) coolsms.send(params);
            	System.out.println(obj.toString());
            } catch (CoolsmsException e) {
            	System.out.println(e.getMessage());
            	System.out.println(e.getCode());
            }
            return certificationNumber;
          }
        
        //6자리 인증번호 난수 만들기
        public String MakeCertificationNumber() {
        	Random rand = new Random();
        	String numStr = ""; //난수 저장될 변수
        	
        	//0~9 난수 만들기 6번 반복
        	for (int i = 0; i < 6; i++) {
        		numStr += Integer.toString(rand.nextInt(10));
        	}
        	
        	return numStr; 
        }
}
