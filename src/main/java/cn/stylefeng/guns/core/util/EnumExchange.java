package cn.stylefeng.guns.core.util;


/**
 * 交易所枚举类
 */
public enum EnumExchange {
    AVERAGE(0, "AVERAGE"),
    OKEX(1, "OKEX"),
    HUOBI(2, "HUOBI"),
    BINANCE(3, "BINANCE");
    private final int exchangId;
    private final String desc;
    EnumExchange(int exchangId, String desc){
        this.desc = desc;
        this.exchangId = exchangId;
    }

    public int getExchangId() {
        return exchangId;
    }

    public String getDesc() {
        return desc;
    }

    public static String getName(Integer id){
        for (EnumExchange s : EnumExchange.values()){
            if(s.exchangId == id){
                return s.getDesc();
            }
        }
        return null;
    }

}
