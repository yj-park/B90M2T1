package kr.co.easybook.book.service;

import java.util.List;

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


}
