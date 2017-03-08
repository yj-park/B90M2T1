package kr.co.easybook.member.service;

import kr.co.easybook.repository.vo.MemberVO;

public interface MemberService {

	public MemberVO selectMemInfo(MemberVO member) throws Exception;
	public String selectMemId(String id) throws Exception;
	public void insertMem(MemberVO member) throws Exception;
}
