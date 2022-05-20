package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;

//root-context.xml

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	@Bean
	@RequestScope
	//RequestScope : 새로운 요청이 왔을때 빈에 주입된다 (request에 저장하는것은 아님 -> model 등으로 해줘야함)
	//요청이 발생될 때마다 계속 Bean 객체가 생성됨
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2") // 이름으로 정의
	@RequestScope
	public DataBean2 dataBena2() {
		return new DataBean2();
	}
	
	//ComponentScan 을 이용하면 따로 Bean 등록을 하지 않아주어도 된다
}

/*
 * RequestScope 빈 주입
 * 
 * Bean을 정의할 때 request scope 로 정의하면 요청이 발생할 때 마다 Bean 객체가 생성되어 자동으로 주입
 * 주입된 Bean은 요청 발생시 주입만 이루어지는 것이므로 request영역에 저장되지 않는다
 * xml 로 bean을 설정하고 byName으로 주입 받았을 경우에만 request 영역에 자동 저장된다
 * Java 방식은 @RequestScope를 사용
 * xml 방식은 bean을 정의할 때 scope="request"로 설정
 * 
 */
