package cn.stylefeng.guns.modular.coin_info.service.impl;

import cn.stylefeng.guns.core.common.util.DictUtils;
import cn.stylefeng.guns.modular.system.model.CoinPrice;
import cn.stylefeng.guns.modular.system.dao.CoinPriceMapper;
import cn.stylefeng.guns.modular.coin_info.service.ICoinPriceService;
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
public class CoinPriceServiceImpl extends ServiceImpl<CoinPriceMapper, CoinPrice> implements ICoinPriceService {

    @Override
    public List<Map<String, Object>> selectLists(String c1, String c2, String eid) {
        c1 = DictUtils.getDict(c1);
        c2 = DictUtils.getDict(c2);
        eid = DictUtils.getDict(eid);
        return this.baseMapper.selectLists(c1, c2, eid);
    }
}
