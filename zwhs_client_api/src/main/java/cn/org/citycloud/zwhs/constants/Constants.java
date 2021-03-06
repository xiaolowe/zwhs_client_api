package cn.org.citycloud.zwhs.constants;

/**
 * 常量类
 * 
 * @author lanbo
 *
 */
public class Constants
{
    // 微信登录回调地址
    
    public static final String CALLBACK_URL = "http://o2o.syisy.com/zwhs_client_api/auth/callback";
    
    // 用户微信端外网地址
    public static final String WSC_URL = "http://o2o.syisy.com/#/store/";
    
    // 调用JavaScript API的网页url
    public static final String JS_PAY_URL = "http://o2o.syisy.com/preorder";
    
    public static final String JS_SERVICE_URL = "http://o2o.syisy.com/services/order";
    
    // 服务预约支付回调URL
    public static final String SERVICE_PAY_NOTIFY_URL = "http://o2o.syisy.com/zwhs_client_api/servicePayNotify";
    
    public static final long TOKEN_EXPIRES_IN = 7200;
    
    public static final String TOKEN_SECRET = "IFFa52XkBEQ9AoO8";
    
    // 中物华商微信APPID
    public static final String API_ID = "wx83173d07c8ceb15c";
    //中物华商
    public static final String API_SECRET = "44e8c20c128fdb2b115321e3d3c8148a";
    
    // 合肥圈
//    public static final String API_ID = "wxc796abe07a062d84";
//    public static final String API_SECRET = "bdda7f82373b58e05141f181b8bb1bf8";

    /** 获取access_token的url */
    public static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    /** 获取jsapi_ticket的url */
    public static final String URL_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";

    public static final String MCH_ID = "1283969101";
    
    public static final String KEY = "00452613778959026465898723358440";
    
    // 会员的状态 1为开启 0为关闭
    public static final int MEMBER_STATE_OPEN = 1;
    
    public static final int MEMBER_STATE_CLOSED = 0;
    
    // 母婴店状态：0关闭，1开启，2审核中
    public static final int STORE_STATE_CLOSED = 0;
    
    public static final int STORE_STATE_OPEN = 1;
    
    public static final int STORE_STATE_VERIFING = 2;
    
    // 订单状态：0(已取消)10(默认):未付款;20:已付款;30:已接单;40:已使用;50:已评价
    public static final int ORDER_STATUS_CANCELD = 0;
    
    public static final int ORDER_STATUS_DEFAULT = 10;
    
    public static final int ORDER_STATUS_PAYED = 20;
    
    public static final int ORDER_STATUS_RECEIVED = 30;
    
    public static final int ORDER_STATUS_EVALUATED = 50;
    
    public static final int ORDER_STATUS_YIFAHUO = 60;
    
    // 订单类型: 1 商品类订单; 2 服务类订单
    public static final int ORDER_TYPE_GOODS = 1;
    
    public static final int ORDER_TYPE_SERVICE = 2;
    
    // 支付方式代码: 1 银联;2 支付宝;3 微信
    public static final String PAY_CODE_BANK = "1";
    
    public static final String PAY_CODE_PAYBAO = "2";
    
    public static final String PAY_CODE_WEIXIN = "3";
    
    // 支付状态
    public static final int PAY_STATE_PAYED = 1;
    
    // 商品类型 1默认2团购商品3限时折扣商品4组合套装5赠品
    public static final int GOODS_TYPE_DEFAULT = 1;
    
    // 评价状态 0 未评价 1买家评价 2卖家评价 3双方互评
    public static final int GEVAL_TYPE_BUYERS = 1;
    
    // 商品状态 0下架，1正常，10违规（禁售）
    public static final int GOODS_STATE_OFFLINE = 0;
    
    public static final int GOODS_STATE_NORMAL = 1;
    
    public static final int GOODS_STATE_DISABLE = 0;
    
    // 服务类型 1 上门服务 ;2 到店服务
    public static final int SERVICE_TYPE_CALL = 1;
    
    public static final int SERVICE_TYPE_STORE = 2;
    
    // 优惠劵状态 10为正常，20为失效
    public static final int COUPON_STATUS_NORMAL = 10;
    
    public static final int COUPON_STATUS_INVALID = 20;
    
    // 优惠劵使用状态
    public static final int COUPON_UNUSED = 10;
    
    public static final int COUPON_USED = 20;
    
    // 服务状态 0下架，1正常，10违规（禁售）
    public static final int SERVICE_STATE_OFFLINE = 0;
    
    public static final int SERVICE_STATE_NORMAL = 1;
    
    public static final int SERVICE_STATE_DISABLE = 0;
    
    // 服务审核 1 审核通过，0未通过，2 驳回
    public static final int SERVICE_VERIFY_PASS = 1;
    
    public static final int SERVICE_VERIFY_NOTPASS = 0;
    
    public static final int SERVICE_VERIFY_REJECT = 2;
    
    // 服务订单状态：0(已取消)10(默认):未付款;20:已付款;30:已接单;40:已使用;50:已评价
    public static final int SERVICE_ORDER_CANCELD = 0;
    
    public static final int SERVICE_ORDER_DEFAULT = 10;
    
    public static final int SERVICE_ORDER_PAYED = 20;
    
    public static final int SERVICE_ORDER_ACCEPT = 30;
    
    public static final int SERVICE_ORDER_USED = 40;
    
    public static final int SERVICE_ORDER_EVALUATED = 50;
    
    // 账户类型(平台:1;母婴店:2;服务商:3; 分销商  4)
    public static final int ACC_TYPE_ZWHS = 1;
    
    public static final int ACC_TYPE_STORE = 2;
    
    public static final int ACC_TYPE_PROVIDER = 3;
    
    public static final int ACC_TYPE_RETAIL_MEMBER = 4;
    
    // 排序DESC ASC
    public static final String SORT_DESC = "DESC";
    
    public static final String SORT_ASC = "ASC";
    
    //分销商品状态（1 上架  2 下架）
    public static final int DIST_GOODS_ONLINE=1;
    
    public static final int DIST_GOODS_OFFLINE=2;
    
    // 分销订单 
    public static final int ORDER_RETAIL = 1;
    
}
