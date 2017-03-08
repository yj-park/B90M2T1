package kr.co.easybook.repository.vo;

public class PageVO {
	/** 시작페이지 **/
	int pageNo = 1;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getBegin() {
		return (pageNo -1) * 10 + 1;
	}
	public int getEnd() {
		return pageNo * 10;
	}
}
