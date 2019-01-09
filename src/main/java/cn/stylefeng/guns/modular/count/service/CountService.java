package cn.stylefeng.guns.modular.count.service;

import java.util.List;

public interface CountService {
    List<List<Object>> getKline(Integer coinId, Integer exchangeId, Integer gear);
}
