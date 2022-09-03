package kr.co.EZHOME.dao;
//package kr.co.ezenac.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import kr.co.ezenac.database.UserMapper;
//import kr.co.ezenac.domain.User;
//import kr.co.ezenac.dto.UserDTO;
//
//@Repository
//public class UserDAO {
//	
//	@Autowired
//	private UserMapper usermap;
//	
//	//userid로 유저 정보 DB에서 select 후 리턴하기
//	public UserDTO findUser(String userid) throws Exception {
//		UserDTO udto = usermap.findUser(userid);
//		
//		if (udto == null) {
//			throw new IllegalArgumentException("존재하지 않는 회원입니다.");
//		}
//		
//		return udto;
//	}
//}
