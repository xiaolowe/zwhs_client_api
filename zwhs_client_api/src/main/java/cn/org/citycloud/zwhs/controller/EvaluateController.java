package cn.org.citycloud.zwhs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.Evaluate;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.EvaluateGood;
import cn.org.citycloud.zwhs.entity.OrderGood;
import cn.org.citycloud.zwhs.entity.ServiceInfo;
import cn.org.citycloud.zwhs.entity.StoreOrder;
import cn.org.citycloud.zwhs.entity.StoreServiceOrder;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.EvaluateGoodDao;
import cn.org.citycloud.zwhs.repository.OrderGoodDao;
import cn.org.citycloud.zwhs.repository.ServiceInfoDao;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;
import cn.org.citycloud.zwhs.repository.StoreOrderDao;
import cn.org.citycloud.zwhs.repository.StoreServiceOrderDao;
import cn.org.citycloud.zwhs.service.OrderService;

/**
 * 商品评价API
 * 
 * @author lanbo
 *
 */
@RestController
public class EvaluateController extends BaseController
{
    
    @Autowired
    private EvaluateGoodDao evaluateDao;
    
    @Autowired
    private StoreGoodsDao goodsDao;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderGoodDao orderGoodDao;
    
    @Autowired
    private StoreOrderDao orderDao;
    
    @Autowired
    private StoreServiceOrderDao serviceOrderDao;
    
    @Autowired
    private ServiceInfoDao serviceDao;
    
    /**
     * 商品评价列表
     */
    @RequestMapping(value = "/evaluate/{id}", method = RequestMethod.GET)
    public List<EvaluateGood> getGoodsEvaluate(@PathVariable int id)
    {
        
        List<EvaluateGood> evaluateList = evaluateDao.findGoodsEvaluate(id, Constants.ORDER_TYPE_GOODS);
        
        return evaluateList;
    }
    
    /**
     * 商品评价列表
     */
    @RequestMapping(value = "/serviceEvaluate/{id}", method = RequestMethod.GET)
    public List<EvaluateGood> getServiceEvaluate(@PathVariable int id)
    {
        
        List<EvaluateGood> evaluateList = evaluateDao.findGoodsEvaluate(id, Constants.ORDER_TYPE_SERVICE);
        
        return evaluateList;
    }
    
    /**
     * 提交商品评价
     * 
     * @throws BusinessErrorException
     */
    @RequestMapping(value = "/evaluate/submit/{orderId}", method = RequestMethod.POST)
    public void submitGoodsEvaluate(@PathVariable int orderId, @Valid @RequestBody List<Evaluate> evaluateLst)
        throws BusinessErrorException
    {
        
        // 判断订单是否已经评价过了
        StoreOrder order = orderService.findStoreOrderById(orderId);
        
        if (order == null || Constants.GEVAL_TYPE_BUYERS == order.getGevalType())
        {
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此订单不存在或者已经评估过了");
        }
        
        if (Constants.ORDER_STATUS_RECEIVED != order.getOrderStatus())
        {
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此订单还不能评价");
        }
        
        // 提交商品评价
        Date now = new Date();
        List<EvaluateGood> evaluateList = new ArrayList<EvaluateGood>();
        for (Evaluate evaluate : evaluateLst)
        {
            EvaluateGood entity = new EvaluateGood();
            int orderGoodsId = evaluate.getOrderGoodsId();
            OrderGood orderGood = orderGoodDao.findOne(orderGoodsId);
            
            BeanUtils.copyProperties(orderGood, entity);
            
            // 评分
            entity.setGevalScores(evaluate.getGevalScores());
            // 评价内容
            entity.setGevalContent(evaluate.getGevalContent());
            
            // 是否匿名
            entity.setGevalIsanonymous(0);
            entity.setGevalAddtime(now);
            
            entity.setMemberTruename(order.getMemberTruename());
            entity.setCompanyName(order.getCompanyName());
            
            // 是否显示
            entity.setGevalState(0);
            
            entity.setOrderType(Constants.ORDER_TYPE_GOODS);
            
            evaluateList.add(entity);
        }
        evaluateDao.save(evaluateList);
        
        // 买家评价 评价状态 0 未评价 1买家评价 2卖家评价 3双方互评
        order.setGevalType(1);
        
        order.setOrderStatus(40);
        order.setUpdDate(now);
        
        orderDao.save(order);
    }
    
    /**
     * 提交服务评价
     * 
     * @throws BusinessErrorException
     */
    @RequestMapping(value = "/evaluate/service/{orderId}", method = RequestMethod.POST)
    public void submitServiceEvaluate(@PathVariable int orderId, @Valid @RequestBody Evaluate submitEval)
        throws BusinessErrorException
    {
        
        // 判断订单是否已经评价过了
        StoreServiceOrder order =
            serviceOrderDao.findByOrderIdAndStoreIdAndMemberId(orderId, getStoreId(), getMemberId());
        
        if (order == null || Constants.GEVAL_TYPE_BUYERS == order.getGevalType())
        {
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此订单不存在或者已经评估过了");
        }
        
        if (Constants.SERVICE_ORDER_USED != order.getOrderStatus())
        {
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此订单还不能评价");
        }
        
        // 提交商品评价
        Date now = new Date();
        EvaluateGood evaluate = new EvaluateGood();
        evaluate.setOrderId(orderId);
        evaluate.setOrderGoodsId(order.getServiceId());
        evaluate.setGoodsId(order.getServiceId());
        
        ServiceInfo service = serviceDao.findOne(order.getServiceId());
        // 服务内容
        evaluate.setGoodsName(service.getServiceName());
        // 服务价格
        evaluate.setGoodsPrice(service.getServicePrice());
        
        // 评分
        evaluate.setGevalScores(submitEval.getGevalScores());
        // 评价内容
        evaluate.setGevalContent(submitEval.getGevalContent());
        
        evaluate.setMemberId(getMemberId());
        
        // 是否匿名
        evaluate.setGevalIsanonymous(0);
        evaluate.setGevalAddtime(now);
        
        evaluate.setMemberTruename(order.getMemberTruename());
        evaluate.setCompanyName(order.getCompanyName());
        
        // 是否显示
        evaluate.setGevalState(0);
        
        evaluate.setOrderType(Constants.ORDER_TYPE_SERVICE);
        
        evaluateDao.save(evaluate);
        
        // 买家评价 评价状态 0 未评价 1买家评价 2卖家评价 3双方互评
        order.setGevalType(1);
        order.setOrderStatus(Constants.SERVICE_ORDER_EVALUATED);
        order.setUpdDate(now);
        
        serviceOrderDao.save(order);
        
    }
    
}
