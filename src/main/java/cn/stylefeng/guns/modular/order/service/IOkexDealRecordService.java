package cn.stylefeng.guns.modular.order.service;

import cn.stylefeng.guns.modular.system.model.OkexDealRecord;
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
public interface IOkexDealRecordService extends IService<OkexDealRecord> {

    List<Map<String, Object>> selectLists(String coin);
}
