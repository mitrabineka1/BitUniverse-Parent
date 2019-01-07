package cn.stylefeng.guns.modular.order.service.impl;

import cn.stylefeng.guns.core.common.util.DictUtils;
import cn.stylefeng.guns.modular.system.model.OkexDealRecord;
import cn.stylefeng.guns.modular.system.dao.OkexDealRecordMapper;
import cn.stylefeng.guns.modular.order.service.IOkexDealRecordService;
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
public class OkexDealRecordServiceImpl extends ServiceImpl<OkexDealRecordMapper, OkexDealRecord> implements IOkexDealRecordService {

    @Autowired
    private OkexDealRecordMapper okexDealRecordMapper;
    @Override
    public List<Map<String, Object>> selectLists(String coin) {
        String coinId = DictUtils.getDict(coin);
        return okexDealRecordMapper.selectLists(coinId);
    }
}
