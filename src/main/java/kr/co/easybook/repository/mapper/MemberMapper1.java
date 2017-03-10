package kr.co.easybook.repository.mapper;

import java.util.List;

import kr.co.easybook.repository.vo.BoardVO;
import kr.co.easybook.repository.vo.MemberVO;
import kr.co.easybook.repository.vo.SearchVO;

public interface MemberMapper1 {
	
	public List<BoardVO> selectBookList(SearchVO search) throws Exception;
	public int selectBookCount(SearchVO search) throws Exception;
	public boolean bookDelete(int no) throws Exception;
	public boolean update(MemberVO mem) throws Exception;
	public MemberVO selectMember(String id) throws Exception;
}
