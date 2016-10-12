package org.agile4j.architecture.store.dao;

import org.agile4j.architecture.store.vo.StoreModel;
import org.agile4j.architecture.store.vo.StoreQueryModel;
import org.agile4j.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDao extends BaseDAO<StoreModel, StoreQueryModel>{

}
