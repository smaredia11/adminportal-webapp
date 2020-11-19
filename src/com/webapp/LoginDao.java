package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	String sql = "select * from employee where userName=? and password=?";
	
	public boolean checkUser(String uname, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://database-1.cs8tqc17mfqf.us-east-2.rds.amazonaws.com:3306/employees?user=admin&password=Sam786110");
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}
