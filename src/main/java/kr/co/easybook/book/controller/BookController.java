package kr.co.easybook.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
		String roomName = request.getParameter("roomName");
		return bookService.retriveRoomInfo(roomName);
	}
	
	@RequestMapping("/timeCheck.do")
	public List<BookVO> bookTimeCheck(BookVO bookVO) {
		System.out.println(bookVO.getBookStartTime());
		System.out.println(bookVO.getBookEndTime());
		System.out.println(bookVO.getBookDate());
		List<BookVO> list = bookService.checkBookTime(bookVO);
		System.out.println("체크");
		System.out.println("예약정보개수 : " + list.size());
		for(BookVO book : list) {
			System.out.println(book.getBookStartTime());
			System.out.println(book.getBookEndTime());
			System.out.println(book.getRoomName());
		}
		return list;
	}
	
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
