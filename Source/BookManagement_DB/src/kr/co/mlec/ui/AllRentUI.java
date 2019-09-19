package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.RentVO;

public class AllRentUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<RentVO> rList = rService.findAllRent();
		System.out.println("------------------------------------------");
		System.out.println("\t\t���� ��� ��ȸ");
		System.out.println("------------------------------------------");
		System.out.println("ȸ��ID\t������ȣ");
		System.out.println("------------------------------------------");
		
		for(RentVO r : rList) {
			System.out.println(r.getId() + "\t" + r.getBookNo());
		}

	}

}
