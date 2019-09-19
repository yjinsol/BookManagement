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
	 * 도서 대여 정보 등록
	 */
	public void insertRent(String id, int bookId) throws Exception {
		
		dao.insert(id, bookId);
	}
	
	/*
	 * 도서 대여 정보 삭제
	 */
	public int deleteRent(int bookNo, String id) throws Exception {
		return dao.delete(bookNo, id);
	}
	
	/*
	 * 해당 사용자의 도서 대여 목록 조회
	 */
	public List<RentVO> findRent(String id) throws Exception {
		return dao.find(id);
	}
	
	/*
	 * 도서 대여 목록 조회
	 */
	public List<RentVO> findAllRent() throws Exception {
		return dao.findAll();
	}
}
