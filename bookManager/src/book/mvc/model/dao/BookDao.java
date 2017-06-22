package book.mvc.model.dao;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import static common.JDBCTemp.*;

import book.mvc.model.vo.Book;

public class BookDao {
	private Properties prop;
	
	public BookDao() {
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertBook(Book b) {
		int result = 0;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		
		try {
			String query = prop.getProperty("insert");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPubliSher());
			pstmt.setInt(4, b.getPrice());
			
			result = pstmt.executeUpdate();
			
			if (result > 0)
				commit(con);
			else
				rollback(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
	}
	
	public int updateBook(Book b){
		int result = 0;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			  String query = prop.getProperty("update");
			  pstmt = con.prepareStatement(query);
			  pstmt.setInt(1, b.getPrice());
			  pstmt.setInt(2, b.getBookId());
			  
			  result = pstmt.executeUpdate();
			  
			  if(result > 0)
				  commit(con);
			  else
				  rollback(con);
			  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
	}
	
	public int deleteBook(int bid){
		int result = 0;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			  String query = prop.getProperty("delete");
			  pstmt = con.prepareStatement(query);
			  pstmt.setInt(1, bid);
			  result = pstmt.executeUpdate();
			  
			  if(result > 0)
				  commit(con);
			  else
				  rollback(con);
			  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
		
	}
	
	public ArrayList<Book> selectAllBooks(){
		ArrayList<Book> bList = null;
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			  stmt = con.createStatement();
			  String query = prop.getProperty("selectAll");
			  rset = stmt.executeQuery(query);
			  
			  if(rset != null)
				  bList = new ArrayList<Book>();
			  while(rset.next()){
				  Book b = new Book();
				  
				  b.setBookId(rset.getInt("book_id"));
				  b.setTitle(rset.getString("title"));
				  b.setAuthor(rset.getString("author"));
				  b.setPubliSher(rset.getString("publisher"));
				  b.setPublishDate(rset.getDate("publish_date"));
				  b.setPrice(rset.getInt("price"));
				  
				  bList.add(b);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(con);
		}
		
		return bList;
		
	}
	
	public ArrayList<Book> searchBookTitle(String bookTitle){
		ArrayList<Book> bList = null;
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			  String query = prop.getProperty("selectTitle");
			  pstmt = con.prepareStatement(query);
			  pstmt.setString(1, bookTitle);
			  rset = pstmt.executeQuery();
			  
			  if(rset != null){
				  rset.next();
				  Book b = new Book();
				  bList = new ArrayList<Book>();
				 
				  b.setBookId(rset.getInt("book_id"));
				  b.setTitle(rset.getString("title"));
				  b.setAuthor(rset.getString("author"));
				  b.setPubliSher(rset.getString("publisher"));
				  b.setPublishDate(rset.getDate("publish_date"));
				  b.setPrice(rset.getInt("price"));
				  
				  bList.add(b);
				
			  }
			  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		return bList;
	}
	
	public Book selectBook(int bookId){
		Book b = null;
		Connection con= getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			  String query = prop.getProperty("selectOne");
			  pstmt = con.prepareStatement(query);
			  pstmt.setInt(1, bookId);
			  rset = pstmt.executeQuery();
			  
			  if(rset != null){
				  rset.next();
				  b = new Book();
				  
				  b.setBookId(rset.getInt("book_id"));
				  b.setTitle(rset.getString("title"));
				  b.setAuthor(rset.getString("author"));
				  b.setPubliSher(rset.getString("publisher"));
				  b.setPublishDate(rset.getDate("publish_date"));
				  b.setPrice(rset.getInt("price"));
			  }
			
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		return b;
		
	}
}	
