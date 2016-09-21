package cn.org.citycloud.zwhs.bean;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="分销店铺商品Model", description="分销店铺商品接口数据Model")
public class DistShopGoodsSearch extends SliceAndSort {

	private int memberId;
	
	@ApiModelProperty(value="排序关键字", required=true)
	private String keyword;
	
	@ApiModelProperty(value="商品状态（1 上架   2  下架）", required=false)
	@Min(0)
	private int status;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
