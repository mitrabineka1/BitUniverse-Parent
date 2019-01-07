package cn.stylefeng.guns.modular.exchange.service;

import cn.stylefeng.guns.modular.system.model.Exchange;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-07
 */
public interface IExchangeService extends IService<Exchange> {

    List<Map<String, Object>> selectLists();
}
