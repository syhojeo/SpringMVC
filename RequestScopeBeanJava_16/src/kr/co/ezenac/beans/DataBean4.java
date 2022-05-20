package kr.co.ezenac.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//Component 를 통해서 빈을 등록할 경우 빈이 들어있는 패키지를 스캔해야지만 빈으로 자동 등록된다
@Component(value="requestBean4") //이름을 통한 Component
@RequestScope
public class DataBean4 {
	
	private String data7;
	private String data8;
	
	public String getData7() {
		return data7;
	}
	public void setData7(String data7) {
		this.data7 = data7;
	}
	public String getData8() {
		return data8;
	}
	public void setData8(String data8) {
		this.data8 = data8;
	}

	

}
