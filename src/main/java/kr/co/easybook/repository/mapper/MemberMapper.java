package kr.co.easybook.repository.mapper;

import kr.co.easybook.repository.vo.MemberVO;

public interface MemberMapper {
	
	public MemberVO selectMemInfo(MemberVO meber);
	public String selectMemId(String id);
	public void insertMem(MemberVO meber);
	
}
