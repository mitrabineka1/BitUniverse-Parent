package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.OkexDealRecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

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
public interface OkexDealRecordMapper extends BaseMapper<OkexDealRecord> {

    List<Map<String, Object>> selectLists(@Param("coin") String coin, @Param("page") Page<OkexDealRecord> page);
}
