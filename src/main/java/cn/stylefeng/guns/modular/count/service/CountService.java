package cn.stylefeng.guns.modular.count.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CountService {
    List<List<Object>> getKline(Integer coinId, Integer exchangeId, Integer gear);

    Map<String, Map<String, BigDecimal>> fundDis(Integer coinId);
}
