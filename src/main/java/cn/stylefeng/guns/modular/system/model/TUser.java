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
 * 用户表
 * </p>
 *
 * @author zhaohe
 * @since 2019-01-07
 */
@TableName("t_user")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户账号
     */
    private String phone;
    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 密钥
     */
    @TableField("secret_key")
    private String secretKey;
    /**
     * token
     */
    private String token;
    /**
     * token生成时间
     */
    @TableField("token_create_time")
    private Date tokenCreateTime;
    /**
     * 最后登录时间
     */
    @TableField("login_time")
    private Date loginTime;
    /**
     * 设备信息
     */
    @TableField("device_info")
    private String deviceInfo;
    /**
     * 设备类型 1安卓 2ios
     */
    @TableField("device_type")
    private Integer deviceType;
    /**
     * 操作系统
     */
    @TableField("device_os")
    private String deviceOs;
    /**
     * 状态 0:有效 1:冻结 2:注销
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(Date tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TUser{" +
        ", id=" + id +
        ", phone=" + phone +
        ", userPassword=" + userPassword +
        ", secretKey=" + secretKey +
        ", token=" + token +
        ", tokenCreateTime=" + tokenCreateTime +
        ", loginTime=" + loginTime +
        ", deviceInfo=" + deviceInfo +
        ", deviceType=" + deviceType +
        ", deviceOs=" + deviceOs +
        ", state=" + state +
        "}";
    }
}
