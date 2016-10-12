package org.agile4j.architecture.store.vo;

import org.agile4j.common.vo.BaseModel;

public class StoreModel extends BaseModel {

	private Integer goodsUuid ;
	private Integer storeNum ;
	
	public Integer getGoodsUuid() {
		return goodsUuid;
	}
	public void setGoodsUuid(Integer goodsUuid) {
		this.goodsUuid = goodsUuid;
	}
	public Integer getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}
	
	@Override
	public String toString() {
		return "StoreModel [uuid=" + getUuid() + ", goodsUuid=" + goodsUuid + ", storeNum=" + storeNum + "]";
	}
	
}
