package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.ezenac.domain.CoolSMSKey;
import kr.co.ezenac.domain.Phone;
import kr.co.ezenac.domain.User;
import kr.co.ezenac.dto.UserDTO;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	@Bean
	@RequestScope
	public UserDTO userDTO() {
		return new UserDTO();
	}
	
	@Bean
	@RequestScope
	public User user() {
		return new User();
	}
	
	@Bean
	@RequestScope
	public Phone phone() {
		return new Phone();
	}
	
}
