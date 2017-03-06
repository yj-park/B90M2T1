package kr.co.easybook.book.service;

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
	public boolean regBook(BookVO bookVO, StatisticVO statisticVO) {
		return	mapper.insertBook(bookVO);
	}
	public RoomInfoVO retriveRoomInfo(String name) {
		return mapper.selectRoomInfo(name);
	}


}
