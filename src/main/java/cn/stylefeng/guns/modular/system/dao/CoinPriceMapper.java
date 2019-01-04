package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.CoinPrice;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-04
 */
public interface CoinPriceMapper extends BaseMapper<CoinPrice> {

    List<Map<String, Object>> selectLists(@Param("c1") String c1, @Param("c2") String c2, @Param("eid") String eid);
}
