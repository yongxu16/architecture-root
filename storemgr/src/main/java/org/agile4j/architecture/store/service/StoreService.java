package org.agile4j.architecture.store.service;

import org.agile4j.architecture.store.dao.StoreDao;
import org.agile4j.architecture.store.vo.StoreModel;
import org.agile4j.architecture.store.vo.StoreQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService extends BaseService<StoreModel, StoreQueryModel> implements IStoreService {

	private StoreDao dao ;
	@Autowired
	public void setDao(StoreDao dao) {
		this.dao = dao;
		super.setDao(dao);
	}
}
