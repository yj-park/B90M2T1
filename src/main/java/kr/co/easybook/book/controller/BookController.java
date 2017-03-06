package kr.co.easybook.book.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {
	@RequestMapping("/roomInfo.do")
	@ResponseBody
	public String roomInfo(HttpServletRequest request) {
		String path = request.getContextPath();
		System.out.println(path);
		String roomName = request.getParameter("roomName");
		
		
		path += "/img/" + roomName + ".jpg";
		return path;
	}
	public List<Object> room(HttpServletRequest request) {
		
		String path = request.getContextPath();
		System.out.println(path);
		String roomName = request.getParameter("roomName");
		
		
		path += "/img/" + roomName + ".jpg";
		return path;
	}
	@RequestMapping("/book.do")
	@ResponseBody
	public String book(HttpServletRequest request) {
		System.out.println(request.getParameter("startTime"));
			System.out.println(request.getParameter("endTime"));
			System.out.println(request.getParameter("memberId"));
			System.out.println(request.getParameter("memberMobileNo"));
			System.out.println(request.getParameter("roomName"));
			return "ajax리턴";
		
	}
}
