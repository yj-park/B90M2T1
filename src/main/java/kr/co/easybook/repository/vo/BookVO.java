package kr.co.easybook.repository.vo;

import java.util.Date;

public class BookVO {
	private int bookNo;
	private String memberId;
	private String bookRoom;
	private String bookHeadcount;
	private Date bookDate;
	private int bookStarttime;
	private int bookEndtime;
	private Date bookRegdate;
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBookRoom() {
		return bookRoom;
	}
	public void setBookRoom(String bookRoom) {
		this.bookRoom = bookRoom;
	}
	public String getBookHeadcount() {
		return bookHeadcount;
	}
	public void setBookHeadcount(String bookHeadcount) {
		this.bookHeadcount = bookHeadcount;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public int getBookStarttime() {
		return bookStarttime;
	}
	public void setBookStarttime(int bookStarttime) {
		this.bookStarttime = bookStarttime;
	}
	public int getBookEndtime() {
		return bookEndtime;
	}
	public void setBookEndtime(int bookEndtime) {
		this.bookEndtime = bookEndtime;
	}
	public Date getBookRegdate() {
		return bookRegdate;
	}
	public void setBookRegdate(Date bookRegdate) {
		this.bookRegdate = bookRegdate;
	}
	
}
