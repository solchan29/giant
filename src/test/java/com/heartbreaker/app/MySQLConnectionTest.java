package com.heartbreaker.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://srcheaven.co.kr:3306/test_front_end";
	private static final String USER = "iersans";
	private static final String PW = "1234sk";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		Connection con = DriverManager.getConnection(URL, USER, PW);
		System.out.println(con);
	}
}
