package com.city.diary.dao;

import java.util.List;

import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;

public interface INotetypeDao {
	//按UID查询单个用户
	public List<NotetypeModel> SelectByAll(int uid) throws Exception;
	public void deletetype(NotetypeModel ntm)throws Exception;
	public void inserttype(NotetypeModel ntm)throws Exception;
	public void updatetype(NotetypeModel ntm)throws Exception;
	
	
	public int checkTypeName(NotetypeModel ntm)throws Exception;
	
}
