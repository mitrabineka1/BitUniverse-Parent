package cn.stylefeng.guns.modular.coin_info.service;

import cn.stylefeng.guns.modular.system.model.CoinPrice;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-04
 */
public interface ICoinPriceService extends IService<CoinPrice> {
    List<Map<String,Object>> selectLists(String c1, String c2, String eid);
}
