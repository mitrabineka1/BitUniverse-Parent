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
 * @author zhh
 * @since 2019-01-03
 */
@TableName("cap_distribution")
public class CapDistribution extends Model<CapDistribution> {

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
     * 参数 大单 中单 小单 流入流出/数量
     */
    private String param;
    /**
     * 资金流向 0流入 1流出
     */
    private Integer type;
    /**
     * 金额
     */
    private String amount;


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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CapDistribution{" +
        ", id=" + id +
        ", coin=" + coin +
        ", exchangeId=" + exchangeId +
        ", param=" + param +
        ", type=" + type +
        ", amount=" + amount +
        "}";
    }
}
