package kr.co.easybook.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.easybook.repository.mapper.BookMapper;
import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.StatisticVO;

public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper mapper;
	public boolean regBook(BookVO bookVO, StatisticVO statisticVO) {
		return	mapper.insertBook(bookVO);
	}

}
