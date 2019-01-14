package cn.stylefeng.guns.modular.exchange.controller;

import cn.stylefeng.guns.modular.system.warpper.UsingDocWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.UsingDocuments;
import cn.stylefeng.guns.modular.exchange.service.IUsingDocumentsService;

import java.util.List;
import java.util.Map;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

/**
 * 添加持仓帮助文档控制器
 *
 * @author fengshuonan
 * @Date 2019-01-10 14:31:19
 */
@Controller
@RequestMapping("/usingDocuments")
public class UsingDocumentsController extends BaseController {

    private String PREFIX = "/exchange/usingDocuments/";

    @Autowired
    private IUsingDocumentsService usingDocumentsService;

    /**
     * 跳转到添加持仓帮助文档首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "usingDocuments.html";
    }

    /**
     * 跳转到添加添加持仓帮助文档
     */
    @RequestMapping("/usingDocuments_add")
    public String usingDocumentsAdd() {
        return PREFIX + "usingDocuments_add.html";
    }

    /**
     * 跳转到修改添加持仓帮助文档
     */
    @RequestMapping("/usingDocuments_update/{usingDocumentsId}")
    public String usingDocumentsUpdate(@PathVariable Integer usingDocumentsId, Model model) {
        UsingDocuments usingDocuments = usingDocumentsService.selectById(usingDocumentsId);
        model.addAttribute("item",usingDocuments);
        LogObjectHolder.me().set(usingDocuments);
        return PREFIX + "usingDocuments_edit.html";
    }

    /**
     * 获取添加持仓帮助文档列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {
        List<Map<String,Object>> list = usingDocumentsService.selectLists();
        return new UsingDocWarpper(list).wrap();
    }

    /**
     * 新增添加持仓帮助文档
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(UsingDocuments usingDocuments) {
        String content = usingDocuments.getContent();
        content = content.replaceAll("& ", "&");
        usingDocuments.setContent(content);
        usingDocumentsService.insert(usingDocuments);
        return SUCCESS_TIP;
    }

    /**
     * 删除添加持仓帮助文档
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer usingDocumentsId) {
        usingDocumentsService.deleteById(usingDocumentsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改添加持仓帮助文档
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(UsingDocuments usingDocuments) {
        String content = usingDocuments.getContent();
        content = content.replaceAll("& ", "&");
        usingDocuments.setContent(content);
        usingDocumentsService.updateById(usingDocuments);
        return SUCCESS_TIP;
    }

    /**
     * 添加持仓帮助文档详情
     */
    @RequestMapping(value = "/detail/{usingDocumentsId}")
    @ResponseBody
    public Object detail(@PathVariable("usingDocumentsId") Integer usingDocumentsId) {
        return usingDocumentsService.selectById(usingDocumentsId);
    }
}
