package cn.org.citycloud.zwhs.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="分销用户Model", description="分销用户接口数据Model")
public class RetailMemberBean  {
	
	
	@NotBlank(message = "手机号不能为空")
	@ApiModelProperty(value="手机号码", required=true)
	private String phone;
	
	@NotBlank(message = "姓名不能为空")
	@ApiModelProperty(value="姓名", required=true)
	private String memberTrueName;
	
	@NotBlank(message = "身份证号不能为空")
	@ApiModelProperty(value="身份证号", required=true)
	private String identityNo;
	
	@ApiModelProperty(value="所在省", required=true)
	@Min(0)
	private int provinceCode;
	
	@ApiModelProperty(value="所在城市", required=true)
	@Min(0)
	private int cityCode;
	
	@NotBlank(message = "身份证电子档不能为空")
	@ApiModelProperty(value="身份证电子档", required=true)
	private String identityImage;
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMemberTrueName() {
		return memberTrueName;
	}

	public void setMemberTrueName(String memberTrueName) {
		this.memberTrueName = memberTrueName;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getIdentityImage() {
		return identityImage;
	}

	public void setIdentityImage(String identityImage) {
		this.identityImage = identityImage;
	}

	public int getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	


}
