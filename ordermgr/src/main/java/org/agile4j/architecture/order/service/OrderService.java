package org.agile4j.architecture.order.service;

import org.agile4j.architecture.order.vo.OrderModel;
import org.agile4j.architecture.order.vo.OrderQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderModel, OrderQueryModel> implements IOrderService {

}
