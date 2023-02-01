package com.city.diary.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.diary.dao.INotetypeDao;
import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;
import com.city.diary.util.ConnectionFactory;


public class NotetypeDaoImpl implements INotetypeDao {

	@Override
	public List<NotetypeModel>  SelectByAll(int uid) throws Exception {
		List<NotetypeModel> list=new ArrayList<NotetypeModel>();
		String sql="select * from notetype where userid=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, uid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NotetypeModel ntm=new NotetypeModel();
			ntm.setTypeid(rs.getInt("typeid"));
			ntm.setTypename(rs.getString("typename"));
			ntm.setUserid(rs.getInt("userid"));
			list.add(ntm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public void deletetype(NotetypeModel ntm) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="delete from notetype  where typename='"+ntm.getTypename()+"' and userid=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, ntm.getUserid());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void inserttype(NotetypeModel ntm) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="insert into notetype (typename,userid) values(?,?)";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, ntm.getTypename());
		ps.setInt(2, ntm.getUserid());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void updatetype(NotetypeModel ntm) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="update  notetype set typename=? where typeid=? and userid=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setString(1, ntm.getTypename());
		ps.setInt(2, ntm.getTypeid());
		ps.setInt(3, ntm.getUserid());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public int checkTypeName(NotetypeModel ntm) throws Exception {
		Connection cn=ConnectionFactory.getConnection();
		String sql="select * from  notetype where typename='"+ntm.getTypename()+"' and userid=?";
		int typeid=Integer.valueOf(ntm.getTypeid()) ;
		List<NotetypeModel> list=new ArrayList<NotetypeModel>();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, ntm.getUserid());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			ntm.setTypeid(rs.getInt("typeid"));
			ntm.setTypename(rs.getString("typename"));
			ntm.setUserid(rs.getInt("userid"));
			list.add(ntm);
		}
		rs.close();
		ps.close();
		cn.close();
		if(list==null) {
			return 1;
		}else if(typeid==ntm.getTypeid()){
			return 1;
		}
		return 0;
	}

	

	

}
