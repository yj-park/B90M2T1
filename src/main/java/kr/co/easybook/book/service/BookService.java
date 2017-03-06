package kr.co.easybook.book.service;

import kr.co.easybook.repository.vo.BookVO;
import kr.co.easybook.repository.vo.StatisticVO;

public interface BookService {
	public boolean regBook(BookVO bookVO, StatisticVO statisticVO);
}
