package kr.co.mlec.vo;

import java.util.ArrayList;
import java.util.List;

public class UserVO {
	private int no;
	private String id;
	private String passwd;
	private String name;

	private static int userNo = 1;
	
	
	public static int getUserNo() {
		return UserVO.userNo++;
	}

	public static int setUserNo() {
		return UserVO.userNo--;
	}

	public UserVO() {
	}
	
	public UserVO(String id, String passwd) {
		super();
		this.id = id;
		this.passwd = passwd;
	}
	
	
	
	public UserVO(int no, String id, String passwd, String name) {
		super();
		this.no = no;
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}

	public UserVO(String id, String passwd, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", id=" + id + ", passwd=" + passwd + ", name=" + name + "]";
	}



	
	
}
