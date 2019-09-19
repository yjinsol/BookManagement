package kr.co.mlec.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.vo.RentVO;
import kr.co.mlec.vo.UserVO;

public class RentDAO {
	
	
	public RentDAO() {
		super();
	}

	/*
	 * ���� �뿩 ���� ���
	 */
	public void insert(String id, int bookNo) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_rentInfo(id, book_no) ");
		sql.append(" values(?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			pstmt.setString(1, id);
			pstmt.setInt(2, bookNo);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	/*
	 * ���� �뿩 ���� ����
	 */
	public int delete(int bookNo, String id) throws Exception {
		
		int ret = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("delete t_rentInfo ");
		sql.append(" where book_no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			boolean bool = false;
			List<RentVO> rList = findAll();
			
			for(RentVO r : rList) {
				if(r.getBookNo() == bookNo) {
					if(r.getId().equals(id)) {
						bool = true;
						break;
					}
					else { // �뿩��Ͽ� ������ �ִµ� �뿩�ڰ� id�� �ƴ� ���
						ret = -2;
						return ret;
					}
				}
			}
			
			if(bool == true) { // ȸ�� ���̵� id�̰� ������ȣ�� bookNo�� �� ����
				pstmt.setInt(1, bookNo);
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt > 0)
					ret = 1;
			}
			else // �뿩��Ͽ� ������ȣ�� bookNo�� ������ ���� ���
				ret = -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ret;
	}
	
	/*
	 * �ش� ������� ���� �뿩 ��� ��ȸ
	 */
	public List<RentVO> find(String uId) throws Exception {
		List<RentVO> rentList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select id, book_no ");
		sql.append(" from t_rentInfo ");
		sql.append(" where id = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			pstmt.setString(1, uId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String id = rs.getString("id");
				int no = rs.getInt("book_no");
				
				RentVO rent = new RentVO(id, no);
				rentList.add(rent);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		return rentList;
	}
	
	/*
	 * ���� �뿩 ��� ��ȸ
	 */
	public List<RentVO> findAll() throws Exception {
		List<RentVO> rentList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, book_no ");
		sql.append(" from t_rentInfo ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				int no = rs.getInt("book_no");
				
				RentVO rent = new RentVO(id, no);
				rentList.add(rent);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		return rentList;
	}
}
