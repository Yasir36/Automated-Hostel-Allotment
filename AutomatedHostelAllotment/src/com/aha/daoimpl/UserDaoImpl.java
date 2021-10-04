package com.aha.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.aha.dao.UserDao;
import com.aha.dbc.DBConnection;
import com.aha.model.UserBean;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
	
	Connection con = DBConnection.getConnection();
	
	@Override
	public List<UserBean> getAllUsers() {
		List<UserBean> users = new ArrayList<UserBean>();
		UserBean user;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * from users");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) 
			{
				user = new UserBean();
				user.setId(Integer.parseInt(rs.getString("user_id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getString("user_type"));
				users.add(user);
			}
		return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getUserType(String username) {
		String userType = null;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
				userType = rs.getString("user_type");
			
			return userType;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int addUser(UserBean user) {
		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO users(username,password,user_type) VALUES(?,?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getUserType());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int registerStudent(String rollNo, String state) {
		try {
			PreparedStatement pst = con.prepareStatement("UPDATE users SET registration_state=? WHERE username=?");
			pst.setString(1, state);
			pst.setString(2, rollNo);
			System.out.println("Student Registered!");
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int authenticateUser(String username, String password) {
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username = ? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean isRegistered(String username) {
		try {
			PreparedStatement pst= con.prepareStatement("SELECT registration_state FROM users WHERE username=?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getString("registration_state").equalsIgnoreCase("Registered")) 
					return true;
			}
		}
		catch(Exception e)
		{e.printStackTrace();;}
		return false;
	}

	@Override
	public UserBean getUser(String rollNo) {
		UserBean user = null;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * from users WHERE rollNo=?");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) 
			{
				user = new UserBean();
				user.setId(Integer.parseInt(rs.getString("user_id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getString("user_type"));
			}
		return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
