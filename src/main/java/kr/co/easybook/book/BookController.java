package kr.co.easybook.book;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.easybook.repository.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	@RequestMapping("/roomInfo.do")
	@ResponseBody
	public String roomInfo(HttpServletRequest request) {
		String path = request.getContextPath();
		String roomName = request.getParameter("roomName");
		System.out.println(roomName);
		
		path += "/roomimg/" + roomName + ".jpg";
		return path;
	}
	@RequestMapping("/book.do")
	public String book(BookVO book, RedirectAttributes attr) {
			//redirect 1회성 데이터 전송하면 페이지를 새로고침했을 때  msg가 또 alert되는것을 막을 수 있다.
			
			attr.addFlashAttribute("msg", "예약이 완료되었습니다.");
			return "main/main";
		
	}
}
