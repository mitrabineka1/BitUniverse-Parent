package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-04
 */
@TableName("coin_data")
public class CoinData extends Model<CoinData> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 币种名称
     */
    private String coin;
    /**
     * 交易所id
     */
    @TableField("exchange_id")
    private Integer exchangeId;
    /**
     * 当前价格（rmb）
     */
    private String price;
    /**
     * 当前价格（usdt）
     */
    @TableField("price_usdt")
    private String priceUsdt;
    /**
     * 24小时价格变化
     */
    @TableField("price_change")
    private String priceChange;
    /**
     * 24小时价格变化百分比
     */
    @TableField("price_change_percent")
    private String priceChangePercent;
    /**
     * 24小时最高价
     */
    @TableField("day_high")
    private String dayHigh;
    /**
     * 24小时最低价
     */
    @TableField("day_low")
    private String dayLow;
    /**
     * 24小时交易量（usdt）
     */
    @TableField("day_volume")
    private String dayVolume;
    /**
     * 市值
     */
    @TableField("market_cap")
    private String marketCap;
    /**
     * 流通量
     */
    private String circulation;
    /**
     * 排名
     */
    private String rank;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceUsdt() {
        return priceUsdt;
    }

    public void setPriceUsdt(String priceUsdt) {
        this.priceUsdt = priceUsdt;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public String getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public String getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(String dayHigh) {
        this.dayHigh = dayHigh;
    }

    public String getDayLow() {
        return dayLow;
    }

    public void setDayLow(String dayLow) {
        this.dayLow = dayLow;
    }

    public String getDayVolume() {
        return dayVolume;
    }

    public void setDayVolume(String dayVolume) {
        this.dayVolume = dayVolume;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getCirculation() {
        return circulation;
    }

    public void setCirculation(String circulation) {
        this.circulation = circulation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CoinData{" +
        ", id=" + id +
        ", coin=" + coin +
        ", exchangeId=" + exchangeId +
        ", price=" + price +
        ", priceUsdt=" + priceUsdt +
        ", priceChange=" + priceChange +
        ", priceChangePercent=" + priceChangePercent +
        ", dayHigh=" + dayHigh +
        ", dayLow=" + dayLow +
        ", dayVolume=" + dayVolume +
        ", marketCap=" + marketCap +
        ", circulation=" + circulation +
        ", rank=" + rank +
        "}";
    }
}
