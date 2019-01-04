package cn.stylefeng.guns.modular.count.controller;

import cn.stylefeng.guns.modular.system.warpper.InfoWarpper;
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
import cn.stylefeng.guns.modular.system.model.CoinData;
import cn.stylefeng.guns.modular.count.service.ICoinDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 币种数据控制器
 *
 * @author fengshuonan
 * @Date 2019-01-04 11:25:50
 */
@Controller
@RequestMapping("/coinData")
public class CoinDataController extends BaseController {

    private String PREFIX = "/count/coinData/";

    @Autowired
    private ICoinDataService coinDataService;

    /**
     * 跳转到币种数据首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "coinData.html";
    }

    /**
     * 跳转到添加币种数据
     */
    @RequestMapping("/coinData_add")
    public String coinDataAdd() {
        return PREFIX + "coinData_add.html";
    }

    /**
     * 跳转到修改币种数据
     */
    @RequestMapping("/coinData_update/{coinDataId}")
    public String coinDataUpdate(@PathVariable Integer coinDataId, Model model) {
        CoinData coinData = coinDataService.selectById(coinDataId);
        model.addAttribute("item",coinData);
        LogObjectHolder.me().set(coinData);
        return PREFIX + "coinData_edit.html";
    }

    /**
     * 获取币种数据列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String coin) {
        EntityWrapper<CoinData> coinDataEntityWrapper = new EntityWrapper<>();
        Wrapper<CoinData> wrapper = coinDataEntityWrapper.like("coin", coin);
        return coinDataService.selectList(wrapper);
    }

    /**
     * 新增币种数据
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CoinData coinData) {
        coinDataService.insert(coinData);
        return SUCCESS_TIP;
    }

    /**
     * 删除币种数据
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer coinDataId) {
        coinDataService.deleteById(coinDataId);
        return SUCCESS_TIP;
    }

    /**
     * 修改币种数据
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinData coinData) {
        coinDataService.updateById(coinData);
        return SUCCESS_TIP;
    }

    /**
     * 币种数据详情
     */
    @RequestMapping(value = "/detail/{coinDataId}")
    @ResponseBody
    public Object detail(@PathVariable("coinDataId") Integer coinDataId) {
        return coinDataService.selectById(coinDataId);
    }
}
