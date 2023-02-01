package com.city.diary.dao;

import com.city.diary.model.UserModel;


public interface IUserDao {
	
	//按UID查询单个用户
	public UserModel SelectById(int no) throws Exception;
	//按手机号码查询单个用户
	public UserModel SelectByPhone(String userid) throws Exception;
	//用户注册
	public void insertUser(UserModel um) throws Exception;
	//修改用户信息
	public void updateUser(UserModel um) throws Exception;
}
