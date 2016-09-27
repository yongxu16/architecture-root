package org.agile4j.architecture.customermgr.dao;

import org.agile4j.architecture.customermgr.vo.CustomerModel;
import org.agile4j.architecture.customermgr.vo.CustomerQueryModel;
import org.agile4j.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel, CustomerQueryModel>{
	public CustomerModel getByCustomerId(String customerId);
}
