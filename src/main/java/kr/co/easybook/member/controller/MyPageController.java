package kr.co.easybook.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.easybook.member.service.MemberService1;
import kr.co.easybook.repository.vo.MemberVO;
import kr.co.easybook.repository.vo.SearchVO;

@RestController
@RequestMapping("/myPage")
public class MyPageController {
	@Autowired
	private MemberService1 memberService1;
	
	@RequestMapping("/bookList.do")
	public Map<String, Object> list(SearchVO search, HttpSession session) throws Exception {
		System.out.println("hi");
		MemberVO member = (MemberVO)session.getAttribute("mem");
		System.out.println(member);
		Map<String, Object> map = null;
		if(member.getId() != "") {
			search.setMemberId(member.getId());
			map = memberService1.bookList(search);
			Map<String, Object> result = new HashMap<String, Object>();
			
			result.put("list", map.get("list"));
			result.put("pageResult", map.get("pageResult"));
			
			return result;
		} 
		return map;
		
	}
	
	
	
	
	
	
	
	
	
	
}
