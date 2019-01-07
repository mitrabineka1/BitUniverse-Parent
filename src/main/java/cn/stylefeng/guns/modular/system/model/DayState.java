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
 * @author zhoahe
 * @since 2019-01-07
 */
@TableName("day_state")
public class DayState extends Model<DayState> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("exchange_id")
    private Integer exchangeId;
    private String coin;
    /**
     * 流入
     */
    @TableField("day_in")
    private String dayIn;
    /**
     * 流出
     */
    @TableField("day_out")
    private String dayOut;
    /**
     * 净流入
     */
    private String actual;
    /**
     * 净流入比
     */
    private String ratio;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    public String getDayOut() {
        return dayOut;
    }

    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DayState{" +
        ", id=" + id +
        ", exchangeId=" + exchangeId +
        ", coin=" + coin +
        ", dayIn=" + dayIn +
        ", dayOut=" + dayOut +
        ", actual=" + actual +
        ", ratio=" + ratio +
        "}";
    }
}
