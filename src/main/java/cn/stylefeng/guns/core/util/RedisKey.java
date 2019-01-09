package cn.stylefeng.guns.core.util;

/**
 * @描述 Redis-Key值声明类<br>
 * @author administrator
 * @版本 v1.0.0
 * @日期 2017-10-13
 */
public class RedisKey {

	public static final String TEST="TEST";
	
	public static final String TOKEN = "bituniverse:token:%s";
	
	public static final String SYSTEM_PARAM = "bituniverse:systemParam:%s";
	
	public static final String TABLE_NAME = "bituniverse:tableName:%s";
	
	public static final String ORDER_PASSWORD_ERROR_TIMES = "bituniverse:orderPassword:%s:errorTimes"; /*交易密码错误次数限制*/
	public static final String ORDER_PASSWORD_ERROR_TIMESTAMP = "bituniverse:orderPassword:%s:errorTimestamp"; /*错误次数累计时间范围*/
	public static final String ORDER_PASSWORD_LOCK_TIMESTAMP = "bituniverse:orderPassword:%s:lockTimestamp"; /*锁定时长*/
	public static final String SMS_ERROR_TIMES = "bituniverse:smsRecord:%s"; /*验证码错误次数*/
	

	//k线数据 交易所ID 时间间隔类型（1:1min,2:5min,3:30min,4:1hour,5:1day）:计价币种:交易币种
	public static final String KLINE = "bituniverse:kline:%s:%s:%s:%s";
	//最新价格 USDT单价 USDT-BTC USDT-CNY
	public static final String USDT_PRICE = "bituniverse:price:usdt:%s";
	//超级大单 交易所：交易币 (c2)
	public static final String SUPER_ORDER = "bituniverse:superOrder:%s:%s";
	//24小时流入 交易所：交易币 (c2)
	public static final String DAY_IN_ORDER = "bituniverse:dayState:in:%s:%s";
	//24小时流出 交易所：交易币 (c2)
	public static final String DAY_OUT_ORDER = "bituniverse:dayState:out:%s:%s";
	//币种详情 交易所：交易币 (c2)
	public static final String COIN_DETAILS = "bituniverse:details:%s:%s";
	//资金流向k-line
	public static final String KLINE_VOLUME = "bituniverse:kline:volume:%s:%s";

	public static final String ADDRESS_INFO = "bituniverse:coinManager:%s";

	public static final String USER_TOKEN = "bituniverse:user:%s";
	//币对最新价格  交易所：交易币: 计价币  c2:c1
	public static final String COIN_PRICE = "bituniverse:price:%s:%s:%s";
	//详情页 买卖盘 交易所：交易币 深度
	public static final String COIN_DETAILS_ORDER = "bituniverse:order:%s:%s:%s";
    //详情页 买卖盘 交易所：交易币 深度图
	public static final String COIN_DETAILS_DEPTH = "bituniverse:depth:%s:%s";
	//获取最新价格  c2:c1
	public static final String NEW_PRICE_PERCENT = "bituniverse:pricePercent:%s:%s";
	//24小时净流入 交易所：交易币 (c2)
	public static final String DAY_ACTUAL_ORDER = "bituniverse:dayState:actual:%s:%s";
	//24小时净流入百分比 交易所：交易币 (c2)
	public static final String DAY_ACTUALPARENT_ORDER = "bituniverse:dayState:parent:%s:%s";
	//资金分布饼图 交易所：交易币 (c2)
	public static final String COIN_FUND_DISTRIBUTION = "bituniverse:fundDistribution:%s:%s";
	//资金分布饼图 大小单 数量 额度 交易所：交易币 (c2) 数量/额度 流入/流出
	public static final String COIN_FUND_DISTRIBUTION_DETAILS = "bituniverse:fundDistribution:details:%s:%s:%s:%s";
	//资金分布饼图 流入/流出总量 交易所：交易币 (c2) 流入/流出
	public static final String COIN_FUND_DISTRIBUTION_TOTAL = "bituniverse:fundDistribution:details:total:%s:%s:%s";

}
