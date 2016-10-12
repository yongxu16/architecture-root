package org.agile4j.architecture.order.dao;

import org.agile4j.architecture.order.vo.OrderModel;
import org.agile4j.architecture.order.vo.OrderQueryModel;
import org.agile4j.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel, OrderQueryModel>{

}
