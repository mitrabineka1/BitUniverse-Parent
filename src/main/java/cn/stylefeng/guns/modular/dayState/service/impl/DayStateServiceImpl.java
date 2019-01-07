package cn.stylefeng.guns.modular.dayState.service.impl;

import cn.stylefeng.guns.modular.system.model.DayState;
import cn.stylefeng.guns.modular.system.dao.DayStateMapper;
import cn.stylefeng.guns.modular.dayState.service.IDayStateService;
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
 * @author zhoahe
 * @since 2019-01-07
 */
@Service
public class DayStateServiceImpl extends ServiceImpl<DayStateMapper, DayState> implements IDayStateService {

    @Autowired
    private DayStateMapper dayStateMapper;
    @Override
    public List<Map<String, Object>> selectLists() {
        return dayStateMapper.selectLists();
    }
}
