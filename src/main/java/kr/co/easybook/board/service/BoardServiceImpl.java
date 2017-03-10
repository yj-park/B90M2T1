package kr.co.easybook.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.easybook.repository.mapper.BoardMapper;
import kr.co.easybook.repository.vo.BoardVO;
import kr.co.easybook.repository.vo.CommentVO;
import kr.co.easybook.repository.vo.FileVO;
import kr.co.easybook.repository.vo.PageResultVO;
import kr.co.easybook.repository.vo.SearchVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper dao;
	
	@Override
	public void write(Map<String, Object> param) throws Exception {
		dao.insertBoard((BoardVO)param.get("board"));
		int no = ((BoardVO)param.get("board")).getNo();
		FileVO boardFile = (FileVO)param.get("boardFile");
		if (boardFile != null) {
			System.out.println(no);
			boardFile.setBoardNo(no);
			dao.insertBoardFile(boardFile);
		}
	}

	@Override
	public BoardVO updateForm(int no) throws Exception {
		return dao.selectOneBoard(no);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		dao.updateBoard(board);
	}

	@Override
	public Map<String, Object> list(SearchVO search) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", dao.selectBoard(search));
		result.put("pageResult", new PageResultVO(search.getPageNo(), dao.selectBoardCount(search)));
		return result;
	}

	@Override
	public Map<String, Object> detail(int no) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("boardVO", dao.selectOneBoard(no));
		result.put("file", dao.selectBoardFileByNo(no));
		return result;
	}

	@Override
	public void delete(int no) throws Exception {
		dao.deleteBoard(no);
	}

/*	@Override
	public List<CommentVO> commentUpdate(CommentVO comment) throws Exception {
		dao.updateBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}
*/
	@Override
	public List<CommentVO> commentRegist(CommentVO comment) throws Exception {
		dao.insertBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getBoardNo());
	}

	@Override
	public List<CommentVO> commentList(int no) throws Exception {
		return dao.selectBoardCommentByNo(no);
	}

	@Override
	public List<CommentVO> commentDelete(CommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getNo());
		return dao.selectBoardCommentByNo(comment.getBoardNo());
	}

}
