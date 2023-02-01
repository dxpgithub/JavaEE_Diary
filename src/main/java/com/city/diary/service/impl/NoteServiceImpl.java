package com.city.diary.service.impl;

import java.util.Date;
import java.util.List;

import com.city.diary.factory.DaoFactory;
import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;
import com.city.diary.service.INoteService;

/*
 * 
 */
public class NoteServiceImpl implements INoteService {

	@Override
	public void addnote(NoteModel nm) throws Exception {
		DaoFactory.createNoteDao().insertnote(nm);
		
	}

	@Override
	public List<NoteModel> findNoteByPage(int pagenum, int pagesize, int userid) throws Exception {
		
		return DaoFactory.createNoteDao().SelectNoteByPage(pagenum,pagesize,userid);
	}

	@Override
	public long findNoteCount(int userid) throws Exception {
		
		return DaoFactory.createNoteDao().SelectNoteCount(userid);
	}

	@Override
	public List<NoteModel> finNoteById(int noteid, int userid)throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createNoteDao().SelectNoteById(noteid,userid);
	}

	@Override
	public List<NoteModel> getByName(String notename, int userid) throws Exception {
		// TODO Auto-generated method stub
		return  DaoFactory.createNoteDao().SelectNoteByName(notename,userid);
	}

	@Override
	public List<NoteModel> getByType(String typename, int userid) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createNoteDao().SelectNoteByType(typename,userid);
	}

	@Override
	public List<NoteModel> getByDate(int userid) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createNoteDao().SelectNoteByDate(userid);
	}

	@Override
	public List<NoteModel> getByPubtime(Date pubdate, int userid,String endpubtime) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createNoteDao().SelectNoteByPubtime(pubdate,userid,endpubtime);
	}

}
