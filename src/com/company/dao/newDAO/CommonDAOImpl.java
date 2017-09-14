package com.company.dao.newDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CommonDAOImpl implements CommonDAO {

	@Override
	@Deprecated
	public Object findOneByCondition(Class<?> clazz, String sql, Object... params) {

		Connection conn = DataSourceUtil.getInstance().getConnection();
		ResultSetHandler<Object> handler = new BeanHandler<>(clazz);
		Object obj = null;
		QueryRunner run = new QueryRunner();
		try {
			obj = run.query(conn, sql, handler, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public List<Object> findByCondition(Class<?> clazz, String sql, Object...params){
		
		Connection conn = DataSourceUtil.getInstance().getConnection();
		List<Object> objList = new ArrayList<>();
		QueryRunner run = new QueryRunner();
		ResultSetHandler<List<Object>> handler = new BeanListHandler<>(clazz);
		try {
			objList = run.query(conn, sql, handler, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objList;
	}
	
	@Override
	public int updateDataBase(String sql, Object...params) {
		Connection conn = DataSourceUtil.getInstance().getConnection();
		QueryRunner run = new QueryRunner();
		int row = 0;
		try {
			row = run.update(conn, sql, params);
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}
