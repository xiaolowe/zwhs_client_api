package cn.org.citycloud.zwhs.controller;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.RetailShopModifyBean;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.RetailShop;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.RetailShopDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="分销店铺", value = "/retailShop",  description = "分销店铺", consumes="application/json")
public class RetailShopController extends BaseController{
	
	@Autowired
	private RetailShopDao retailShopDao;
	
	
	
	/**
	 * 查看分销店铺信息 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/retailShop", method = RequestMethod.GET)
	@ApiOperation(value = "分销店铺信息", notes = "分销店铺信息")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public Object getInfo() throws Exception {
		
		int memberId = getMemberId();
		
		if(memberId == 0){
			
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "请登录!");
		}
		
		RetailShop retailShop = retailShopDao.findByMemberId(memberId);
		
		return retailShop;
	}
	

	
	/**
	 * 修改店铺信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/retailShop", method = RequestMethod.PUT)
	@ApiOperation(value = " 修改店铺信息", notes = " 修改店铺信息")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public Object bindCard( @ApiParam(value = " 修改店铺信息", required = true) @Valid @RequestBody RetailShopModifyBean bean) throws BusinessErrorException {
		
		int memberId = getMemberId();
		
		if(memberId == 0){
			
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "请登录!");
		}
		
		RetailShop retailShop = retailShopDao.findByMemberId(memberId);
		Date now = new Date();
		
		if(retailShop == null){
			retailShop = new RetailShop();
			retailShop.setInsDate(now);
		}
		retailShop.setMemberId(memberId);
		retailShop.setRetailShop(bean.getRetailShop());
		retailShop.setLogoImage(bean.getLogoImage());
		retailShop.setBannerImage(bean.getBannerImage());
		retailShop.setUpdDate(now);
		retailShop.setStatus(1); 	// 1 正常   0  禁用
		
		return retailShopDao.save(retailShop);
		
		
	}
	
	
}
