package cn.stylefeng.guns.core.common.constant.dictmap;

import cn.stylefeng.guns.core.common.constant.dictmap.base.AbstractDictMap;

public class InfoDict extends AbstractDictMap {
    @Override
    public void init() {
        put("coinId", "币种");
    }
    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("coinId", "getCoinName");
    }
}
