package org.agile4j.architecture.order.vo;

import org.agile4j.common.vo.BaseModel;

public class OrderDetailModel extends BaseModel {

	private Integer orderUuid ;
	private Integer goodsUuid ;
	private Integer orderNum ;
	private Double price;
	private Double money;
	private Double saveMoney ;
	public Integer getOrderUuid() {
		return orderUuid;
	}
	public void setOrderUuid(Integer orderUuid) {
		this.orderUuid = orderUuid;
	}
	public Integer getGoodsUuid() {
		return goodsUuid;
	}
	public void setGoodsUuid(Integer goodsUuid) {
		this.goodsUuid = goodsUuid;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(Double saveMoney) {
		this.saveMoney = saveMoney;
	}
	@Override
	public String toString() {
		return "OrderDetailModel [uuid=" + getUuid() + ", orderUuid=" + orderUuid + ", goodsUuid=" + goodsUuid
				+ ", orderNum=" + orderNum + ", price=" + price + ", money=" + money + ", saveMoney=" + saveMoney + "]";
	}
	
	
}
