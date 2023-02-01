package com.city.diary.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * 数据库连接工厂
 */
public class ConnectionFactory {
	private static DataSource ds=null;
	static {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/diary");
			ctx.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection()throws Exception{
		return ds.getConnection();
	}
}
