package cn.stylefeng.guns.modular.count.service;

import cn.stylefeng.guns.modular.system.model.SuperOrder;
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
public interface ISuperOrderService extends IService<SuperOrder> {

    List<Map<String, Object>> selectLists();
}
