package com.city.diary.service.impl;

import com.city.diary.factory.DaoFactory;
import com.city.diary.model.UserModel;
import com.city.diary.service.IUserService;


public  class UserServiceImpl implements IUserService {


	public void add(UserModel um) throws Exception {
		DaoFactory.createUserDao().insertUser(um);
	}

	@Override
	public void modify(UserModel um) throws Exception {
		DaoFactory.createUserDao().updateUser(um);
	}

	@Override
	public void delete(UserModel um) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public UserModel getByPhone(String userid) throws Exception {
		
		return DaoFactory.createUserDao().SelectByPhone(userid);
	}
	@Override
	public UserModel getById(int no) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createUserDao().SelectById(no);
	}
}
