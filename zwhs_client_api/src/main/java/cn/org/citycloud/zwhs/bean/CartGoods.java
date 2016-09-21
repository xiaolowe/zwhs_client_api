package cn.org.citycloud.zwhs.bean;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 购物车商品Bean
 * 
 * @author lanbo
 *
 */
@ApiModel(value="购物车Model", description="购物车接口数据Model")
public class CartGoods {

	@Min(1)
	@ApiModelProperty(value="商品ID", required=true)
	private int goodsId;

	@Min(1)
	@ApiModelProperty(value="商品数量", required=true)
	private int goodsNum;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

}
