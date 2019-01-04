package cn.stylefeng.guns.modular.coin_info.service.impl;

import cn.stylefeng.guns.modular.system.dao.DictMapper;
import cn.stylefeng.guns.modular.system.model.Dict;
import cn.stylefeng.guns.modular.system.model.Info;
import cn.stylefeng.guns.modular.system.dao.InfoMapper;
import cn.stylefeng.guns.modular.coin_info.service.IInfoService;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-04
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    private DictMapper dictMapper = SpringContextHolder.getBean(DictMapper.class);

    @Override
    public List<Map<String, Object>> selectLists(String coin) {
        if(coin != null && coin != "") {
            EntityWrapper<Dict> dictEntityWrapper = new EntityWrapper<>();
            Wrapper<Dict> wrapper = dictEntityWrapper.like("name", coin);
            List<Dict> list = dictMapper.selectList(wrapper);
            if(list != null || list.size() > 0) {
                Dict dict = list.get(0);
                coin = dict.getNum().toString();
            }
        }
        return this.baseMapper.selectLists(coin);
    }
}
