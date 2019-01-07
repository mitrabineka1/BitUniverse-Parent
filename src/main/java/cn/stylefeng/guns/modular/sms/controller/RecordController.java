package cn.stylefeng.guns.modular.sms.controller;

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
import cn.stylefeng.guns.modular.system.model.Record;
import cn.stylefeng.guns.modular.sms.service.IRecordService;

/**
 * 短信管理控制器
 *
 * @author fengshuonan
 * @Date 2019-01-07 16:16:01
 */
@Controller
@RequestMapping("/record")
public class RecordController extends BaseController {

    private String PREFIX = "/sms/record/";

    @Autowired
    private IRecordService recordService;

    /**
     * 跳转到短信管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "record.html";
    }

    /**
     * 跳转到添加短信管理
     */
    @RequestMapping("/record_add")
    public String recordAdd() {
        return PREFIX + "record_add.html";
    }

    /**
     * 跳转到修改短信管理
     */
    @RequestMapping("/record_update/{recordId}")
    public String recordUpdate(@PathVariable Integer recordId, Model model) {
        Record record = recordService.selectById(recordId);
        model.addAttribute("item",record);
        LogObjectHolder.me().set(record);
        return PREFIX + "record_edit.html";
    }

    /**
     * 获取短信管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String phone) {
        EntityWrapper<Record> recordEntityWrapper = new EntityWrapper<>();
        Wrapper<Record> wrapper = recordEntityWrapper.like("phone", phone);
        return recordService.selectList(wrapper);
    }

    /**
     * 新增短信管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Record record) {
        recordService.insert(record);
        return SUCCESS_TIP;
    }

    /**
     * 删除短信管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer recordId) {
        recordService.deleteById(recordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改短信管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Record record) {
        recordService.updateById(record);
        return SUCCESS_TIP;
    }

    /**
     * 短信管理详情
     */
    @RequestMapping(value = "/detail/{recordId}")
    @ResponseBody
    public Object detail(@PathVariable("recordId") Integer recordId) {
        return recordService.selectById(recordId);
    }
}
