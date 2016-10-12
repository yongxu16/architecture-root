package org.agile4j.architecture.goods.dao;

import org.agile4j.architecture.goods.vo.GoodsModel;
import org.agile4j.architecture.goods.vo.GoodsQueryModel;
import org.agile4j.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel, GoodsQueryModel>{

}
