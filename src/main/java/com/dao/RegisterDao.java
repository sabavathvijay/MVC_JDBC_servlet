package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.RegisterModel;
import com.utility.ConnectionDB;

public class RegisterDao implements RegisterInterface {

	@Override
	public boolean insertUser(RegisterModel user) {
		
		boolean status=false;
		
		Connection connect = ConnectionDB.getDBConnection();
		
		try {
			PreparedStatement pre= connect.prepareStatement("insert into Register values(?,?,?,?)");
			
			pre.setString(1, user.getName());
			pre.setString(2, user.getEmail());
			pre.setString(3, user.getPassword());
			pre.setString(4, user.getTel());
			
			
			int row=pre.executeUpdate();
			
			if(row>0) {
				status=true;
				
			}
			
			
			connect.close();
			pre.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
System.out.println("====>  The DB :"+ status);

		
		return status;
	}
	
	
	
	

}
