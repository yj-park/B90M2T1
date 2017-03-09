package kr.co.easybook.book.service;

import java.util.List;

import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.RoomInfoVO;
import kr.co.easybook.repository.vo.StatisticVO;

public interface BookService {
	public List<BookVO> checkBookTime(BookVO bookVO);
	public boolean checkBookRoom(BookVO bookVO);
	public boolean regBook(BookVO bookVO, StatisticVO statisticVO);
	public RoomInfoVO retriveRoomInfo(String name);
}
