package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cruds.entity.Student;
import com.cruds.exception.SException;

public class StudentDAO {

	public List<Student> getAll()
	{
		String sql="select roll_no ,name from student";
		List<Student> list=new ArrayList<>();
		Student s=null;
		
		try(Connection con=DBConnectionManager.getConnection())
		{
			
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				s=new Student(rs.getInt(1), rs.getString(2));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public boolean create(Student s)
	{
	String sql="insert into student(roll_no,name) values(?,?)";
	
	int rows=0;
	
	try(Connection con=DBConnectionManager.getConnection())
	{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, s.getRoll_no());
		ps.setString(2, s.getName());
		rows=ps.executeUpdate();
	
	}
	catch(SQLException e)
	{
			e.printStackTrace();
			
			if(e.getMessage().contains("duplicate"))
			{
				throw new SException(s.getRoll_no()+"already exits ! duplicate entry !");
			}
			else
			{
				throw new SException(e.getMessage() +"  please contact system admin");
			}
	}
	
	return rows>0 ;
}
}

