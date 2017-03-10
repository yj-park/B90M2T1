package kr.co.easybook.member.service;

import java.util.Map;

import kr.co.easybook.repository.vo.MemberVO;
import kr.co.easybook.repository.vo.SearchVO;

public interface MemberService1 {

	public Map<String, Object> bookList(SearchVO search) throws Exception;
	public void bookDelete(int no) throws Exception;
	public void update(MemberVO mem) throws Exception;
	public MemberVO selectMember(String id) throws Exception;
}
