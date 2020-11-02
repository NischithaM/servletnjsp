package com.cruds.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.entity.Department;
import com.cruds.entity.User;
import com.mysql.jdbc.Connection;

public class UserDAO {
	
	public boolean login(User u)
	{
		String sql="select username ,password from user where username=? and password=?";
		boolean found = false;

		try(Connection con=(Connection) DBConnectionManager.getConnection())
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,u.getUsername());
			ps.setString(2,u.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs!=null && rs.next())
			{
				found=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return found;
	}
	
	
	public User getRole(String username) 
	{
		String sql="select role from user where username = ? ";
		User u=null;
		
		try(Connection con=(Connection) DBConnectionManager.getConnection())
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				u=new User(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	

}
