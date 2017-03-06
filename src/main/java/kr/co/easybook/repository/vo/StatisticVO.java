package kr.co.easybook.repository.vo;

import java.util.Date;

public class StatisticVO {
	private int no;
	private String bookRoomName;
	private int useTime;
	private Date bookDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBookRoomName() {
		return bookRoomName;
	}
	public void setBookRoomName(String bookRoomName) {
		this.bookRoomName = bookRoomName;
	}
	public int getUseTime() {
		return useTime;
	}
	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	
}
