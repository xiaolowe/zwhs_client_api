package cn.org.citycloud.zwhs.bean;


import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;

public class RetailShopGoodBean {

	@Min(1)
	@ApiModelProperty(value="商品状态  1 上架   2 下架", required=true)
	private int goodsState;

	public int getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(int goodsState) {
		this.goodsState = goodsState;
	}

	
}
