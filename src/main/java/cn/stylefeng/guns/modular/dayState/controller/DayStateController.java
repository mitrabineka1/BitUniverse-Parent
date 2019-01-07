package cn.stylefeng.guns.modular.dayState.controller;

import cn.stylefeng.guns.modular.system.warpper.DayStateWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.DayState;
import cn.stylefeng.guns.modular.dayState.service.IDayStateService;

import java.util.List;
import java.util.Map;

/**
 * 每日统计控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 09:36:38
 */
@Controller
@RequestMapping("/dayState")
public class DayStateController extends BaseController {

    private String PREFIX = "/dayState/dayState/";

    @Autowired
    private IDayStateService dayStateService;

    /**
     * 跳转到每日统计首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dayState.html";
    }

    /**
     * 跳转到添加每日统计
     */
    @RequestMapping("/dayState_add")
    public String dayStateAdd() {
        return PREFIX + "dayState_add.html";
    }

    /**
     * 跳转到修改每日统计
     */
    @RequestMapping("/dayState_update/{dayStateId}")
    public String dayStateUpdate(@PathVariable Integer dayStateId, Model model) {
        DayState dayState = dayStateService.selectById(dayStateId);
        model.addAttribute("item",dayState);
        LogObjectHolder.me().set(dayState);
        return PREFIX + "dayState_edit.html";
    }

    /**
     * 获取每日统计列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {
        List<Map<String, Object>> list = dayStateService.selectLists();
        return new DayStateWarpper(list).wrap();
    }

    /**
     * 新增每日统计
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DayState dayState) {
        dayStateService.insert(dayState);
        return SUCCESS_TIP;
    }

    /**
     * 删除每日统计
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer dayStateId) {
        dayStateService.deleteById(dayStateId);
        return SUCCESS_TIP;
    }

    /**
     * 修改每日统计
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DayState dayState) {
        dayStateService.updateById(dayState);
        return SUCCESS_TIP;
    }

    /**
     * 每日统计详情
     */
    @RequestMapping(value = "/detail/{dayStateId}")
    @ResponseBody
    public Object detail(@PathVariable("dayStateId") Integer dayStateId) {
        return dayStateService.selectById(dayStateId);
    }
}
