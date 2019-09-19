package kr.co.mlec.vo;

public class BookVO {
	private int no;
	private String title;
	private String author;
	private String regDate;
	private int rentFlag;
	private String rentDate;
	
	public int getRentFlag() {
		return rentFlag;
	}

	public void setRentFlag(int rentFlag) {
		this.rentFlag = rentFlag;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public BookVO() {
	}

	public BookVO(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}


	public BookVO(int no, String title, String author, String regDate, int rentFlag, String rentDate) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.regDate = regDate;
		this.rentFlag = rentFlag;
		this.rentDate = rentDate;
	}

	public BookVO(int rentFlag, String rentDate) {
		super();
		this.rentFlag = rentFlag;
		this.rentDate = rentDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BookVO [no=" + no + ", title=" + title + ", author=" + author + ", regDate=" + regDate + "]";
	}
	
	

	
	
	
}
