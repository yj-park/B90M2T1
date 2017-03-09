package kr.co.easybook.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.easybook.book.service.BookService;
import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.MemberVO;
import kr.co.easybook.repository.vo.RoomInfoVO;
import kr.co.easybook.repository.vo.StatisticVO;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@RequestMapping("/getUserInfo.do")
	public MemberVO getUserInfo(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("mem");
		System.out.println(member.getId());
		return member;
	}
	
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
	/*
	 * @RequestMapping("/roomTimeCheck.do")
	public boolean roomTimeCheck(BookVO bookVO) {
		System.out.println("예약확인:방");
		System.out.println(bookVO.getBookStartTime());
		System.out.println(bookVO.getBookEndTime());
		System.out.println(bookVO.getBookDate());
		System.out.println(bookVO.getRoomName());
		boolean booking = bookService.checkBookRoom(bookVO);
		System.out.println("예약 가능여부 : " + booking);
		return booking;
	}
	*/
	
	@RequestMapping("/book.do")
	public Map<String,Object> book(BookVO book) {
		System.out.println(book.getMobileNo());
		//		통계정보 저장
		StatisticVO statistic = new StatisticVO();
		statistic.setUseTime(book.getBookEndTime() - book.getBookStartTime());
		statistic.setBookRoomName(book.getRoomName());
		statistic.setBookDate(book.getBookDate());
		boolean check = bookService.regBook(book, statistic);
		Map<String , Object> map = new HashMap<>();
		map.put("msg", check);
		return map;
		
	}
}
