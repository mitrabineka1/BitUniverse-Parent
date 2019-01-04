package cn.stylefeng.guns.modular.count.controller;

import cn.stylefeng.guns.modular.count.service.ICapDistributionService;
import cn.stylefeng.guns.modular.system.model.CapDistribution;
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

/**
 * 资金分布控制器
 *
 * @author fengshuonan
 * @Date 2019-01-03 17:12:28
 */
@Controller
@RequestMapping("/capDistribution")
public class CapDistributionController extends BaseController {

    private String PREFIX = "/count/capDistribution/";

    @Autowired
    private ICapDistributionService capDistributionService;

    /**
     * 跳转到资金分布首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "capDistribution.html";
    }

    /**
     * 跳转到添加资金分布
     */
    @RequestMapping("/capDistribution_add")
    public String capDistributionAdd() {
        return PREFIX + "capDistribution_add.html";
    }

    /**
     * 跳转到修改资金分布
     */
    @RequestMapping("/capDistribution_update/{capDistributionId}")
    public String capDistributionUpdate(@PathVariable Integer capDistributionId, Model model) {
        CapDistribution capDistribution = capDistributionService.selectById(capDistributionId);
        model.addAttribute("item",capDistribution);
        LogObjectHolder.me().set(capDistribution);
        return PREFIX + "capDistribution_edit.html";
    }

    /**
     * 获取资金分布列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String coin) {
        EntityWrapper<CapDistribution> capDistributionEntityWrapper = new EntityWrapper<>();
        Wrapper<CapDistribution> wrapper = capDistributionEntityWrapper.like("coin", coin);
        return capDistributionService.selectList(wrapper);
    }

    /**
     * 新增资金分布
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CapDistribution capDistribution) {
        capDistributionService.insert(capDistribution);
        return SUCCESS_TIP;
    }

    /**
     * 删除资金分布
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer capDistributionId) {
        capDistributionService.deleteById(capDistributionId);
        return SUCCESS_TIP;
    }

    /**
     * 修改资金分布
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CapDistribution capDistribution) {
        capDistributionService.updateById(capDistribution);
        return SUCCESS_TIP;
    }

    /**
     * 资金分布详情
     */
    @RequestMapping(value = "/detail/{capDistributionId}")
    @ResponseBody
    public Object detail(@PathVariable("capDistributionId") Integer capDistributionId) {
        return capDistributionService.selectById(capDistributionId);
    }
}
