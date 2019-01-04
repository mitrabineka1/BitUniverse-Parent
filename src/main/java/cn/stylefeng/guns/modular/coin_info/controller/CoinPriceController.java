package cn.stylefeng.guns.modular.coin_info.controller;

import cn.stylefeng.guns.modular.system.warpper.CoinPriceWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.CoinPrice;
import cn.stylefeng.guns.modular.coin_info.service.ICoinPriceService;

import java.util.List;
import java.util.Map;

/**
 * 币种最新价格控制器
 *
 * @author fengshuonan
 * @Date 2019-01-04 19:10:10
 */
@Controller
@RequestMapping("/coinPrice")
public class CoinPriceController extends BaseController {

    private String PREFIX = "/coin_info/coinPrice/";

    @Autowired
    private ICoinPriceService coinPriceService;

    /**
     * 跳转到币种最新价格首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "coinPrice.html";
    }

    /**
     * 跳转到添加币种最新价格
     */
    @RequestMapping("/coinPrice_add")
    public String coinPriceAdd() {
        return PREFIX + "coinPrice_add.html";
    }

    /**
     * 跳转到修改币种最新价格
     */
    @RequestMapping("/coinPrice_update/{coinPriceId}")
    public String coinPriceUpdate(@PathVariable Integer coinPriceId, Model model) {
        CoinPrice coinPrice = coinPriceService.selectById(coinPriceId);
        model.addAttribute("item",coinPrice);
        LogObjectHolder.me().set(coinPrice);
        return PREFIX + "coinPrice_edit.html";
    }

    /**
     * 获取币种最新价格列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String c1, String c2, String eid) {
        List<Map<String, Object>> list = coinPriceService.selectLists(c1, c2, eid);
        return new CoinPriceWarpper(list).wrap();
    }

    /**
     * 新增币种最新价格
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CoinPrice coinPrice) {
        coinPriceService.insert(coinPrice);
        return SUCCESS_TIP;
    }

    /**
     * 删除币种最新价格
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer coinPriceId) {
        coinPriceService.deleteById(coinPriceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改币种最新价格
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinPrice coinPrice) {
        coinPriceService.updateById(coinPrice);
        return SUCCESS_TIP;
    }

    /**
     * 币种最新价格详情
     */
    @RequestMapping(value = "/detail/{coinPriceId}")
    @ResponseBody
    public Object detail(@PathVariable("coinPriceId") Integer coinPriceId) {
        return coinPriceService.selectById(coinPriceId);
    }
}
