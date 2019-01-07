package cn.stylefeng.guns.modular.exchange.service.impl;

import cn.stylefeng.guns.modular.system.model.Exchange;
import cn.stylefeng.guns.modular.system.dao.ExchangeMapper;
import cn.stylefeng.guns.modular.exchange.service.IExchangeService;
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
public class ExchangeServiceImpl extends ServiceImpl<ExchangeMapper, Exchange> implements IExchangeService {
    @Autowired
    private ExchangeMapper exchangeMapper;

    @Override
    public List<Map<String, Object>> selectLists() {
        return exchangeMapper.selectLists();
    }
}
