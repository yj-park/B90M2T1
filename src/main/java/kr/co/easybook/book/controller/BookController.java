package kr.co.easybook.book.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.easybook.book.service.BookService;
import kr.co.easybook.repository.vo.RoomInfoVO;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	@RequestMapping("/roomInfo.do")
	public RoomInfoVO roomInfo(HttpServletRequest request) {
		String path = request.getContextPath();
		Map<String, Object> map = new HashMap<>();
		String roomName = request.getParameter("roomName");
		//path += "/img/" + roomName + ".jpg";
		
		return bookService.retriveRoomInfo(roomName);
	}
	public String room(HttpServletRequest request) {
		
		String path = request.getContextPath();
		System.out.println(path);
		String roomName = request.getParameter("roomName");
		
		
		path += "/img/" + roomName + ".jpg";
		return path;
	}
	@RequestMapping("/book.do")
	public String book(HttpServletRequest request) {
		System.out.println(request.getParameter("startTime"));
			System.out.println(request.getParameter("endTime"));
			System.out.println(request.getParameter("memberId"));
			System.out.println(request.getParameter("memberMobileNo"));
			System.out.println(request.getParameter("roomName"));
			return "ajax리턴";
		
	}
}
