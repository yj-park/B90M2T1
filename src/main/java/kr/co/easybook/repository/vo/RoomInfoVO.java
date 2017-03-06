package kr.co.easybook.repository.vo;

public class RoomInfoVO {
	private int no;
	private String imgSavePath;
	private int maxHeadCnt;
	private String name;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getImgSavePath() {
		return imgSavePath;
	}
	public void setImgSavePath(String imgSavePath) {
		this.imgSavePath = imgSavePath;
	}
	public int getMaxHeadCnt() {
		return maxHeadCnt;
	}
	public void setMaxHeadCnt(int maxHeadCnt) {
		this.maxHeadCnt = maxHeadCnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
