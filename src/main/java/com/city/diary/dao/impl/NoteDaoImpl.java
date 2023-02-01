package com.city.diary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.city.diary.dao.INoteDao;
import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;
import com.city.diary.util.ConnectionFactory;
import com.city.diary.util.DateUtils;



public class NoteDaoImpl implements INoteDao {

	@Override
	public void insertnote(NoteModel nm) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="insert into note (title,content,typeid,pubtime,noteowner) values(?,?,?,now(),?)";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1,nm.getTitle() );
		ps.setString(2, nm.getContent());
		ps.setInt(3,nm.getTypeid());
		ps.setInt(4, nm.getNoteowner());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public List<NoteModel> SelectNoteByPage(int pagenum, int pagesize, int userid) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="select * from note  where noteowner=? limit ?,?";
		List<NoteModel> list=new ArrayList<NoteModel>();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1,userid);
		ps.setInt(2,pagenum);
		ps.setInt(3,pagesize);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NoteModel nm=new NoteModel();
			nm.setNoteid(rs.getInt("noteid"));
			nm.setTitle(rs.getString("title"));
			nm.setContent(rs.getString("content"));
			nm.setTypeid(rs.getInt("typeid"));
			nm.setPubtime(rs.getDate("pubtime"));
			nm.setNoteowner(rs.getInt("noteowner"));
			list.add(nm);
		}
		return list;
	}

	@Override
	public long SelectNoteCount(int userid) throws Exception  {
		Connection cn=ConnectionFactory.getConnection();
		String sql="select count(1) from note where noteowner=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1,userid);
		ResultSet rs=ps.executeQuery();
		long count=0;
		if(rs.next()) {
			count=rs.getLong(1);
		}
		return count;
	}

	@Override
	public List<NoteModel> SelectNoteById(int noteid, int userid)throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="select * from note  where noteid=? and noteowner=? ";
		List<NoteModel> list=new ArrayList<NoteModel>();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1,noteid);
		ps.setInt(2,userid);
	
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NoteModel nm=new NoteModel();
			nm.setNoteid(rs.getInt("noteid"));
			nm.setTitle(rs.getString("title"));
			nm.setContent(rs.getString("content"));
			nm.setTypeid(rs.getInt("typeid"));
			nm.setPubtime(rs.getDate("pubtime"));
			nm.setNoteowner(rs.getInt("noteowner"));
			list.add(nm);
		}
		return list;
	}

	@Override
	public List<NoteModel> SelectNoteByName(String notename, int userid) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="select * from note  where title like '%"+notename+"%' and noteowner=? ";
		List<NoteModel> list=new ArrayList<NoteModel>();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setInt(1,userid);
	
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NoteModel nm=new NoteModel();
			nm.setNoteid(rs.getInt("noteid"));
			nm.setTitle(rs.getString("title"));
			nm.setContent(rs.getString("content"));
			nm.setTypeid(rs.getInt("typeid"));
			nm.setPubtime(rs.getDate("pubtime"));
			nm.setNoteowner(rs.getInt("noteowner"));
			list.add(nm);
		}
		return list;
	}

	@Override
	public List<NoteModel> SelectNoteByType(String typename, int userid) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="select * from note  where typeid="+typename+" and noteowner=? ";
		List<NoteModel> list=new ArrayList<NoteModel>();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setInt(1,userid);
	
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NoteModel nm=new NoteModel();
			nm.setNoteid(rs.getInt("noteid"));
			nm.setTitle(rs.getString("title"));
			nm.setContent(rs.getString("content"));
			nm.setTypeid(rs.getInt("typeid"));
			nm.setPubtime(rs.getDate("pubtime"));
			nm.setNoteowner(rs.getInt("noteowner"));
			list.add(nm);
		}
		return list;
	}

	@Override
	public List<NoteModel> SelectNoteByDate(int userid) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="SELECT DATE_FORMAT(pubtime, '%Y-%m')pubtime,COUNT(*)total\r\n"
				+ "FROM note WHERE noteowner=?\r\n"
				+ "GROUP BY DATE_FORMAT(pubtime, '%Y-%m') ;";
		List<NoteModel> list=new ArrayList<NoteModel>();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setInt(1,userid);
	
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NoteModel nm=new NoteModel();
			nm.setPubtime(DateUtils.StrToDate(rs.getString("pubtime")));
			nm.setTotal(rs.getInt("total"));
			list.add(nm);
		}
		return list;
	}

	@Override
	public List<NoteModel> SelectNoteByPubtime(Date pubdate, int userid,String endpubtime) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="SELECT * FROM note WHERE noteowner=? AND DATE(pubtime) BETWEEN '"+pubdate+"' AND '"+endpubtime+"'";
		List<NoteModel> list=new ArrayList<NoteModel>();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setInt(1,userid);
	
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NoteModel nm=new NoteModel();
			nm.setNoteid(rs.getInt("noteid"));
			nm.setTitle(rs.getString("title"));
			nm.setContent(rs.getString("content"));
			nm.setTypeid(rs.getInt("typeid"));
			nm.setPubtime(rs.getDate("pubtime"));
			nm.setNoteowner(rs.getInt("noteowner"));
			list.add(nm);
		}
		return list;
	}

}
