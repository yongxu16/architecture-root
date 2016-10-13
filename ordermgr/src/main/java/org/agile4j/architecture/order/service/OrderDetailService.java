package org.agile4j.architecture.order.service;

import org.agile4j.architecture.order.dao.OrderDetailDAO;
import org.agile4j.architecture.order.vo.OrderDetailModel;
import org.agile4j.architecture.order.vo.OrderDetailQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService extends BaseService<OrderDetailModel, OrderDetailQueryModel> implements IOrderDetailService {

	private OrderDetailDAO orderDetailDAO ;
	@Autowired
	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
		super.setDao(orderDetailDAO);
	}
}
