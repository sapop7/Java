package common;

import java.sql.*;

public class JDBCTemp {
	public static Connection getConnection(){
		Connection con = null;
		
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection(
					 "jdbc:oracle:thin:@127.0.0.1:1521:xe", 
					 "student", "student");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	public static void close(Connection con) {
		try {
			 if(con.isClosed() && con != null)
				 con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt) {
		try {
			 if(stmt.isClosed() && stmt != null)
				 stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if(rset.isClosed() && rset != null)
				rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void commit(Connection con) {
		try {
			if(con.isClosed() && con != null)
				con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if(con.isClosed() && con != null)
				con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
