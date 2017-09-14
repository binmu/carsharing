package com.company.dao.newDAO;

import java.util.List;

public interface CommonDAO {

	/**
	 * 	@author jheng
	 *	@link findByCondition
	 *	use findByCondition instead. if you want to get single object, just get an array list first, then get by index.
	 */
	Object findOneByCondition(Class<?> clazz, String sql, Object... params);

	/**
	 * Query By Condition
	 * @param clazz 	Entity type for search
	 * @param sql	SQL for execute statement, use PreparedStatement SQL
	 * @param params	Parameters for query condition
	 * @return
	 */

	List<Object> findByCondition(Class<?> clazz, String sql, Object... params);

	/**
	 * for INSERT、UPDATE or DELETE
	 * @param sql		SQL for execute statement, use PreparedStatement SQL
	 * @param params		Parameters for query condition
	 * @return			affected rows
	 */
	int updateDataBase(String sql, Object... params);

}