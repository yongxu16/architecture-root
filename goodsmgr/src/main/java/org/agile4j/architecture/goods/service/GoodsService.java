package org.agile4j.architecture.goods.service;

import org.agile4j.architecture.goods.dao.GoodsDAO;
import org.agile4j.architecture.goods.vo.GoodsModel;
import org.agile4j.architecture.goods.vo.GoodsQueryModel;
import org.agile4j.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends BaseService<GoodsModel, GoodsQueryModel> implements IGoodsService{

	private GoodsDAO goodsDao ;
	@Autowired
	public void setGoodsDao(GoodsDAO goodsDao) {
		this.goodsDao = goodsDao;
		super.setDao(goodsDao);
	}
}
