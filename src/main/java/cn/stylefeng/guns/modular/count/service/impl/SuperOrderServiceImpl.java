package cn.stylefeng.guns.modular.count.service.impl;

import cn.stylefeng.guns.modular.system.model.SuperOrder;
import cn.stylefeng.guns.modular.system.dao.SuperOrderMapper;
import cn.stylefeng.guns.modular.count.service.ISuperOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-07
 */
@Service
public class SuperOrderServiceImpl extends ServiceImpl<SuperOrderMapper, SuperOrder> implements ISuperOrderService {

    @Autowired
    private SuperOrderMapper superOrderMapper;
    @Override
    public List<Map<String, Object>> selectLists() {
        return superOrderMapper.selectLists();
    }
}
