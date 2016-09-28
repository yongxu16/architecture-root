package org.agile4j.test.service;

import org.agile4j.architecture.customermgr.service.ICustomerService;
import org.agile4j.architecture.customermgr.vo.CustomerModel;
import org.agile4j.architecture.customermgr.vo.CustomerQueryModel;
import org.agile4j.common.utils.page.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")
public class ServiceTest {

	private static final Logger LOGGER = LogManager.getLogger(ServiceTest.class);

	@Autowired
	private ICustomerService customerService;

	@Test
	public void save() {
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("hanyx02");
		cm.setPwd("hanyx");
		cm.setRegisterTime("004");
		cm.setShowName("hanyx");
		cm.setTrueName("韩永续");
//		customerService.create(cm);
		
//		try {
//			Method method = StatementHandler.class.getMethod("prepare", Connection.class,Integer.class);
//			LOGGER.debug(method.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void getByConditionPage() {
		CustomerQueryModel cqm = new CustomerQueryModel();
		cqm.getPage().setRowCount(2);
		cqm.getPage().setNowPage(1);
		Page<CustomerModel> page = customerService.getByConditionPage(cqm);
		LOGGER.debug(page);
	}
}
