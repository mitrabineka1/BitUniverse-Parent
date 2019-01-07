package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Sysparams;
import cn.stylefeng.guns.modular.system.service.ISysparamsService;

/**
 * 系统参数控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 11:16:53
 */
@Controller
@RequestMapping("/sysparams")
public class SysparamsController extends BaseController {

    private String PREFIX = "/system/sysparams/";

    @Autowired
    private ISysparamsService sysparamsService;

    /**
     * 跳转到系统参数首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "sysparams.html";
    }

    /**
     * 跳转到添加系统参数
     */
    @RequestMapping("/sysparams_add")
    public String sysparamsAdd() {
        return PREFIX + "sysparams_add.html";
    }
    /**
     * 跳转到添加系统参数
     */
    @RequestMapping("/sysparams_addOnOff")
    public String sysparams_addOnOff() {
        return PREFIX + "sysparams_addOnOff.html";
    }

    /**
     * 跳转到修改系统参数
     */
    @RequestMapping("/sysparams_update/{sysparamsId}")
    public String sysparamsUpdate(@PathVariable Integer sysparamsId, Model model) {
        Sysparams sysparams = sysparamsService.selectById(sysparamsId);
        model.addAttribute("item",sysparams);
        LogObjectHolder.me().set(sysparams);
        return PREFIX + "sysparams_edit.html";
    }

    /**
     * 获取系统参数列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String remark) {
        EntityWrapper<Sysparams> sysparamsEntityWrapper = new EntityWrapper<>();
        Wrapper<Sysparams> wrapper = sysparamsEntityWrapper.like("remark", remark);
        return sysparamsService.selectList(wrapper);
    }

    /**
     * 新增系统参数
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Sysparams sysparams) {
        sysparamsService.insert(sysparams);
        return SUCCESS_TIP;
    }

    /**
     * 删除系统参数
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer sysparamsId) {
        sysparamsService.deleteById(sysparamsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改系统参数
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Sysparams sysparams) {
        sysparamsService.updateById(sysparams);
        return SUCCESS_TIP;
    }

    /**
     * 系统参数详情
     */
    @RequestMapping(value = "/detail/{sysparamsId}")
    @ResponseBody
    public Object detail(@PathVariable("sysparamsId") Integer sysparamsId) {
        return sysparamsService.selectById(sysparamsId);
    }
}
