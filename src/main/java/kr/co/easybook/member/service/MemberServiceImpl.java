package kr.co.easybook.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.easybook.repository.mapper.MemberMapper;
import kr.co.easybook.repository.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO selectMemInfo(MemberVO member) throws Exception {
		return memberMapper.selectMemInfo(member);
	}
	
	public String selectMemId(String id) throws Exception {
		return memberMapper.selectMemId(id);
	}
	
	public void insertMem(MemberVO member) throws Exception {
		memberMapper.insertMem(member);
	}
	
}
