package com.company.dao;

import com.company.entity.CarInformation;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonDAOImpl implements CommonDAO {
	private Connection conn;

	@Override
	public <T> List<T> executeQuery(Class<?> clazz, String query, List<Object> params) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> itemList = new ArrayList<T>();
		try {
			conn = DBTool.getInstance().getConnection();
			// 设置隔离级别
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			ps = conn.prepareStatement(query);
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
			}
			rs = ps.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			// System.out.println(ps);
			while (rs.next()) {
				@SuppressWarnings("unchecked")
				T entity = (T) clazz.newInstance(); // 利用反射实例化一个对象
				for (Field field : fields) {
					// VERY IMPORTANT!!!
					field.setAccessible(true);
					Object rsVal = rs.getObject(field.getName());

					// ##############ORACLE##############
					Object val = null;
					if (rsVal.getClass() == BigDecimal.class) {
						if (field.getType() == Double.class) {
							val = ((BigDecimal) rsVal).doubleValue();
						} else if (field.getType() == Integer.class) {
							val = ((BigDecimal) rsVal).intValue();
						} else if (field.getType() == Long.class) {
							val = ((BigDecimal) rsVal).longValue();
						} else {
							val = rsVal;
						}
					} else {
						val = rsVal;
					}
					// ##############ORACLE##############
					field.set(entity, val);
				}
				itemList.add(entity);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | SecurityException e) {
			e.printStackTrace();
		} finally {
			DBTool.closeAll(rs, ps, conn);
		}
		return itemList;
	}

	public <T> List<T> executeQueryTwo(Class<?> clazz, String query, List<Object> params) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> itemList = new ArrayList<T>();
		try {
			conn = DBTool.getInstance().getConnection();
			// 设置隔离级别
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			ps = conn.prepareStatement(query);
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
			}
			rs = ps.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			// System.out.println(ps);
			while (rs.next()) {
				@SuppressWarnings("unchecked")
				T entity = (T) clazz.newInstance(); // 利用反射实例化一个对象
				for (Field field : fields) {
					// VERY IMPORTANT!!!
					field.setAccessible(true);
					Object rsVal = rs.getObject(field.getName());

					// ##############ORACLE##############
									
					// ##############ORACLE##############
					field.set(entity, rsVal);
				}
				itemList.add(entity);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | SecurityException e) {
			e.printStackTrace();
		} finally {
			DBTool.closeAll(rs, ps, conn);
		}
		return itemList;
	}

	public int executeUpdate(String query, List<Object> params) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBTool.getInstance().getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
			}
			System.out.println(ps);
			row = ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			DBTool.closeAll(rs, ps, conn);
		}
		return row;
	}

	public void executeUpdateBatch(String query, Map<Integer, List<Object>> paramsMap) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBTool.getInstance().getConnection();
			conn.setTransactionIsolation(8);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			Set<Integer> querySet = paramsMap.keySet();
			Iterator<Integer> it = querySet.iterator();
			while (it.hasNext()) {
				Integer idx = it.next();
				List<Object> params = paramsMap.get(idx);
				if (params.size() > 0) {
					for (int i = 0; i < params.size(); i++) {
						ps.setObject(i + 1, params.get(i));
					}
				}
				ps.addBatch();
				System.out.println(ps);
			}
			ps.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException | SecurityException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBTool.closeAll(rs, ps, conn);
		}
	}

	public void executeUpdateBatch(Map<String, List<Object>> queryMap) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBTool.getInstance().getConnection();
			conn.setTransactionIsolation(8);
			conn.setAutoCommit(false);
			Set<String> querySet = queryMap.keySet();
			Iterator<String> it = querySet.iterator();
			while (it.hasNext()) {
				String query = it.next();
				ps = conn.prepareStatement(query);
				List<Object> params = queryMap.get(query);
				if (params.size() > 0) {
					for (int i = 0; i < params.size(); i++) {
						ps.setObject(i + 1, params.get(i));
					}
				}
				ps.executeUpdate();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException | SecurityException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBTool.closeAll(rs, ps, conn);
		}
	}

	public int update2(Object obj, String tableName) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			Field[] fields = obj.getClass().getDeclaredFields();
			Field primaryField = null;
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE ");
			sb.append(tableName);
			sb.append(" SET ");
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				// 如果字段上标记了@Id注解，表示这是一个主键
				boolean b = fields[i].isAnnotationPresent(Id.class);
				if (!b) {
					if (i < fields.length - 1) {
						sb.append(fields[i].getName() + "=?,");
					} else {
						sb.append(fields[i].getName() + "=? ");
					}
					params.add(fields[i].get(obj));
				} else {
					primaryField = fields[i]; // 获取主键属性
				}
			}
			sb.append(" WHERE " + primaryField.getName() + "=?");
			System.out.println(sb);
			params.add(primaryField.get(obj));
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int updatePassword(String password, String user_id) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE user_customer SET password=? WHERE user_id=?");
			params.add(password);
			params.add(user_id);
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Object obj) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			Field[] fields = obj.getClass().getDeclaredFields();
			Field primaryField = null;
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE ");
			sb.append(obj.getClass().getSimpleName());
			sb.append(" SET ");
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				// 如果字段上标记了@Id注解，表示这是一个主键
				boolean b = fields[i].isAnnotationPresent(Id.class);
				if (!b) {
					if (i < fields.length - 1) {
						sb.append(fields[i].getName() + "=?,");
					} else {
						sb.append(fields[i].getName() + "=? ");
					}
					params.add(fields[i].get(obj));
				} else {
					primaryField = fields[i]; // 获取主键属性
				}
			}
			sb.append(" WHERE " + primaryField.getName() + "=?");
			params.add(primaryField.get(obj));
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int add2(Object obj, String tableName) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			Field[] fields = obj.getClass().getDeclaredFields();
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO ");
			sb.append(tableName);
			sb.append(" (");
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				if (i < fields.length - 1) {
					sb.append(fields[i].getName() + ",");
				} else {
					sb.append(fields[i].getName() + ") VALUES (");
				}
				params.add(fields[i].get(obj));
			}
			for (int i = 0; i < params.size() - 1; i++) {
				sb.append("?,");
			}
			sb.append("?)");
			System.out.println(sb.toString());
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int add(Object obj) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			Field[] fields = obj.getClass().getDeclaredFields();
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO ");
			sb.append(obj.getClass().getSimpleName());
			sb.append(" (");
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				// 如果字段上标记了@Id注解，表示这是一个主键
				boolean b = fields[i].isAnnotationPresent(Id.class);
				if (!b) {
					if (i < fields.length - 1) {
						sb.append(fields[i].getName() + ",");
					} else {
						sb.append(fields[i].getName() + ") VALUES (");
					}
					params.add(fields[i].get(obj));
				}
			}
			for (int i = 0; i < params.size() - 1; i++) {
				sb.append("?,");
			}
			sb.append("?)");
			System.out.println(sb.toString());
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int delete(Object obj) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			Field[] fields = obj.getClass().getDeclaredFields();
			Field primaryField = null;
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("DELETE FROM ");
			sb.append(obj.getClass().getSimpleName());
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				// 如果字段上标记了@Id注解，表示这是一个主键
				boolean b = fields[i].isAnnotationPresent(Id.class);
				if (b) {
					primaryField = fields[i]; // 获取主键属性
				}
			}
			sb.append(" WHERE " + primaryField.getName() + "=?");
			System.out.println(sb.toString());
			params.add(primaryField.get(obj));
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return row;
	}

	public boolean isPasswordRight(String oldPassword, String user_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String back = new String();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SElECT password from user_customer where user_id = '");
		stringBuffer.append(user_id);
		stringBuffer.append("'");
		conn = DBTool.getInstance().getConnection();
		try {
			ps = conn.prepareStatement(stringBuffer.toString());
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				back = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (back != null) {
			if (back.equals(oldPassword)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPasswordRight2(String oldPassword, String user_id, int identify) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String backPassword = new String();
		int backIdenfity = 10;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SElECT password,identify from user_customer where user_id = '");
		stringBuffer.append(user_id);
		stringBuffer.append("'");
		conn = DBTool.getInstance().getConnection();
		try {
			ps = conn.prepareStatement(stringBuffer.toString());
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				backPassword = rs.getString("password");
				backIdenfity = rs.getInt("identify");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (backPassword != null && backIdenfity != 10) {
			if (backIdenfity == identify) {
				if (backPassword.equals(oldPassword)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean searchClo(String searchInf, String tableName, String columnName) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> back = new ArrayList<>();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SElECT ");
		stringBuffer.append(columnName);
		stringBuffer.append(" AS inf FROM ");
		stringBuffer.append(tableName);
		conn = DBTool.getInstance().getConnection();
		try {
			ps = conn.prepareStatement(stringBuffer.toString());
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				back.add(rs.getString("inf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (back.size() != 0) {
			for (String backinf : back) {
				if (backinf.equals(searchInf)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<CarInformation> getAllInfFormTb_car(String tableName) {
		// TODO
		List<CarInformation> list = new ArrayList<>();
		StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
		stringBuffer.append(tableName);
		return executeQuery(CarInformation.class, stringBuffer.toString(), null);
	}

	public int setBlock(String sqlquery, String tableName, String primaryKey, String primaryInf, int isBlockUp) {
		int row = 0;
		try {
			// 获取到对象声明的所有属性字段
			List<Object> params = new ArrayList<Object>();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE ? SET isBlockUp=? WHERE ? = ? ");
			params.add(tableName);
			params.add(isBlockUp);
			params.add(primaryKey);
			params.add(primaryInf);
			row = executeUpdate(sb.toString(), params);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return row;
	}
}
