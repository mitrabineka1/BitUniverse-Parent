package cn.stylefeng.guns.modular.coin_info.controller;

import cn.stylefeng.guns.modular.coin_info.service.IInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Info;

/**
 * 币百科控制器
 *
 * @author fengshuonan
 * @Date 2019-01-02 14:11:54
 */
@Controller
@RequestMapping("/info")
public class InfoController extends BaseController {

    private String PREFIX = "/coin_info/info/";

    @Autowired
    private IInfoService infoService;

    /**
     * 跳转到币百科首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "info.html";
    }

    /**
     * 跳转到添加币百科
     */
    @RequestMapping("/info_add")
    public String infoAdd() {
        return PREFIX + "info_add.html";
    }

    /**
     * 跳转到修改币百科
     */
    @RequestMapping("/info_update/{infoId}")
    public String infoUpdate(@PathVariable Integer infoId, Model model) {
        Info info = infoService.selectById(infoId);
        model.addAttribute("item",info);
        LogObjectHolder.me().set(info);
        return PREFIX + "info_edit.html";
    }

    /**
     * 获取币百科列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return infoService.selectList(null);
    }

    /**
     * 新增币百科
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Info info) {
        infoService.insert(info);
        return SUCCESS_TIP;
    }

    /**
     * 删除币百科
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer infoId) {
        infoService.deleteById(infoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改币百科
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Info info) {
        infoService.updateById(info);
        return SUCCESS_TIP;
    }

    /**
     * 币百科详情
     */
    @RequestMapping(value = "/detail/{infoId}")
    @ResponseBody
    public Object detail(@PathVariable("infoId") Integer infoId) {
        return infoService.selectById(infoId);
    }
}
