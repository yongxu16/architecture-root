package org.agile4j.common.service;

import org.agile4j.common.utils.page.Page;
import org.agile4j.common.vo.BaseModel;

/**
 * Service 模板接口
 * 
 * @author Administrator
 *
 */
public interface IBaseService<M, QM extends BaseModel> {
	void create(M m);

	void update(M m);

	void delete(int id);

	M getByUuid(int id);

	Page<M> getByConditionPage(QM qm);
}
