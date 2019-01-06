package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Info;
import cn.stylefeng.roses.core.datascope.DataScope;
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
public interface InfoMapper extends BaseMapper<Info> {
    List<Map<String, Object>> selectLists(@Param("coin") String coin);

    void deleteByCoinId(@Param("coinId")Integer coinId);
}
