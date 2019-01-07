package cn.stylefeng.guns.modular.exchange.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Exchange;
import cn.stylefeng.guns.modular.exchange.service.IExchangeService;

import java.util.List;
import java.util.Map;

/**
 * 交易所管理控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 10:07:27
 */
@Controller
@RequestMapping("/exchange")
public class ExchangeController extends BaseController {

    private String PREFIX = "/exchange/exchange/";

    @Autowired
    private IExchangeService exchangeService;

    /**
     * 跳转到交易所管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "exchange.html";
    }

    /**
     * 跳转到添加交易所管理
     */
    @RequestMapping("/exchange_add")
    public String exchangeAdd() {
        return PREFIX + "exchange_add.html";
    }

    /**
     * 跳转到修改交易所管理
     */
    @RequestMapping("/exchange_update/{exchangeId}")
    public String exchangeUpdate(@PathVariable Integer exchangeId, Model model) {
        Exchange exchange = exchangeService.selectById(exchangeId);
        model.addAttribute("item",exchange);
        LogObjectHolder.me().set(exchange);
        return PREFIX + "exchange_edit.html";
    }

    /**
     * 获取交易所管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return exchangeService.selectList(null);
    }

    /**
     * 新增交易所管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Exchange exchange) {
        exchangeService.insert(exchange);
        return SUCCESS_TIP;
    }

    /**
     * 删除交易所管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer exchangeId) {
        exchangeService.deleteById(exchangeId);
        return SUCCESS_TIP;
    }

    /**
     * 修改交易所管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Exchange exchange) {
        exchangeService.updateById(exchange);
        return SUCCESS_TIP;
    }

    /**
     * 交易所管理详情
     */
    @RequestMapping(value = "/detail/{exchangeId}")
    @ResponseBody
    public Object detail(@PathVariable("exchangeId") Integer exchangeId) {
        return exchangeService.selectById(exchangeId);
    }
}
