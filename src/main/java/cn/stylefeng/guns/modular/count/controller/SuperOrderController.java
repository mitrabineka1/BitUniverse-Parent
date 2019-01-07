package cn.stylefeng.guns.modular.count.controller;

import cn.stylefeng.guns.modular.system.warpper.SuperOrderWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.SuperOrder;
import cn.stylefeng.guns.modular.count.service.ISuperOrderService;

import java.util.List;
import java.util.Map;

/**
 * 超级大单控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 11:00:27
 */
@Controller
@RequestMapping("/superOrder")
public class SuperOrderController extends BaseController {

    private String PREFIX = "/count/superOrder/";

    @Autowired
    private ISuperOrderService superOrderService;

    /**
     * 跳转到超级大单首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "superOrder.html";
    }

    /**
     * 跳转到添加超级大单
     */
    @RequestMapping("/superOrder_add")
    public String superOrderAdd() {
        return PREFIX + "superOrder_add.html";
    }

    /**
     * 跳转到修改超级大单
     */
    @RequestMapping("/superOrder_update/{superOrderId}")
    public String superOrderUpdate(@PathVariable Integer superOrderId, Model model) {
        SuperOrder superOrder = superOrderService.selectById(superOrderId);
        model.addAttribute("item",superOrder);
        LogObjectHolder.me().set(superOrder);
        return PREFIX + "superOrder_edit.html";
    }

    /**
     * 获取超级大单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = superOrderService.selectLists();
        return new SuperOrderWarpper(list).wrap();
    }

    /**
     * 新增超级大单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SuperOrder superOrder) {
        superOrderService.insert(superOrder);
        return SUCCESS_TIP;
    }

    /**
     * 删除超级大单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer superOrderId) {
        superOrderService.deleteById(superOrderId);
        return SUCCESS_TIP;
    }

    /**
     * 修改超级大单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SuperOrder superOrder) {
        superOrderService.updateById(superOrder);
        return SUCCESS_TIP;
    }

    /**
     * 超级大单详情
     */
    @RequestMapping(value = "/detail/{superOrderId}")
    @ResponseBody
    public Object detail(@PathVariable("superOrderId") Integer superOrderId) {
        return superOrderService.selectById(superOrderId);
    }
}
