package org.agile4j.architecture.customermgr.service;

import org.agile4j.architecture.customermgr.dao.CustomerDAO;
import org.agile4j.architecture.customermgr.vo.CustomerModel;
import org.agile4j.architecture.customermgr.vo.CustomerQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> implements ICustomerService {
	
	private CustomerDAO customerDAO = null ;
	@Autowired
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
		super.setDao(customerDAO);
	}
	
	@Override
	public CustomerModel getByCustomerId(String customerId) {
		return customerDAO.getByCustomerId(customerId);
	}
	
	
}
