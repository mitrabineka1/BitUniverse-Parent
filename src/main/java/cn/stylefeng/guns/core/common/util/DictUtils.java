package cn.stylefeng.guns.core.common.util;

import cn.stylefeng.guns.modular.system.dao.DictMapper;
import cn.stylefeng.guns.modular.system.model.Dict;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.util.List;

public class DictUtils {
    private static DictMapper dictMapper = SpringContextHolder.getBean(DictMapper.class);

    public static String getDict(String str){
        if(str != null && str != "") {
            EntityWrapper<Dict> dictEntityWrapper = new EntityWrapper<>();
            Wrapper<Dict> wrapper = dictEntityWrapper.like("name", str);
            List<Dict> list = dictMapper.selectList(wrapper);
            if(list != null || list.size() > 0) {
                Dict dict = list.get(0);
                str = dict.getNum().toString();
            }
        }
        return str;
    }
}
