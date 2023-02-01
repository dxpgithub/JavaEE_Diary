package com.city.diary.service.impl;

import java.util.List;

import com.city.diary.factory.DaoFactory;
import com.city.diary.model.NotetypeModel;
import com.city.diary.service.INotetypeService;
/*
 * 部门业务实现类
 */
public class NotetypeServiceImpl implements INotetypeService {


	@Override
	public List<NotetypeModel> getByAll(int uid) throws Exception {
		
		return DaoFactory.createNotetypeDao().SelectByAll(uid);
	}
	@Override
	public void delete(NotetypeModel ntm) throws Exception {
		DaoFactory.createNotetypeDao().deletetype(ntm);
	}
	@Override
	public void addtype(NotetypeModel ntm) throws Exception {
		DaoFactory.createNotetypeDao().inserttype(ntm);
		
	}
	@Override
	public void changetype(NotetypeModel ntm) throws Exception {
		DaoFactory.createNotetypeDao().updatetype(ntm);
		
	}
	@Override
	public int checkTypeName(NotetypeModel ntm) throws Exception {
		
		return DaoFactory.createNotetypeDao().checkTypeName(ntm);
	}

	


}
