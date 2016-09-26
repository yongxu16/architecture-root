package org.agile4j.common.service;

import java.util.List;

import org.agile4j.common.dao.BaseDAO;
import org.agile4j.common.utils.page.Page;
import org.agile4j.common.vo.BaseModel;

/**
 * Service 模板 实现类
 * 
 * @author Administrator
 *
 */
public class BaseService<M, QM extends BaseModel> implements IBaseService<M, QM> {
	private BaseDAO dao;
	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	@Override
	public void create(M m) {
		dao.create(m);
	}

	@Override
	public void update(M m) {
		dao.update(m);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public M getById(int id) {
		return (M) dao.getById(id);
	}

	@Override
	public Page<M> getByConditionPage(QM qm) {
		List<M> list = dao.getByConditionPage(qm);
		qm.getPage().setResult(list);
		return qm.getPage();
	}
}
