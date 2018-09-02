package com.techsoft.studentinfo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techsoft.studentinfo.dto.User;
import com.techsoft.studentinfo.util.DbUtil;

public class UserDaoImpl implements UserDao {
	PreparedStatement ps = null;

	@Override
	public void saveUserInfo(User user) {
		String sql = "insert into userinfo(firstName,lastName,gender,dob,email,userName,password,image_url)values(?,?,?,?,?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getGender());
			ps.setDate(4, new java.sql.Date(user.getDob().getTime()));
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getUsername());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getImageUrl());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUserInfo(User user) {
		String sql = "update  userinfo set firstName=?,lastName=?,gender=?,dob=?,email=?,userName=?,password=?,image_url=? where userid=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getGender());
			ps.setDate(4, new java.sql.Date(user.getDob().getTime()));
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getUsername());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getImageUrl());
			ps.setInt(9, user.getUserId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserInfo(int id) {
		String sql="delete from userinfo where userid=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		String sql = "select * from userinfo";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		String sql = "select * from userinfo where userid=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String getImageUrl(int id) {
		String sql = "select image_url from userinfo where userid=?";
		String imageUrl = "";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				imageUrl = rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return imageUrl;
	}

	@Override
	public int checkUser(String userName, String password) {
		String sql="select userid from userinfo where userName=? and password=? ";
		int isUser=0;
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
					isUser=rs.getInt("userid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return isUser;
	}

	@Override
	public User checkEmail(String email) {
		String sql="select * from userinfo where email=? ";
		User user=new User();
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return user;
	}

}
