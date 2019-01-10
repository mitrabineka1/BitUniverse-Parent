package cn.stylefeng.guns.modular.count.controller;

import cn.stylefeng.guns.modular.count.service.CountService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 资产分布图表控制器
 *
 * @author fengshuonan
 * @Date 2019-01-10 11:47:22
 */
@Controller
@RequestMapping("/funds")
public class FundsController extends BaseController {

    private String PREFIX = "/count/funds/";
    @Autowired
    private CountService countService;


    /**
     * 跳转到资产分布图表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "funds.html";
    }
    /**
     * 获取资金分布数据
     */
    @ResponseBody
    @RequestMapping("fundDIs")
    public String fundDis(Integer coinId) {
        Map<String, Map<String, BigDecimal>> map = countService.fundDis(coinId);
        return JSON.toJSONString(map);
    }
}
