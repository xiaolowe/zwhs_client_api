package cn.org.citycloud.zwhs.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/20 14:42
 */
public class WxParam {
    @NotBlank(message = "url不能为空")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
