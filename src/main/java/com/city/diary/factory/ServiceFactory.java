package com.city.diary.factory;


import com.city.diary.service.INoteService;
import com.city.diary.service.INotetypeService;
import com.city.diary.service.IUserService;
import com.city.diary.service.impl.NoteServiceImpl;
import com.city.diary.service.impl.NotetypeServiceImpl;
import com.city.diary.service.impl.UserServiceImpl;

public class ServiceFactory {
	
	
	//创建用户业务对象
	public static IUserService createUserService() {
		return new UserServiceImpl();
	}

	public static INotetypeService createNotetypeService() {
		// TODO Auto-generated method stub
		return new NotetypeServiceImpl();
	}
	public static INoteService createNoteService() {
		// TODO Auto-generated method stub
		return new NoteServiceImpl();
	}
	
}
