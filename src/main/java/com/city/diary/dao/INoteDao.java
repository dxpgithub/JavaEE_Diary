package com.city.diary.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;

public interface INoteDao {
	public void insertnote(NoteModel nm)throws Exception;
	public List<NoteModel> SelectNoteByPage(int pagenum, int pagesize, int userid)throws Exception;
	public long SelectNoteCount(int userid) throws Exception;
	public List<NoteModel> SelectNoteById(int noteid, int userid)throws Exception;
	public List<NoteModel> SelectNoteByName(String notename, int userid)throws Exception;
	public List<NoteModel> SelectNoteByType(String typename, int userid)throws Exception;
	public List<NoteModel> SelectNoteByDate(int userid)throws Exception;
	public List<NoteModel> SelectNoteByPubtime(Date pubdate, int userid, String endpubtime)throws Exception; 
}
