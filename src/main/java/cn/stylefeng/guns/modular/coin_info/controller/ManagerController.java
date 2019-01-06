package cn.stylefeng.guns.modular.coin_info.controller;

import cn.stylefeng.guns.modular.coin_info.service.IInfoService;
import cn.stylefeng.guns.modular.system.model.Info;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Manager;
import cn.stylefeng.guns.modular.coin_info.service.IManagerService;

import java.util.List;
import java.util.Map;

/**
 * 币种动态信息控制器
 *
 * @author fengshuonan
 * @Date 2019-01-04 19:00:28
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    private String PREFIX = "/coin_info/manager/";

    @Autowired
    private IManagerService managerService;
    @Autowired
    private IInfoService infoService;

    /**
     * 跳转到币种动态信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "manager.html";
    }

    /**
     * 跳转到添加币种动态信息
     */
    @RequestMapping("/manager_add")
    public String managerAdd() {
        return PREFIX + "manager_add.html";
    }

    /**
     * 跳转到修改币种动态信息
     */
    @RequestMapping("/manager_update/{managerId}")
    public String managerUpdate(@PathVariable Integer managerId, Model model) {
        Manager manager = managerService.selectById(managerId);
        model.addAttribute("item",manager);
        LogObjectHolder.me().set(manager);
        return PREFIX + "manager_edit.html";
    }

    /**
     * 获取币种动态信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String coin) {
        EntityWrapper<Manager> managerEntityWrapper = new EntityWrapper<>();
        Wrapper<Manager> wrapper = managerEntityWrapper.like("symbol", coin);
        return managerService.selectList(wrapper);
    }

    /**
     * 新增币种动态信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Manager manager, Info info) {
        managerService.insert(manager);
        info.setCoinId(manager.getId());
        infoService.insert(info);
        return SUCCESS_TIP;
    }

    /**
     * 删除币种动态信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer managerId) {
        managerService.deleteById(managerId);
        infoService.deleteByCoinId(managerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改币种动态信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Manager manager) {
        managerService.updateById(manager);
        return SUCCESS_TIP;
    }

    /**
     * 币种动态信息详情
     */
    @RequestMapping(value = "/detail/{managerId}")
    @ResponseBody
    public Object detail(@PathVariable("managerId") Integer managerId) {
        return managerService.selectById(managerId);
    }
}
