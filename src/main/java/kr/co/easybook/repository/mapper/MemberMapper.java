package kr.co.easybook.repository.mapper;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.easybook.repository.vo.MemberVO;

@Repository
public class MemberMapper {
	@Autowired
	private SqlSessionTemplate mapper;
	public MemberVO innerLogin(MemberVO member) {
		return mapper.selectOne("kr.co.easybook.repository.mapper.MemberMapper.innerLogin", member);
		
	}
	
	
}
