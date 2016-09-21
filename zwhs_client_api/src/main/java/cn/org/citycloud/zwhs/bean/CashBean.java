package cn.org.citycloud.zwhs.bean;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModelProperty;

public class CashBean {

	@NotNull(message = "请输入申请提现金额")
	@ApiModelProperty(value = "申请提现金额", required = true)
	private BigDecimal applyMoney;

	public BigDecimal getApplyMoney() {
		return applyMoney;
	}

	public void setApplyMoney(BigDecimal applyMoney) {
		this.applyMoney = applyMoney;
	}
	
	
	


	
	
	
}
