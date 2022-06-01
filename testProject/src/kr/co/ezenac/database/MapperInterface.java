package kr.co.ezenac.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.ezenac.beans.DataBean;
import kr.co.ezenac.domain.User;

public interface MapperInterface {

	@Insert("insert into spring_mvc_table(data1,data2,data3)values(#{data1},#{data2},#{data3})")
	void insert_data(DataBean dataBean);
	
	@Select("select * from usertbl where userid=#{userId}")
	User findUser(String userId);
	
	@Select("select * from smsapikey")
	String[] getCoolSMS();
}
