package kr.co.easybook.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.easybook.member.service.MemberService;
import kr.co.easybook.repository.vo.MemberVO;

@Controller
@RequestMapping("/member")
@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 로그인 체크
	@RequestMapping("/memLoginChk.do")
	public Map<String, Object> memLoginChk(MemberVO member, HttpServletRequest request) throws Exception {
		
		Map<String, Object> param = new HashMap<>();
		/*System.out.println(member.getId());
		System.out.println(member.getPassword());*/
		MemberVO mem = memberService.innerLogin(member);
		
	/*	System.out.println(mem.getId());*/
		if (mem != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("mem", mem);
			
			param.put("mem", mem);
			param.put("loginChk", true);
			
			return param;
		}
		else {
			param.put("loginChk", false);
			return param;
		}
	}
}
