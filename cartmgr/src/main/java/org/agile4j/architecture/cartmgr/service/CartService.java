package org.agile4j.architecture.cartmgr.service;

import org.agile4j.architecture.cartmgr.dao.CartDAO;
import org.agile4j.architecture.cartmgr.vo.CartModel;
import org.agile4j.architecture.cartmgr.vo.CartQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends BaseService<CartModel, CartQueryModel> implements ICartService {

	private CartDAO cartDAO ;
	@Autowired
	public void setDao(CartDAO dao) {
		this.cartDAO = dao ;
		super.setDao(dao);
	}
	
}
