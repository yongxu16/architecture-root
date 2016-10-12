package org.agile4j.architecture.order.vo;

import org.agile4j.common.vo.BaseModel;

public class OrderModel extends BaseModel{
	private Integer customerUuid ;
	private String orderTime ;
	private Double totalMoney ;
	private Double saveMoney ;
	private Integer state ;
	public Integer getCustomerUuid() {
		return customerUuid;
	}
	public void setCustomerUuid(Integer customerUuid) {
		this.customerUuid = customerUuid;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Double getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(Double saveMoney) {
		this.saveMoney = saveMoney;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "OrderModel [uuid=" + getUuid() + ", customerUuid=" + customerUuid + ", orderTime=" + orderTime
				+ ", totalMoney=" + totalMoney + ", saveMoney=" + saveMoney + ", state=" + state + "]";
	}
}
