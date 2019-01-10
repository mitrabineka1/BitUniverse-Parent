package cn.stylefeng.guns.modular.exchange.service.impl;

import cn.stylefeng.guns.modular.system.model.UsingDocuments;
import cn.stylefeng.guns.modular.system.dao.UsingDocumentsMapper;
import cn.stylefeng.guns.modular.exchange.service.IUsingDocumentsService;
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
 * @since 2019-01-10
 */
@Service
public class UsingDocumentsServiceImpl extends ServiceImpl<UsingDocumentsMapper, UsingDocuments> implements IUsingDocumentsService {

    @Autowired
    private UsingDocumentsMapper usingDocumentsMapper;
    @Override
    public List<Map<String, Object>> selectLists() {
        return usingDocumentsMapper.selectLists();
    }
}
