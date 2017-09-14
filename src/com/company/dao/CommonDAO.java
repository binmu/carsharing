package com.company.dao;

import java.util.List;
import java.util.Map;

public interface CommonDAO
{
	/**
	 * 查询的方法
	 * 
	 * @param clazz
	 *            确定要查询的类型
	 * @param query
	 *            查询语句
	 * @param params
	 *            查询参数
	 * @return
	 */
	public abstract <T> List<T> executeQuery(Class<?> clazz, String query,
                                             List<Object> params);

	/**
	 * 更新数据库的方法
	 * 
	 * @param obj
	 *            更新的实体对象
	 * @return
	 */
	public abstract int update(Object obj);

	/**
	 * 添加数据库的方法
	 * 
	 * @param obj
	 *            要添加的实体对象
	 * @return
	 */
	public abstract int add(Object obj);

	/**
	 * 删除数据库对象的方法
	 * 
	 * @param obj
	 *            要删除的实体对象
	 * @return
	 */
	public abstract int delete(Object obj);

	/**
	 * 自定义修改数据库状态的方法
	 * 
	 * @param query
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 受影响的行数
	 */
	public int executeUpdate(String query, List<Object> params);

	/**
	 * 事务批量修改数据的方法，该方法仅针对于批量的相同操作， 例如统一的批量删除、批量添加某些数据
	 * 
	 * @param query
	 *            预处理的SQL语句
	 * @param paramsMap
	 *            每个处理个体的参数列表
	 */
	public void executeUpdateBatch(String query,
                                   Map<Integer, List<Object>> paramsMap);

	/**
	 * 事务批量修改数据的方法，该方法仅针对于批量的不同操作， 例如更新一张表的数据后再更新另外一张表的数据
	 * 
	 * @param queryMap
	 *            查询的集合，其中key为每个操作的SQL语句，value是每个操作的参数列表
	 */
	public void executeUpdateBatch(Map<String, List<Object>> queryMap);
}