package com.city.diary.service;

import com.city.diary.model.UserModel;

public interface IUserService {
	//增加用户
	public void add(UserModel um) throws Exception;
	//修改用户信息
	public void modify(UserModel um) throws Exception;
	//删除用户
	public void delete(UserModel um) throws Exception;
	//按用户UID查找
	public UserModel getById(int no) throws Exception;
	//按用户电话号码查找
	public UserModel getByPhone(String userid) throws Exception;
}
