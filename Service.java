package com.hlo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

	public   boolean check(String uname,String password)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/king","root","root");
			PreparedStatement ps=c.prepareStatement("select * from login where uname=? and  password=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;

	}



}
