package cn.stylefeng.guns.modular.count.service.impl;

import cn.stylefeng.guns.core.util.EnumCoin;
import cn.stylefeng.guns.core.util.EnumExchange;
import cn.stylefeng.guns.core.util.RedisKey;
import cn.stylefeng.guns.core.util.RedisUtil;
import cn.stylefeng.guns.modular.count.service.CountService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CountServiceImpl implements CountService {
    @Resource
    private RedisTemplate<String, String> redis;

    private static int USDT = 0;

    @Override
    public List<List<Object>> getKline(Integer coinId, Integer exchangeId, Integer gear) {
        String jedisKey = String.format(RedisKey.KLINE, exchangeId, gear, coinId, USDT);
        List<Map> list = RedisUtil.searchList(redis, jedisKey, 0, 200, Map.class);
        if(list != null && list.size() > 0) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            BigDecimal open;
            BigDecimal high;
            BigDecimal low;
            BigDecimal close;
            String time;
            List<List<Object>> resultList = new ArrayList<>();
            for (Map map : list) {
                List<Object> objects = new ArrayList<>();
                time = map.get("time").toString();
                try {
                    Date date = df2.parse(time);
                    time = df.format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                open = new BigDecimal(map.get("open").toString());
                high = new BigDecimal(map.get("high").toString());
                low = new BigDecimal(map.get("low").toString());
                close = new BigDecimal(map.get("close").toString());
                objects.add(time);
                objects.add(open);
                objects.add(close);
                objects.add(low);
                objects.add(high);
                resultList.add(objects);
            }
            return resultList;
        }
        return null;
    }

    @Override
    public Map<String, Map<String, BigDecimal>> fundDis(Integer coinId) {
        Map<String, Map<String, BigDecimal>> resultMap = new HashMap<>();
        List<Integer> typeList = new ArrayList<>();
        typeList.add(0);
        typeList.add(1);
        for(Integer type : typeList){
            resultMap.put(type == 0 ? "buy" : "sale", getDis(coinId, type));
        }
        return resultMap;
    }

    private Map<String, BigDecimal> getDis(Integer coin, Integer type){
        List<String> actionList = new ArrayList<>();
        actionList.add("big");
        actionList.add("mid");
        actionList.add("small");
        Map<String, BigDecimal> m = new HashMap<>();
        List<Integer> exchangeList = new ArrayList<>();
        exchangeList.add(EnumExchange.OKEX.getExchangId());
        exchangeList.add(EnumExchange.HUOBI.getExchangId());
        exchangeList.add(EnumExchange.BINANCE.getExchangId());
        exchangeList.add(EnumExchange.BW.getExchangId());
//        exchangeList.add(EnumExchange.EXX.getExchangId());
        for(String action : actionList){
            for(Integer exchange : exchangeList) {
                String exchangeName = EnumExchange.getName(exchange);
                String key = String.format(RedisKey.COIN_FUND_DISTRIBUTION_DETAILS, exchange, EnumCoin.getName(coin), action, type);
                String amount = RedisUtil.searchString(redis, key);
                switch (action) {
                    case "big":
                        m.put(exchangeName + "大单", new BigDecimal(amount == null ? "0" : amount));
                        break;
                    case "mid":
                        m.put(exchangeName +"中单", new BigDecimal(amount == null ? "0" : amount));
                        break;
                    case "small":
                        m.put(exchangeName +"小单", new BigDecimal(amount == null ? "0" : amount));
                        break;
                }
            }

        }
        return m;
    }
}
