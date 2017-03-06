package kr.co.easybook.repository.vo;

import java.util.Date;

public class BookVO {
	private int no;
	private String memberId;
	private String mobileNo;
	private String headCnt;
	private int bookStartTime;
	private int bookEndTime;
	private String roomName;
	private Date bookDate;
	private Date regdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getHeadCnt() {
		return headCnt;
	}
	public void setHeadCnt(String headCnt) {
		this.headCnt = headCnt;
	}
	public int getBookStartTime() {
		return bookStartTime;
	}
	public void setBookStartTime(int bookStartTime) {
		this.bookStartTime = bookStartTime;
	}
	public int getBookEndTime() {
		return bookEndTime;
	}
	public void setBookEndTime(int bookEndTime) {
		this.bookEndTime = bookEndTime;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
