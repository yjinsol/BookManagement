package kr.co.mlec.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.mlec.service.BookService;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.UserVO;

public class UserDAO {
	
	public UserDAO() { // ������ ������ ���α׷� ���� �ʱ⿡ ����
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_user(no, id, passwd, name) ");
		sql.append(" values(seq_t_user_no.nextval, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, "Manager");
			pstmt.setString(2, "0000");
			pstmt.setString(3, "������");
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ȸ�����
	 */
	public boolean insert(UserVO user) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_user(no, id, passwd, name) ");
		sql.append(" values(seq_t_user_no.nextval, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			List<UserVO> uList = findAllMember();
			for(UserVO u : uList) {
				if(user.getId().equals(u.getId()))
					return false;
			}
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getName());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return true;
	}
	

	/*
	 * ȸ���˻�
	 */
	public UserVO find(String userId) throws Exception {
		UserVO user = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, passwd, name ");
		sql.append(" from t_user ");
		sql.append(" where id = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setNo(rs.getInt("no"));
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return user;
	
	}
	
	/*
	 * �α���
	 */
	public UserVO login(UserVO user) throws Exception {
		UserVO retUser = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, passwd, name ");
		sql.append(" from t_user ");
		sql.append(" where id = ? and passwd = ?");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPasswd());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setNo(rs.getInt("no"));
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return user;
	}
	
	/*
	 * ��ü ȸ�� ��� ��ȸ
	 */
	public List<UserVO> findAllMember() throws Exception {
		
		List<UserVO> userList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, passwd, name ");
		sql.append(" from t_user ");
		sql.append(" order by no desc ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
		){
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				
				UserVO user = new UserVO(no, id, passwd, name);
				userList.add(user);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		return userList;
	}
	

	/*
	 * ���� �뿩
	 */
	public int insert(int bookNo, UserVO user) throws Exception {

		BookDAO bDAO = new BookDAO();
		BookVO book = bDAO.find(bookNo);
		int ret = 0;
		
		if(book != null) { // ������ ���� ��Ͽ� �ִٸ�
			if(book.getRentFlag() == -1) { // �뿩���� �ƴ϶��
				RentDAO rDao = new RentDAO();

				rDao.insert(user.getId(), bookNo);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				bDAO.updateRent(bookNo, new BookVO(1, sdf.format(new Date()))); // �뿩��
				ret = 1;
			}
			else { // �뿩���̶��
				ret = -2;
			}
			
		}
		else // ������ ���� ��Ͽ� ���ٸ�
			ret = -1;
		
		return ret;
			
	}

	
	/*
	 * ���� �ݳ�
	 */
	public int delete(int bookNo, UserVO user) throws Exception {
		
		RentDAO rDao = new RentDAO();
		int ret = rDao.delete(bookNo, user.getId());
		if(ret > 0) { // ���������� �ݳ�
			BookDAO bDao = new BookDAO();
			bDao.updateRent(bookNo, new BookVO(-1, null)); // t_book�� rent_flag = -1, rent_date = null�� ��ȯ
			
		}

		return ret;
		
	}


	
}
