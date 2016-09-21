package cn.org.citycloud.zwhs.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class AddrParams {

	@NotEmpty
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
