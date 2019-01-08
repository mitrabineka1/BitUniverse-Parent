package cn.stylefeng.guns.modular.userManager.controller;

import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.common.page.PageInfoBT;
import cn.stylefeng.guns.modular.system.model.OkexDealRecord;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.abego.treelayout.internal.util.Contract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.TUser;
import cn.stylefeng.guns.modular.userManager.service.ITUserService;

/**
 * 用户管理控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 14:43:03
 */
@Controller
@RequestMapping("/tUser")
public class TUserController extends BaseController {

    private String PREFIX = "/userManager/tUser/";

    @Autowired
    private ITUserService tUserService;

    /**
     * 跳转到用户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tUser.html";
    }

    /**
     * 跳转到添加用户管理
     */
    @RequestMapping("/tUser_add")
    public String tUserAdd() {
        return PREFIX + "tUser_add.html";
    }

    /**
     * 跳转到修改用户管理
     */
    @RequestMapping("/tUser_update/{tUserId}")
    public String tUserUpdate(@PathVariable Integer tUserId, Model model) {
        TUser tUser = tUserService.selectById(tUserId);
        model.addAttribute("item",tUser);
        LogObjectHolder.me().set(tUser);
        return PREFIX + "tUser_edit.html";
    }

    /**
     * 获取用户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String phone) {
        Page<TUser> page = new PageFactory<TUser>().defaultPage();
        EntityWrapper<TUser> tUserEntityWrapper = new EntityWrapper<>();
        Wrapper<TUser> wrapper = tUserEntityWrapper.like("phone", phone);
        page = tUserService.selectPage(page, wrapper);
        return new PageInfoBT<>(page);
    }

    /**
     * 新增用户管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TUser tUser) {
        tUserService.insert(tUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tUserId) {
        tUserService.deleteById(tUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TUser tUser) {
        tUserService.updateById(tUser);
        return SUCCESS_TIP;
    }

    /**
     * 用户管理详情
     */
    @RequestMapping(value = "/detail/{tUserId}")
    @ResponseBody
    public Object detail(@PathVariable("tUserId") Integer tUserId) {
        return tUserService.selectById(tUserId);
    }
}
