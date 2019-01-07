package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.DayState;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoahe
 * @since 2019-01-07
 */
public interface DayStateMapper extends BaseMapper<DayState> {

    List<Map<String, Object>> selectLists();
}
