package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection getConnect() throws Exception {
		
		String username = "admin";
		
		String password = "oracle1234";
		
		String url = "jdbc:oracle:thin:@mj-oracle.ccogcnmoaoip.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
		
		//어떤 라이브러리 쓸거냐
		//생략해도 작동
		String driver = "oracle.jdbc.driver.OraleDriver";
		
		Class.forName(driver);
		
		//DB에 접속해서 로그인
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println(con);
		System.out.println("DB와 연결 성공");
		return null;
		
		
	}
	
}
