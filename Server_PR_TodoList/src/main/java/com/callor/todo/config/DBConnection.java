package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "todo";
		String password = "todo";
		
		try {
			
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			
			}
			System.out.println("오라클 접속성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("=".repeat(30));
			System.out.println("Driver : " + jdbcDriver);
			System.out.println("URL : " + url);
			System.out.println("UserName : " + username);
			System.out.println("Password : " + password);
			System.out.println("-".repeat(30));
			System.out.println("오라클 DBMS 접속 오류");
			System.out.println("접속 정보를 확인하세요");
			System.out.println("=".repeat(30));
			
		}
	}
	
	public static Connection getDBConection() {
		
		return dbConn;
	}
	
	
}
