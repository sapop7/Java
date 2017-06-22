package common;

import java.sql.*;
import java.io.*;
import java.util.*;

public class JDBCTemp {
	
	public static Connection getConnection(){
		Connection con = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("driver.properties"));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return con;
	}
	
	public static void close(Connection con){
		try {
			  if(!con.isClosed())
				  con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset){
		try {
			  if(!rset.isClosed())
				  rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt){
		try {
			  if(!pstmt.isClosed())
				  pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			  if(!stmt.isClosed())
				  stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con){
		try {
			  if(!con.isClosed())
				  con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con){
		try {
			  if(!con.isClosed())
				  con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
