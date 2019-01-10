package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.UsingDocuments;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-10
 */
public interface UsingDocumentsMapper extends BaseMapper<UsingDocuments> {

    List<Map<String, Object>> selectLists();
}
