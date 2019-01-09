package cn.stylefeng.guns.modular.count.service.impl;

import cn.stylefeng.guns.core.util.RedisKey;
import cn.stylefeng.guns.core.util.RedisUtil;
import cn.stylefeng.guns.modular.count.service.CountService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            String open;
            String high;
            String low;
            String close;
            String time;
            List<List<Object>> resultList = new ArrayList<>();
            for (Map map : list) {
                List<Object> objects = new ArrayList<>();
                open = map.get("open").toString();
                high = map.get("high").toString();
                low = map.get("low").toString();
                close = map.get("close").toString();
                time = map.get("time").toString();
                objects.add(open);
                objects.add(high);
                objects.add(low);
                objects.add(close);
                objects.add(time);
                resultList.add(objects);
            }
            return resultList;
        }
        return null;
    }
}
