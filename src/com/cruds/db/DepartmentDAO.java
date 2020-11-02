package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.entity.Department;
import com.cruds.exception.DMSException;

public class DepartmentDAO {
	
	public List<Department> getAll()
	{
		String sql="select id ,name from department";
		List<Department> list=new ArrayList<>();
		Department d=null;
		
		try(Connection con=DBConnectionManager.getConnection())
		{
			
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				d=new Department(rs.getInt(1), rs.getString(2));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public boolean create(Department d)
	{
	String sql="insert into department(id,name) values(?,?)";
	
	int rows=0;
	
	try(Connection con=DBConnectionManager.getConnection())
	{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, d.getId());
		ps.setString(2, d.getName());
		rows=ps.executeUpdate();
	
	}
	catch(SQLException e)
	{
			e.printStackTrace();
			
			if(e.getMessage().contains("duplicate"))
			{
				throw new DMSException(d.getId()+"already exits ! duplicate entry !");
			}
			else
			{
				throw new DMSException(e.getMessage() +"  please contact system admin");
			}
	}
	
	return rows>0 ;
}
	
	public boolean delete(int dept_id)
	{
		String sql="delete from department where id=?";
		int rows=0;
		
		try(Connection con=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, dept_id);
			rows=ps.executeUpdate();
			 
		}
			catch(SQLException e)
		{
				e.printStackTrace();
		}
		
		return rows>0;
	} 
	
	public boolean update(Department d)
	{
		String sql="update department set name=? where id=?";
		int rows=0;
		try(Connection con=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,d.getName());
			ps.setInt(2,d.getId());
			
			rows=ps.executeUpdate();
			 
		}
			catch(SQLException e)
		{
				e.printStackTrace();
		}
		
		return rows>0;
	}
}