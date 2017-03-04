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
		System.out.println(path);
		String roomName = request.getParameter("roomName");
		
		
		path += "/img/" + roomName + ".jpg";
		return path;
	}
	@RequestMapping("/book.do")
	public String book(BookVO book, RedirectAttributes attr) {
			attr.addFlashAttribute("msg", "예약이 완료되었습니다.");
			return "main/main";
		
	}
}
