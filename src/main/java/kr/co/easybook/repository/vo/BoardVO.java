package kr.co.easybook.repository.vo;

import java.util.Date;

public class BoardVO {
	
	/** 글번호(PK) **/
	private int no;
	/** 아이디 **/
	private String memberId;
	/** 글제목 **/
	private String title;
	/** 글내용 **/
	private String content;
	/** 글등록날짜 **/
	private Date regDate;
	/** 조회수 **/
	private String viewCnt;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}
	
}
