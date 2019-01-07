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
 * @since 2019-01-07
 */
@TableName("super_order")
public class SuperOrder extends Model<SuperOrder> {

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
     * 价格
     */
    private String price;
    /**
     * 数量
     */
    private String size;
    /**
     * bid买 ask卖
     */
    private String side;
    /**
     * 交易额
     */
    private String total;
    /**
     * 时间
     */
    private String time;


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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SuperOrder{" +
        ", id=" + id +
        ", coin=" + coin +
        ", exchangeId=" + exchangeId +
        ", price=" + price +
        ", size=" + size +
        ", side=" + side +
        ", total=" + total +
        ", time=" + time +
        "}";
    }
}
