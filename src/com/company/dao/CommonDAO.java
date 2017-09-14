package com.company.dao;

import java.util.List;
import java.util.Map;

public interface CommonDAO
{
	/**
	 * ��ѯ�ķ���
	 * 
	 * @param clazz
	 *            ȷ��Ҫ��ѯ������
	 * @param query
	 *            ��ѯ���
	 * @param params
	 *            ��ѯ����
	 * @return
	 */
	public abstract <T> List<T> executeQuery(Class<?> clazz, String query,
                                             List<Object> params);

	/**
	 * �������ݿ�ķ���
	 * 
	 * @param obj
	 *            ���µ�ʵ�����
	 * @return
	 */
	public abstract int update(Object obj);

	/**
	 * ������ݿ�ķ���
	 * 
	 * @param obj
	 *            Ҫ��ӵ�ʵ�����
	 * @return
	 */
	public abstract int add(Object obj);

	/**
	 * ɾ�����ݿ����ķ���
	 * 
	 * @param obj
	 *            Ҫɾ����ʵ�����
	 * @return
	 */
	public abstract int delete(Object obj);

	/**
	 * �Զ����޸����ݿ�״̬�ķ���
	 * 
	 * @param query
	 *            SQL���
	 * @param params
	 *            ����
	 * @return ��Ӱ�������
	 */
	public int executeUpdate(String query, List<Object> params);

	/**
	 * ���������޸����ݵķ������÷������������������ͬ������ ����ͳһ������ɾ�����������ĳЩ����
	 * 
	 * @param query
	 *            Ԥ�����SQL���
	 * @param paramsMap
	 *            ÿ���������Ĳ����б�
	 */
	public void executeUpdateBatch(String query,
                                   Map<Integer, List<Object>> paramsMap);

	/**
	 * ���������޸����ݵķ������÷���������������Ĳ�ͬ������ �������һ�ű�����ݺ��ٸ�������һ�ű������
	 * 
	 * @param queryMap
	 *            ��ѯ�ļ��ϣ�����keyΪÿ��������SQL��䣬value��ÿ�������Ĳ����б�
	 */
	public void executeUpdateBatch(Map<String, List<Object>> queryMap);
}