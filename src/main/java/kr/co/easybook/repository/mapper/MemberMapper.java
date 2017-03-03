package kr.co.easybook.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMapper {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	
}
