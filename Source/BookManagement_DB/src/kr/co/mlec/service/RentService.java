package kr.co.mlec.service;

import java.util.List;

import kr.co.mlec.dao.RentDAO;
import kr.co.mlec.dao.RentDAO;
import kr.co.mlec.vo.RentVO;
import kr.co.mlec.vo.UserVO;

public class RentService {
	private RentDAO dao;

	public RentService() {
		dao = new RentDAO();
	}
	
	
	public RentDAO getDao() {
		return dao;
	}


	/*
	 * ���� �뿩 ���� ���
	 */
	public void insertRent(String id, int bookId) throws Exception {
		
		dao.insert(id, bookId);
	}
	
	/*
	 * ���� �뿩 ���� ����
	 */
	public int deleteRent(int bookNo, String id) throws Exception {
		return dao.delete(bookNo, id);
	}
	
	/*
	 * �ش� ������� ���� �뿩 ��� ��ȸ
	 */
	public List<RentVO> findRent(String id) throws Exception {
		return dao.find(id);
	}
	
	/*
	 * ���� �뿩 ��� ��ȸ
	 */
	public List<RentVO> findAllRent() throws Exception {
		return dao.findAll();
	}
}
