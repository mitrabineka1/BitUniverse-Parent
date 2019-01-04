package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
@TableName("coin_manager")
public class Manager extends Model<Manager> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 币种名称
     */
    private String name;
    /**
     * 币种代码
     */
    private String symbol;
    /**
     * 站点名称
     */
    @TableField("website_slug")
    private String websiteSlug;
    /**
     * 币种logo图片地址
     */
    @TableField("logo_url")
    private String logoUrl;
    /**
     * 获取交易信息
     */
    @TableField("url_transaction")
    private String urlTransaction;
    /**
     * 获取地址信息（余额）
     */
    @TableField("url_address_info")
    private String urlAddressInfo;
    /**
     * 流通量
     */
    @TableField("circulating_supply")
    private String circulatingSupply;
    /**
     * 市值
     */
    @TableField("market_cap")
    private String marketCap;
    /**
     * 24H成交额
     */
    @TableField("volume_24h")
    private String volume24h;
    /**
     * 发行量
     */
    @TableField("max_supply")
    private String maxSupply;
    /**
     * 全球市值占比
     */
    @TableField("markey_ratio")
    private String markeyRatio;
    /**
     * 换手率
     */
    @TableField("turnover_rate")
    private String turnoverRate;
    /**
     * 流通率
     */
    @TableField("circulation_rate")
    private String circulationRate;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWebsiteSlug() {
        return websiteSlug;
    }

    public void setWebsiteSlug(String websiteSlug) {
        this.websiteSlug = websiteSlug;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getUrlTransaction() {
        return urlTransaction;
    }

    public void setUrlTransaction(String urlTransaction) {
        this.urlTransaction = urlTransaction;
    }

    public String getUrlAddressInfo() {
        return urlAddressInfo;
    }

    public void setUrlAddressInfo(String urlAddressInfo) {
        this.urlAddressInfo = urlAddressInfo;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(String volume24h) {
        this.volume24h = volume24h;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public String getMarkeyRatio() {
        return markeyRatio;
    }

    public void setMarkeyRatio(String markeyRatio) {
        this.markeyRatio = markeyRatio;
    }

    public String getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(String turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public String getCirculationRate() {
        return circulationRate;
    }

    public void setCirculationRate(String circulationRate) {
        this.circulationRate = circulationRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Manager{" +
        ", id=" + id +
        ", name=" + name +
        ", symbol=" + symbol +
        ", websiteSlug=" + websiteSlug +
        ", logoUrl=" + logoUrl +
        ", urlTransaction=" + urlTransaction +
        ", urlAddressInfo=" + urlAddressInfo +
        ", circulatingSupply=" + circulatingSupply +
        ", marketCap=" + marketCap +
        ", volume24h=" + volume24h +
        ", maxSupply=" + maxSupply +
        ", markeyRatio=" + markeyRatio +
        ", turnoverRate=" + turnoverRate +
        ", circulationRate=" + circulationRate +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
