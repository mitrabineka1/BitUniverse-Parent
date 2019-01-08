package cn.stylefeng.guns.modular.order.controller;

import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.common.page.PageInfoBT;
import cn.stylefeng.guns.modular.system.warpper.OkexDealRecordWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.OkexDealRecord;
import cn.stylefeng.guns.modular.order.service.IOkexDealRecordService;

import java.util.List;
import java.util.Map;

/**
 * OKEX交易流水控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 10:26:00
 */
@Controller
@RequestMapping("/okexDealRecord")
public class OkexDealRecordController extends BaseController {

    private String PREFIX = "/order/okexDealRecord/";

    @Autowired
    private IOkexDealRecordService okexDealRecordService;

    /**
     * 跳转到OKEX交易流水首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "okexDealRecord.html";
    }

    /**
     * 跳转到添加OKEX交易流水
     */
    @RequestMapping("/okexDealRecord_add")
    public String okexDealRecordAdd() {
        return PREFIX + "okexDealRecord_add.html";
    }

    /**
     * 跳转到修改OKEX交易流水
     */
    @RequestMapping("/okexDealRecord_update/{okexDealRecordId}")
    public String okexDealRecordUpdate(@PathVariable Integer okexDealRecordId, Model model) {
        OkexDealRecord okexDealRecord = okexDealRecordService.selectById(okexDealRecordId);
        model.addAttribute("item",okexDealRecord);
        LogObjectHolder.me().set(okexDealRecord);
        return PREFIX + "okexDealRecord_edit.html";
    }

    /**
     * 获取OKEX交易流水列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String coin) {
        Page<OkexDealRecord> page = new PageFactory<OkexDealRecord>().defaultPage();
        List<Map<String, Object>> list = okexDealRecordService.selectLists(coin, page);
        page.setRecords(new OkexDealRecordWarpper(list).wrap());
        return new PageInfoBT<>(page);
    }

    /**
     * 新增OKEX交易流水
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(OkexDealRecord okexDealRecord) {
        okexDealRecordService.insert(okexDealRecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除OKEX交易流水
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer okexDealRecordId) {
        okexDealRecordService.deleteById(okexDealRecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改OKEX交易流水
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(OkexDealRecord okexDealRecord) {
        okexDealRecordService.updateById(okexDealRecord);
        return SUCCESS_TIP;
    }

    /**
     * OKEX交易流水详情
     */
    @RequestMapping(value = "/detail/{okexDealRecordId}")
    @ResponseBody
    public Object detail(@PathVariable("okexDealRecordId") Integer okexDealRecordId) {
        return okexDealRecordService.selectById(okexDealRecordId);
    }
}
