package kr.co.easybook.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.easybook.board.service.BoardService;
import kr.co.easybook.repository.vo.BoardVO;
import kr.co.easybook.repository.vo.CommentVO;
import kr.co.easybook.repository.vo.FileVO;
import kr.co.easybook.repository.vo.SearchVO;

@Controller
@RestController
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("board/list.do")
	@ResponseBody
	public Map<String, Object> list(SearchVO search) throws Exception {
		Map<String, Object> map = service.list(search);
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("list", map.get("list"));
		result.put("pageResult", map.get("pageResult"));
		return result;
	}
	
	@RequestMapping("board/detail.do")
	@ResponseBody
	public Map<String, Object> detail(int no) throws Exception {
		System.out.println(no);
		Map<String, Object> map = service.detail(no);
		Map<String, Object> result = new HashMap<String, Object>();
		
		
		result.put("boardVO", map.get("boardVO"));
		result.put("file", map.get("file"));
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("board/write.do")
	@ResponseBody
	public String write(MultipartHttpServletRequest mRequest, RedirectAttributes attr) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		ServletContext context = mRequest.getServletContext();
		String path = context.getRealPath("/upload");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		BoardVO board = new BoardVO();
		board.setTitle(mRequest.getParameter("title"));
		board.setMemberId(mRequest.getParameter("memberId"));
		board.setContent(mRequest.getParameter("content"));
		
		param.put("board", board);
		
		MultipartFile file = mRequest.getFile("attachFile");
		String oriName = file.getOriginalFilename();
		if(oriName != null && !oriName.equals("")) {
			String ext = "";
			int index = oriName.lastIndexOf(".");
			if(index != -1) {
				ext = oriName.substring(index);
			}
			
			long fileSize = file.getSize();
			System.out.println("파일 사이즈 : " + fileSize);
			
			String systemName = "mlec-" + UUID.randomUUID().toString() + ext;
			System.out.println("저장할 파일명 : " + systemName);
			
			file.transferTo(new File(savePath + "/" + systemName));
			
			FileVO boardFile = new FileVO();
			boardFile.setOriName(oriName);
			boardFile.setSavePath(savePath);
			boardFile.setSystemName(systemName);
			param.put("boardFile", boardFile);
		}
		service.write(param);
		
		return "";
	
	}
	
	@RequestMapping("board/delete.do")
	@ResponseBody
	public String delete(int no) throws Exception {
		
		service.delete(no);
		return "";
	}
	
	@RequestMapping("board/updateForm.do")
	@ResponseBody
	public Map<String, Object> updateForm(int no) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("board", service.updateForm(no));
		return result;
	}
	
	@RequestMapping("board/update.do")
	@ResponseBody
	public void update(int no, String title, String memberId, String content) throws Exception {
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		board.setMemberId(memberId);
		board.setContent(content);
		service.update(board);
	}
	
	@RequestMapping("board/commentList.do")
	@ResponseBody
	public List<CommentVO> commentList(int no) throws Exception {
		List<CommentVO> list = service.commentList(no);
		return list;
	}
	
	@RequestMapping("board/commentRegister.do")
	@ResponseBody
	public void commentRegister(int no, String memberId, String content) throws Exception {
		CommentVO comment = new CommentVO();
		comment.setBoardNo(no);
		comment.setMemberId(memberId);
		comment.setContent(content);
		service.commentRegist(comment);
	}
	
	public static void main(String[] args) {
		for (int count = 0; count < 100; count++) {
			// 마지막 페이지 구하기
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;
			int p2 = (int)Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
	
	
}
