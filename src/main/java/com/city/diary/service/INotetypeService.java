package com.city.diary.service;

import java.util.List;

import com.city.diary.model.NotetypeModel;

public interface INotetypeService {

	public 	List<NotetypeModel> getByAll(int uid) throws Exception;
	public void delete(NotetypeModel ntm) throws Exception;
	public void addtype(NotetypeModel ntm) throws Exception;
	public void changetype(NotetypeModel ntm) throws Exception;
	
	public int checkTypeName(NotetypeModel ntm)throws Exception;
}
