package com.harsha.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
	
	Connection con = null;
	
	
	public UserRepo() {
		String url="jdbc:mysql://localhost:3306/usersdb";
		String username = "root";
		String pwd = "Reset123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			
			con=DriverManager.getConnection(url,username,pwd);
		System.out.println("got connection");
		
			
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
    	
	}
	
	
	
	//this method fetched all users from the database
	public List<Users> getAllUser(){
		List<Users> userlist = new ArrayList<Users>();
		String fetchall = "select * from users";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet res =stmt.executeQuery(fetchall);
			
			while(res.next()) {
				Users u = new Users();
				u.setId(res.getInt(1));
				u.setName(res.getString(2));
				u.setAge(res.getInt(3));
				userlist.add(u);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return userlist;
	}


	public Users getAUser(int id) {
		List<Users> userlist = new ArrayList<Users>();
		String fetchall = "select * from users where id="+id;
		Users u = new Users();
		try {
			Statement stmt = con.createStatement();
			ResultSet res =stmt.executeQuery(fetchall);
			
			if(res.next()) {
				
				u.setId(res.getInt(1));
				u.setName(res.getString(2));
				u.setAge(res.getInt(3));
				userlist.add(u);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return u;
	}

	public void createUser(Users user) {
	

        
        String qry = "insert into users values(?,?,?)";
        
        try {
       	 java.sql.PreparedStatement stmt = con.prepareStatement(qry);
       	 stmt.setInt(1, user.getId());
       	 stmt.setString(2, user.getName());
       	 stmt.setInt(3, user.getAge());
       	 stmt.executeUpdate();
       	 
        }
        catch(SQLException e) {
       	 System.out.println(e);
        }
        
		
	}
	public void UpdateUser(Users user) {
	

        
        String qry = "update users set name=?, age=? where id =?";
        
        try {
       	 java.sql.PreparedStatement stmt = con.prepareStatement(qry);
       	 stmt.setInt(3, user.getId());
       	 stmt.setString(1, user.getName());
       	 stmt.setInt(2, user.getAge());
       	 stmt.executeUpdate();
       	 
        }
        catch(SQLException e) {
       	 System.out.println(e);
        }
        
		
	}
public void DeleteUser(int id) {
	

        
        String qry = "delete from users where id=?";
        
        try {
       	 java.sql.PreparedStatement stmt = con.prepareStatement(qry);
       	 stmt.setInt(1,id);
       	 stmt.executeUpdate();
       	 
        }
        catch(SQLException e) {
       	 System.out.println(e);
        }
        
		
	}


}
