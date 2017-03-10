package kr.co.easybook.board.service;

import java.util.List;
import java.util.Map;

import kr.co.easybook.repository.vo.BoardVO;
import kr.co.easybook.repository.vo.CommentVO;
import kr.co.easybook.repository.vo.SearchVO;

public interface BoardService {
	public void write(Map<String, Object> param) throws Exception;
	
	public BoardVO updateForm(int no) throws Exception;
	
	public void update(BoardVO board) throws Exception;	

	public Map<String, Object> list(SearchVO search) throws Exception;
		
	public void delete(int no) throws Exception;
	
	public List<CommentVO> commentUpdate(CommentVO comment) throws Exception ;
	
	public List<CommentVO> commentRegist(CommentVO comment) throws Exception;
	
	public List<CommentVO> commentList(int no) throws Exception ;
	
	public List<CommentVO> commentDelete(CommentVO comment) throws Exception ;

	public Map<String, Object> detail(int no) throws Exception;
}
