package cn.org.citycloud.zwhs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.RegionInfo;
import cn.org.citycloud.zwhs.service.RegionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 区域接口
 * @author Allen
 */

@RestController
@Api(tags="省市区 区域接口", value = "/regioninfo",  description = "省市区 区域接口", consumes="application/json")
public class RegionInfoController extends BaseController{

	@Autowired
	private RegionInfoService regionInfoService;


	/**
	 * 获取所有省
	 * @return
	 */
	@RequestMapping(value = "/regioninfo/getProvince", method = RequestMethod.GET)
	@ApiOperation(value = "获取所有省", notes = "获取所有省列表", response = RegionInfo.class, responseContainer = "List")
	public Object getProvince() throws Exception, RuntimeException {
		
		List<RegionInfo> list = regionInfoService.getRegionProvince();

		return list;
	}
	
	/**
	 * 获取所有市
	 * @return
	 */
	@RequestMapping(value = "/regioninfo/getCity", method = RequestMethod.GET)
	@ApiOperation(value = "获取所有市", notes = "获取所有市列表", response = RegionInfo.class, responseContainer = "List")
	public Object getCity(@RequestParam("region_code") String regionCode ) throws Exception, RuntimeException {
		
		String code = regionCode.substring(0, 2);
		
		List<RegionInfo> list = regionInfoService.getRegionCity(Integer.valueOf(code));

		return list;
	}
	
	/**
	 * 获取所有区县
	 * @return
	 */
	@RequestMapping(value = "/regioninfo/getArea", method = RequestMethod.GET)
	@ApiOperation(value = "获取所有区", notes = "获取所有区列表", response = RegionInfo.class, responseContainer = "List")
	public Object getArea(@RequestParam("region_code") String regionCode ) throws Exception, RuntimeException {
		
		String code = regionCode.substring(0, 4);
		
		List<RegionInfo> list = regionInfoService.getRegionArea(Integer.valueOf(code));

		return list;
	}
	

	

}
