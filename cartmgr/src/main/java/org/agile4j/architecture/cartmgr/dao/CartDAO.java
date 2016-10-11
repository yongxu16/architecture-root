package org.agile4j.architecture.cartmgr.dao;

import org.agile4j.architecture.cartmgr.vo.CartModel;
import org.agile4j.architecture.cartmgr.vo.CartQueryModel;
import org.agile4j.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO extends BaseDAO<CartModel, CartQueryModel> {

}
