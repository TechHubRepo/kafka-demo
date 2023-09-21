package com.techhub.kafka.producer.vo;

import java.io.Serializable;
import java.util.List;

public class OrderInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private OrderVo order;
	
	private List<OrderItemVo> itemsList;

	public OrderInfoVo() {
		super();
	}

	public OrderInfoVo(OrderVo order, List<OrderItemVo> itemsList) {
		super();
		this.order = order;
		this.itemsList = itemsList;
	}

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

	public List<OrderItemVo> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<OrderItemVo> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "OrderInfo [order=" + order + ", itemsList=" + itemsList + "]";
	}
}
