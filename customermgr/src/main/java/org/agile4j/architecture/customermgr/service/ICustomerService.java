package org.agile4j.architecture.customermgr.service;

import org.agile4j.architecture.customermgr.vo.CustomerModel;
import org.agile4j.architecture.customermgr.vo.CustomerQueryModel;
import org.agile4j.common.service.IBaseService;

public interface ICustomerService extends IBaseService<CustomerModel, CustomerQueryModel> {
	public CustomerModel getByCustomerId(String customerId);
}
