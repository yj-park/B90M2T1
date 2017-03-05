package kr.co.easybook.member.service;

import kr.co.easybook.repository.vo.MemberVO;

public interface MemberService {

	public MemberVO innerLogin(MemberVO member) throws Exception;
}
