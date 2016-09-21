//package cn.org.citycloud.zwhs.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import cn.org.citycloud.zwhs.entity.GoodsClass;
//import cn.org.citycloud.zwhs.service.GoodService;
//
//@Controller
//public class GoodController {
//	
//	@Autowired
//	private GoodService goodService;
//	
//	/**
//	 * 列表
//	 * @return
//	 */
//	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
//	@ResponseBody()
//	public Object getGoods(@RequestParam(value = "page", defaultValue = "1") Integer page,
//	        @RequestParam(value = "size", defaultValue = "5") Integer size) {
//
//		Sort sort = new Sort(Direction.DESC, "id");
//	    Pageable pageable = new PageRequest(page, size, sort);
//		Iterable<GoodsClass> list = goodService.getGoods(pageable);
//		return list;
//	}
//}
