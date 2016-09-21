package cn.org.citycloud.zwhs.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.RetailMember;
import cn.org.citycloud.zwhs.entity.Store;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.RetailMemberDao;
import cn.org.citycloud.zwhs.repository.StoreDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="绑定母婴店", value = "/bindStore",  description = "绑定母婴店", consumes="application/json")
public class BindStoreController extends BaseController{
	
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private RetailMemberDao retailMemberDao;

	/**
	 * 绑定母婴店
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bindStore", method = RequestMethod.GET)
	@ApiOperation(value = "绑定母婴店", notes = "绑定母婴店信息")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public Object getInfo(@ApiParam(value = "母婴店数字码") @RequestParam(value = "retailCode")  String retailCode) throws Exception {
		
		int memberId = getMemberId();
		
		if(memberId == 0){
			throw new BusinessErrorException(ErrorCodes.TOKEN_ERROR, "请登录!");
		}
		if(retailCode != null){
			retailCode = retailCode.trim();
		}
		
		Store store = storeDao.findByretailCode(retailCode);
		
		if(store == null) {
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "该数字码不存在!");
		}
		if(store.getStoreType() == 1){ 	// 0  普通母婴店   1  自营母婴店
			throw new BusinessErrorException(ErrorCodes.SYSTEM_ERROR, "该母婴店不允许绑定!");
		}
		
		Date now = new Date();
		RetailMember retailMember = new RetailMember();
		retailMember.setMemberId(memberId);
		retailMember.setStoreId(store.getStoreId());
		retailMember.setMemberTime(now);
		retailMember.setInsDate(now);
		retailMember.setUpdDate(now);
		retailMemberDao.save(retailMember);
		
		return store;
	}
}
