package cn.org.citycloud.zwhs.bean;

import java.util.ArrayList;
import java.util.List;

import cn.org.citycloud.zwhs.entity.StoreGood;

/**
 * 宝宝用品Bean
 * 
 * @author lanbo
 *
 */
public class BabyGoods {

	private int gcNo;

	private String gcName;

	private List<StoreGood> goods = new ArrayList<StoreGood>();

	public int getGcNo() {
		return gcNo;
	}

	public void setGcNo(int gcNo) {
		this.gcNo = gcNo;
	}

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public List<StoreGood> getGoods() {
		return goods;
	}

	public void setGoods(List<StoreGood> goods) {
		this.goods = goods;
	}

}
