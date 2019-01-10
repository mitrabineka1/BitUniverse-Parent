package cn.stylefeng.guns.core.util;

public enum EnumCoin {
    USDT(0, "USDT"),
    CNY(1, "CNY"),
    BTC(2, "BTC"),
    ETH(3, "ETH");

    private final int coinId;
    private final String name;
    EnumCoin(int coinId, String name){
        this.coinId = coinId;
        this.name = name;
    }

    public int getCoinId() {
        return coinId;
    }

    public String getName() {
        return name;
    }

    public static String getName(Integer id){
        switch (id){
            case 0 : return "USDT";
            case 1 : return "CNY";
            case 2 : return "BTC";
            case 3 : return "ETH";
            default: return null;
        }
    }
}
