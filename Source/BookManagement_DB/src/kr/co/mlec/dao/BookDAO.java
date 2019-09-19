package kr.co.mlec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.service.RentService;
import kr.co.mlec.service.RentServiceFactory;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.RentVO;

public class BookDAO {

	/*
	 * ���� �߰�
	 */
	public void insert(BookVO book) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into t_book(no, title, author) ");
		sql.append(" values(seq_t_book_no.nextval, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
	
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ���� ����
	 */
	public int delete(int bookNo) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete t_book ");
		sql.append(" where no = ? ");
		
		int ret = 0;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			RentService rService = RentServiceFactory.getInstance();
			List<RentVO> rList = rService.findAllRent();
			
			for(RentVO r : rList) {
				if(r.getBookNo() == bookNo) {
					rService.deleteRent(bookNo, r.getId());
					break;
				}
			}
			
			pstmt.setInt(1, bookNo);
	
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0)
				ret = 1;
			else
				ret = -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	/*
	 * ���� ��ȣ�� �˻�
	 */
	public BookVO find(int bookNo) throws Exception {
		
		BookVO book = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, author ");
		sql.append(" , to_char(reg_date, 'yyyy-mm-dd') as reg_date, rent_flag, rent_date ");
		sql.append(" from t_book ");
		sql.append(" where no = ? ");
		
		try (
			
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			
			pstmt.setInt(1, bookNo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setRegDate(rs.getString("reg_date"));
				book.setRentFlag(rs.getInt("rent_flag"));
				book.setRentDate(rs.getString("rent_date"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		return book;
	}
	
	/*
	 * ���� ����� ���ڷ� �˻�
	 */
	public BookVO find(String title, String author) throws Exception {
		
		BookVO book = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, author ");
		sql.append(" , to_char(reg_date, 'yyyy-mm-dd') as reg_date, rent_flag, rent_date ");
		sql.append(" from t_book ");
		sql.append(" where title = ? and author = ? ");
		
		try (
			
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setRegDate(rs.getString("reg_date"));
				book.setRentFlag(rs.getInt("rent_flag"));
				book.setRentDate(rs.getString("rent_date"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		return book;
	}
	
	/*
	 * ���� �뿩���� ����
	 */
	public void updateRent(int bookNo, BookVO book) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update t_book ");
		sql.append(" set rent_flag = ?, rent_date = ? ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			pstmt.setInt(1, book.getRentFlag());
			pstmt.setString(2, book.getRentDate());
			pstmt.setInt(3, bookNo);

			pstmt.executeUpdate();
							
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}
	
	/*
	 * ��ü ���� ��� ��ȸ
	 */
	public List<BookVO> findAll() throws Exception {
		
		List<BookVO> bookList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, author, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append(" , rent_flag, rent_date ");
		sql.append(" from t_book ");
		sql.append(" order by no desc ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String regDate = rs.getString("reg_date");
				int rentFlag = rs.getInt("rent_flag");
				String rentDate = rs.getString("rent_date");
				
				BookVO book = new BookVO(no, title, author, regDate, rentFlag, rentDate);
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
}
