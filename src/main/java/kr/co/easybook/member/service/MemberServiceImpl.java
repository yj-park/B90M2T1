package kr.co.easybook.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.easybook.repository.mapper.MemberMapper;
import kr.co.easybook.repository.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberVO innerLogin(MemberVO member) throws Exception {
		return memberMapper.innerLogin(member);
	}
}
