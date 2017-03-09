package kr.co.easybook.member.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	
		// 아이디(이메일)중복 검사
		@RequestMapping("/memIdChk.do")
		public Map<String, Object> memIdChk(String id) throws Exception {
			System.out.println(id);
			
			String idChk = memberService.selectMemId(id);
			
			Map<String, Object> param = new HashMap<>();
			if (idChk != null) {
				System.out.println("사용중");
				param.put("idCheck", true);
				return param;
			} else {
				System.out.println("사용가능");
				param.put("idCheck", false);
			}
			return param;
		}
		
		// 회원가입
		@RequestMapping("/memJoin.do")
		public String memJoin(MemberVO member, HttpSession session) throws Exception {
			MemberVO mem = memberService.selectMemInfo(member);
			String msg;
			
			if (mem == null) {
				memberService.insertMem(member);
				msg = "Hello";
			} else {
				msg = "Success";
			}
			System.out.println(msg);
			session.setAttribute("mem", mem);
			return msg;
		}
		
		
		// 로그인 체크
		@RequestMapping("/memLoginChk.do")
		public String memLoginChk(MemberVO member, HttpSession session) throws Exception {
			MemberVO mem = memberService.selectMemInfo(member);
			String msg;
			
			msg = "Hello";
			if (mem == null) {
				msg = "Join";
			}
			session.setAttribute("mem", mem);
			return msg;
		}
		
		// 구글 로그인 DB 저장
		@RequestMapping("/memGoogleChk.do")
		public Map<String, Object> memGoogleChk(String id) throws Exception {
			System.out.println(id);
			
			String googleIdChk = memberService.selectMemId(id);
			
			Map<String, Object> param = new HashMap<>();
			if (googleIdChk != null) {
				System.out.println("사용중");
				param.put("googleIdChk", true);
				return param;
			} else {
				System.out.println("사용가능");
				param.put("googleIdChk", false);
			}
			return param;
		}
}
