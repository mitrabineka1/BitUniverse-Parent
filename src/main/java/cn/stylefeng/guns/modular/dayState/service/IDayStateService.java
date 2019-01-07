package cn.stylefeng.guns.modular.dayState.service;

import cn.stylefeng.guns.modular.system.model.DayState;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoahe
 * @since 2019-01-07
 */
public interface IDayStateService extends IService<DayState> {

    List<Map<String, Object>> selectLists();
}
