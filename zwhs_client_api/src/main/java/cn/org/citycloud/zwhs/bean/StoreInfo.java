package cn.org.citycloud.zwhs.bean;

/**
 * 店铺信息Bean
 * 
 * @author lanbo
 *
 */
public class StoreInfo {

	private int storeId;

	private String companyAddress;

	private String companyName;

	private String content;

	private String storeAliasName;

	private String storeImage;

	private String storeNo;

	private String storeOwner;

	private String userPhone;

	private int storeState;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStoreAliasName() {
		return storeAliasName;
	}

	public void setStoreAliasName(String storeAliasName) {
		this.storeAliasName = storeAliasName;
	}

	public String getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(String storeOwner) {
		this.storeOwner = storeOwner;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getStoreState() {
		return storeState;
	}

	public void setStoreState(int storeState) {
		this.storeState = storeState;
	}

}
