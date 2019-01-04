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
 * @since 2019-01-02
 */
@TableName("coin_info")
public class Info extends Model<Info> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("coin_id")
    private Integer coinId;
    /**
     * 简介
     */
    private String info;
    /**
     * 编辑头像url
     */
    @TableField("edit_img_url")
    private String editImgUrl;
    /**
     * 板块
     */
    private String plate;
    /**
     * 编辑人
     */
    @TableField("edit_name")
    private String editName;
    /**
     * 编辑评语
     */
    @TableField("edit_info")
    private String editInfo;
    /**
     * 团队介绍
     */
    @TableField("team_info")
    private String teamInfo;
    /**
     * 源码地址
     */
    private String github;
    /**
     * reddit
     */
    private String reddit;
    /**
     * twitter
     */
    private String twitter;
    /**
     * facebook
     */
    private String facebook;
    /**
     * 官网
     */
    private String website;
    /**
     * 白皮书
     */
    @TableField("white_paper")
    private String whitePaper;
    /**
     * 区块站
     */
    private String explorer;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoinId() {
        return coinId;
    }

    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEditImgUrl() {
        return editImgUrl;
    }

    public void setEditImgUrl(String editImgUrl) {
        this.editImgUrl = editImgUrl;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getEditName() {
        return editName;
    }

    public void setEditName(String editName) {
        this.editName = editName;
    }

    public String getEditInfo() {
        return editInfo;
    }

    public void setEditInfo(String editInfo) {
        this.editInfo = editInfo;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getReddit() {
        return reddit;
    }

    public void setReddit(String reddit) {
        this.reddit = reddit;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWhitePaper() {
        return whitePaper;
    }

    public void setWhitePaper(String whitePaper) {
        this.whitePaper = whitePaper;
    }

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
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
        return "Info{" +
        ", id=" + id +
        ", coinId=" + coinId +
        ", info=" + info +
        ", editImgUrl=" + editImgUrl +
        ", plate=" + plate +
        ", editName=" + editName +
        ", editInfo=" + editInfo +
        ", teamInfo=" + teamInfo +
        ", github=" + github +
        ", reddit=" + reddit +
        ", twitter=" + twitter +
        ", facebook=" + facebook +
        ", website=" + website +
        ", whitePaper=" + whitePaper +
        ", explorer=" + explorer +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
