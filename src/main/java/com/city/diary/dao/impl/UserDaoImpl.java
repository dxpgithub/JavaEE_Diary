package com.city.diary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.city.diary.dao.IUserDao;
import com.city.diary.model.UserModel;
import com.city.diary.util.ConnectionFactory;

public class UserDaoImpl implements IUserDao {

	@Override
	public UserModel SelectById(int userid) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		UserModel user=null;
		String sql="select * from diaryuser where userid=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, (int) userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			user=new UserModel();
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setUserpassword(rs.getString("userpwd"));
			user.setUserphone(rs.getString("userphone"));
			user.setUsersex(rs.getString("usersex"));
			user.setUsermood(rs.getString("mood"));
			if(rs.getString("phototype")!=null) {
				user.setPhotoType(rs.getString("phototype"));
				user.setPhoto(rs.getBytes("headphoto"));
				
			}
		}
		
		rs.close();
		ps.close();
		cn.close();
		return user;
		}

	@Override
	public UserModel SelectByPhone(String userid) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		UserModel user=null;
		String sql="select * from diaryuser where userphone=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			user=new UserModel();
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setUserpassword(rs.getString("userpwd"));
			user.setUserphone(rs.getString("userphone"));
			user.setUsersex(rs.getString("usersex"));
			user.setUsermood(rs.getString("mood"));
			if(rs.getString("phototype")!=null) {
				user.setPhotoType(rs.getString("phototype"));
				user.setPhoto(rs.getBytes("headphoto"));
				
			}
		}
		
		rs.close();
		ps.close();
		cn.close();
		return user;
	}

	@Override
	public void insertUser(UserModel um) throws Exception {
		Connection cn=ConnectionFactory.getConnection();//调用数据库连接池
		String sql="insert into diaryuser(username,userpwd,userphone,usersex,headphoto,phototype,mood)values(?,?,?,?,?,?,?)";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1,um.getUsername());
		ps.setString(2, um.getUserpassword());
		ps.setString(3, um.getUserphone());
		ps.setString(4, um.getUsersex());
		ps.setBytes(5, um.getPhoto());
		ps.setString(6, um.getPhotoType());
		ps.setString(7, um.getUsermood());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void updateUser(UserModel um) throws Exception {
		Connection cn=ConnectionFactory.getConnection();//调用数据库连接池
		String sqlone="update diaryuser set username=?,userpwd=?,userphone=?,usersex=?,headphoto=?,phototype=?,mood=? where userid=?";
		PreparedStatement ps=cn.prepareStatement(sqlone);
		ps.setString(1,um.getUsername());
		ps.setString(2, um.getUserpassword());
		ps.setString(3, um.getUserphone());
		ps.setString(4, um.getUsersex());
		ps.setBytes(5, um.getPhoto());
		ps.setString(6, um.getPhotoType());
		ps.setString(7, um.getUsermood());
		ps.setInt(8, um.getUserid());
		
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
	

}
