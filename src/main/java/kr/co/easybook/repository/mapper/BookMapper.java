package kr.co.easybook.repository.mapper;

import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.RoomInfoVO;

public interface BookMapper {
	public boolean insertBook(BookVO bookVO);
	public RoomInfoVO selectRoomInfo(String name);
}
