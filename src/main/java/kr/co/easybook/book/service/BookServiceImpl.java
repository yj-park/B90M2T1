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
	public boolean regBook(BookVO bookVO, StatisticVO statisticVO) {
			int bookResult = mapper.insertBook(bookVO);
			int statisticResult = mapper.insertStatistic(statisticVO);
			if(bookResult == 1 && statisticResult == 1) {
				return true;
			}
			else return false; 
	}
	public RoomInfoVO retriveRoomInfo(String name) {
		return mapper.selectRoomInfo(name);
	}


}
