package org.agile4j.architecture.order.dao;

import org.agile4j.architecture.order.vo.OrderDetailModel;
import org.agile4j.architecture.order.vo.OrderDetailQueryModel;
import org.agile4j.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel, OrderDetailQueryModel>{

}
