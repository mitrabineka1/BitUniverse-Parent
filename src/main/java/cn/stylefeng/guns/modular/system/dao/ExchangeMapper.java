package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Exchange;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-07
 */
public interface ExchangeMapper extends BaseMapper<Exchange> {

    List<Map<String, Object>> selectLists();
}
