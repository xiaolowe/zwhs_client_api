package cn.org.citycloud.zwhs.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class PayOrder {

	@Min(1)
	private int orderId;

	@NotEmpty
	private String productName;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
