package kr.co.mlec.ui;

import java.util.Scanner;

import kr.co.mlec.service.BookService;
import kr.co.mlec.service.BookServiceFactory;
import kr.co.mlec.service.RentService;
import kr.co.mlec.service.RentServiceFactory;
import kr.co.mlec.service.UserService;
import kr.co.mlec.service.UserServiceFactory;

public abstract class BaseUI implements IBookManageUI {
	private Scanner sc;
	protected BookService bService;
	protected UserService uService;
	protected RentService rService;

	public BaseUI() {
		sc = new Scanner(System.in);
		bService = BookServiceFactory.getInstance();
		uService = UserServiceFactory.getInstance();
		rService = RentServiceFactory.getInstance();
	}
	
	protected String scanStr(String msg) {

		System.out.print(msg);
		return  sc.nextLine();

	}
	
	protected int scanInt(String msg) {
		int num = 0;
		try {
			System.out.print(msg);
			num =  Integer.parseInt(sc.nextLine());
		} catch(Exception e) {
			System.out.print("메뉴를 숫자로 입력해주세요 : ");
			num = Integer.parseInt(sc.nextLine());
		}
		return num;
	}
	
}
