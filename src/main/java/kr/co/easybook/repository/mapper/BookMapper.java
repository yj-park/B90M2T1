package kr.co.easybook.repository.mapper;

import java.util.List;

import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.RoomInfoVO;
import kr.co.easybook.repository.vo.StatisticVO;

public interface BookMapper {
	public List<BookVO> selectBookTime(BookVO bookVO);
	public int selectRoomCheck(BookVO bookVO);
	public int insertBook(BookVO bookVO);
	public RoomInfoVO selectRoomInfo(String name);
	public int insertStatistic(StatisticVO statistic);
	public int selectTotalData(String toDay);
	public int selectTotalDataByRoom(StatisticVO statisticVO);
}
