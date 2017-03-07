package kr.co.easybook.book.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.easybook.book.service.BookService;
import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.RoomInfoVO;
import kr.co.easybook.repository.vo.StatisticVO;

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
			
		return bookService.retriveRoomInfo(roomName);
	}
/*	public String room(HttpServletRequest request) {
		
		String path = request.getContextPath();
		System.out.println(path);
		String roomName = request.getParameter("roomName");
		
		
		path += "/img/" + roomName + ".jpg";
		return path;
	}*/
	@RequestMapping("/book.do")
	public Map<String, Object> book(BookVO book) {
		Map<String, Object> map = new HashMap<>();
//		통계정보 저장
		StatisticVO statistic = new StatisticVO();
		statistic.setUseTime(book.getBookEndTime() - book.getBookStartTime());
		statistic.setBookRoomName(book.getRoomName());
		statistic.setBookDate(book.getBookDate());
		bookService.regBook(book, statistic);
		return map;
		
	}
}
