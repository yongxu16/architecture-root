package org.agile4j.common.dao;

import java.util.List;

/**
 * DAO模板类
 * 
 * @author Administrator
 *
 */
public interface BaseDAO<M, QM> {
	void create(M m);

	void update(M m);

	void delete(int id);

	M getById(int id);

	List<M> getByConditionPage(QM qm);
}
