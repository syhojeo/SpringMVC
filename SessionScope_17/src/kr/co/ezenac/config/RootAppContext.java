package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;



//root-context.xml

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
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
