package cn.stylefeng.guns.modular.coin_info.service;

import cn.stylefeng.guns.modular.system.model.Manager;
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
public interface IManagerService extends IService<Manager> {


    List<Map<String, Object>> selectByAll(Integer managerId);
}
