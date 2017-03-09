package kr.co.easybook.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.easybook.repository.mapper.BookMapper;
import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.RoomInfoVO;
import kr.co.easybook.repository.vo.StatisticVO;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper mapper;
	public List<BookVO> checkBookTime(BookVO bookVO) {
		return mapper.selectBookTime(bookVO);
	}
	public boolean checkBookRoom(BookVO bookVO) {
		if(mapper.selectRoomCheck(bookVO) > 0) {
			return false;
		}
		return true;
	}
	public boolean regBook(BookVO bookVO, StatisticVO statisticVO) {
		int cnt = mapper.selectRoomCheck(bookVO);
		System.out.println(cnt);
		if(cnt > 0) {
				return false;
			}
			int bookResult = mapper.insertBook(bookVO);
			int statisticResult = mapper.insertStatistic(statisticVO);
			if(bookResult == 1 && statisticResult == 1) {
				return true;
			}
			
			return false; 
	}
	public RoomInfoVO retriveRoomInfo(String name) {
		return mapper.selectRoomInfo(name);
	}

//	통계테이블에서 데이터 가져오기
	public Map<String, Object> retriveBookData(String toDay) {
		Map<String, Object> map = new HashMap<>();
		StatisticVO statisticVO = new StatisticVO();
		map.put("total",  mapper.selectTotalData(toDay));
		statisticVO.setBookDate(toDay);
		statisticVO.setBookRoomName("a");
		map.put("a", mapper.selectTotalDataByRoom(statisticVO));
		statisticVO.setBookRoomName("b");
		map.put("b", mapper.selectTotalDataByRoom(statisticVO));
		statisticVO.setBookRoomName("c");
		map.put("c", mapper.selectTotalDataByRoom(statisticVO));
		statisticVO.setBookRoomName("d");
		map.put("d", mapper.selectTotalDataByRoom(statisticVO));
		statisticVO.setBookRoomName("e");
		map.put("e", mapper.selectTotalDataByRoom(statisticVO));
		statisticVO.setBookRoomName("f");
		map.put("f", mapper.selectTotalDataByRoom(statisticVO));
		statisticVO.setBookRoomName("g");
		map.put("g", mapper.selectTotalDataByRoom(statisticVO));
		return map;
	}
}
