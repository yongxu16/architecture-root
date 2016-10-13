package org.agile4j.architecture.order.service;

import org.agile4j.architecture.order.dao.OrderDAO;
import org.agile4j.architecture.order.vo.OrderModel;
import org.agile4j.architecture.order.vo.OrderQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderModel, OrderQueryModel> implements IOrderService {

	private OrderDAO orderDAO ;
	@Autowired
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
		super.setDao(orderDAO);
	}
}
