package org.agile4j.architecture.customermgr;

import org.agile4j.architecture.customermgr.service.ICustomerService;
import org.agile4j.architecture.customermgr.vo.CustomerModel;
import org.agile4j.architecture.customermgr.vo.CustomerQueryModel;
import org.agile4j.common.utils.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Client {
	@Autowired
	private ICustomerService customerService = null;
	
	public ICustomerService getS(){
		return customerService;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
		Client test = (Client)ctx.getBean("client");
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("hanyx");
		cm.setPwd("hanyx");
		cm.setRegisterTime("001");
		cm.setShowName("hanyx");
		cm.setTrueName("韩永续");
		test.getS().create(cm);
		
		CustomerQueryModel cqm = new CustomerQueryModel();
		cqm.getPage().setPageShow(2);
		cqm.getPage().setNowPage(1);
		
		Page<CustomerModel> p = test.getS().getByConditionPage(cqm);
		
		System.out.println("list=="+p);
		
		
		
		Page<CustomerModel> p2 = test.getS().getByConditionPage(cqm);
		
		System.out.println("list2222=="+p);
	}
}
