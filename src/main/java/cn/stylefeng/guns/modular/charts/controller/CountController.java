package cn.stylefeng.guns.modular.charts.controller;

import cn.stylefeng.guns.modular.count.service.CountService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 数据图表控制器
 *
 * @author fengshuonan
 * @Date 2019-01-09 11:15:04
 */
@Controller
@RequestMapping("/count")
public class CountController extends BaseController {

    private String PREFIX = "/charts/count/";
    @Autowired
    private CountService countService;


    /**
     * 跳转到数据图表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "count.html";
    }


    /**
     * 获取K线数据
     */
    @ResponseBody
    @RequestMapping("kline")
    public String init(Integer coinId, Integer exchangeId, Integer gear) {
        List<List<Object>> list = countService.getKline(coinId, exchangeId, gear);
        return JSON.toJSONString(list);
    }

}
