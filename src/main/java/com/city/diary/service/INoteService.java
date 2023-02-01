package com.city.diary.service;

import java.util.Date;
import java.util.List;

import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;


public interface INoteService {
	public void addnote(NoteModel nm) throws Exception;
	public List<NoteModel> findNoteByPage(int pagenum,int pagesize,int userid)throws Exception;
	public long findNoteCount(int userid) throws Exception;
	public List<NoteModel> finNoteById(int noteid, int userid)throws Exception;
	public List<NoteModel> getByName(String notename, int userid)throws Exception;
	public List<NoteModel> getByType(String typename, int userid)throws Exception;
	public List<NoteModel> getByDate(int userid)throws Exception;
	public List<NoteModel> getByPubtime(Date pubdate, int userid, String endpubdate)throws Exception;
}
