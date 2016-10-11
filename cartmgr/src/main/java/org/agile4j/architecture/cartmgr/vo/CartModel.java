package org.agile4j.architecture.cartmgr.vo;

import org.agile4j.common.vo.BaseModel;

public class CartModel extends BaseModel {

	private Integer customerUuid ;
	private Integer goodsUuid ;
	private Integer buyNum ;
	
	public Integer getCustomerUuid() {
		return customerUuid;
	}
	public void setCustomerUuid(Integer customerUuid) {
		this.customerUuid = customerUuid;
	}
	public Integer getGoodsUuid() {
		return goodsUuid;
	}
	public void setGoodsUuid(Integer goodsUuid) {
		this.goodsUuid = goodsUuid;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	@Override
	public String toString() {
		return "CartModel [uuid()=" + getUuid() + ", customerUuid=" + customerUuid + ", goodsUuid=" + goodsUuid
				+ ", buyNum=" + buyNum + "]";
	}
	
	
}
