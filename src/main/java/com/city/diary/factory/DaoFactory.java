package com.city.diary.factory;
/*
 * HR模块的DAO工厂类
 */


import com.city.diary.dao.INoteDao;
import com.city.diary.dao.INotetypeDao;
import com.city.diary.dao.IUserDao;
import com.city.diary.dao.impl.NoteDaoImpl;
import com.city.diary.dao.impl.NotetypeDaoImpl;
import com.city.diary.dao.impl.UserDaoImpl;


public class DaoFactory {
	public static IUserDao createUserDao() {
		return new UserDaoImpl();
	}
	public static INotetypeDao createNotetypeDao() {
		return new NotetypeDaoImpl();
	}
	public static INoteDao createNoteDao() {
		return new NoteDaoImpl();
	}
}
