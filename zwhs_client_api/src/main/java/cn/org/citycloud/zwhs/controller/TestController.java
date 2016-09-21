package cn.org.citycloud.zwhs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试之用
 * 
 * @author lanbo
 *
 */
@Controller
public class TestController
{
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test()
    {
        
        String errMsg = "微信登录失败:111111111";
        Map<String, Object> map = new HashMap<String, Object>();
        // 错误页面
        map.put("errMsg", errMsg);
        
        return new ModelAndView("error", map);
        
    }
}
