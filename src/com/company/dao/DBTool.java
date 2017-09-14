package com.company.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBTool {
	private static DBTool instance;

	// ����ģʽ Singleton
	private DBTool() {

	}

	public static DBTool getInstance() {
		if (instance == null) {
			instance = new DBTool();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("conf/dbms.properties"));
			//�Լ����Բ���
			//p.load(new FileInputStream("conf/myLayTopdbms.properties"));
			String driverName = p.getProperty("driverName");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			// ע������
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		// 6����Դ�ر�
		close(rs);
		close(stmt);
		close(conn);
	}

	private static void close(AutoCloseable clo) {
		try {
			if (clo != null) {
				clo.close();
			}
			clo = null; //�����Ա�GC
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
