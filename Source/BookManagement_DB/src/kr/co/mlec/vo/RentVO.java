package kr.co.mlec.vo;

public class RentVO {
	private String id;
	private int bookNo;
	
	public RentVO() {
		super();
	}
	
	public RentVO(String id, int bookNo) {
		super();
		this.id = id;
		this.bookNo = bookNo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "RentVO [id=" + id + ", bookNo=" + bookNo + "]";
	}
	
	
	
}
