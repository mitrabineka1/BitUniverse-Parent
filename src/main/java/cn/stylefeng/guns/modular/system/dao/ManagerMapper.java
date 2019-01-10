package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Manager;
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
public interface ManagerMapper extends BaseMapper<Manager> {


    List<Map<String, Object>> selectByAll(@Param("managerId") Integer managerId);
}
