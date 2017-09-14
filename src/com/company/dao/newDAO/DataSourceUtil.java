package com.company.dao.newDAO;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DataSourceUtil {
	private DruidDataSource ds;
	private static DataSourceUtil instance;

	private DataSourceUtil() {
		ds = new DruidDataSource();
	}

	public static DataSourceUtil getInstance() {
		if (instance == null) {
			instance = new DataSourceUtil();
		}
		return instance;
	}

	public Connection getConnection() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("conf/dbms.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String driverName = p.getProperty("driverName");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setValidationQuery("SELECT 1");
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ds.close();
		}
		return conn;
	}
}
