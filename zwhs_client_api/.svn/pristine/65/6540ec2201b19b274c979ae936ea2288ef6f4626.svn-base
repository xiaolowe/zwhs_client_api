package cn.org.citycloud.zwhs.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import cn.org.citycloud.zwhs.constants.Constants;

public class WeixinUtil {
	
	/**
	 * 加密支付签名
	 * 
	 * @return
	 */
	public static String paySign(String time, String noncestr,
			String prepayPackage) {
		
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		
		finalpackage.put("appId", Constants.API_ID);  
		finalpackage.put("timeStamp", time);  
		finalpackage.put("nonceStr", noncestr);  
		finalpackage.put("package", prepayPackage);  
		finalpackage.put("signType", "MD5");

		return createSign(finalpackage);
	}
	
	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	private static String createSign(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + Constants.KEY);
		System.out.println("md5 sb:" + sb+ Constants.KEY);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8")
				.toUpperCase();
		System.out.println("packge签名:" + sign);
		return sign;

	}

}
