package kr.co.easybook.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.easybook.repository.mapper.MemberMapper1;
import kr.co.easybook.repository.vo.MemberVO;
import kr.co.easybook.repository.vo.PageResultVO;
import kr.co.easybook.repository.vo.SearchVO;

@Service
public class MemberServiceImpl1 implements MemberService1 {
	
	@Autowired
	private MemberMapper1 memberMapper1;
	
	@Override
	public Map<String, Object> bookList(SearchVO search) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", memberMapper1.selectBookList(search));
		result.put("pageResult", new PageResultVO(search.getPageNo(), memberMapper1.selectBookCount(search)));
		return result;
	}
	
	@Override
	public void bookDelete(int no) throws Exception {
		memberMapper1.bookDelete(no);
	}

	@Override
	public void update(MemberVO mem) throws Exception {
		memberMapper1.update(mem);
	}

	@Override
	public MemberVO selectMember(String id) throws Exception {
		MemberVO mem = memberMapper1.selectMember(id);
		return mem;
	}

	

}
