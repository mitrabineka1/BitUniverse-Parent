/**
 * 交易所管理管理初始化
 */
var Exchange = {
    id: "ExchangeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Exchange.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'exchange', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所ID', field: 'exId', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '简称', field: 'slug', visible: true, align: 'center', valign: 'middle'},
            {title: 'logo地址', field: 'logoUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '网站', field: 'website', visible: true, align: 'center', valign: 'middle'},
            {title: 'twitter', field: 'twitter', visible: true, align: 'center', valign: 'middle'},
            {title: '博客', field: 'blog', visible: true, align: 'center', valign: 'middle'},
            {title: '及时交流', field: 'chat', visible: true, align: 'center', valign: 'middle'},
            {title: '费率文档', field: 'fee', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Exchange.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Exchange.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加交易所管理
 */
Exchange.openAddExchange = function () {
    var index = layer.open({
        type: 2,
        title: '添加交易所管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/exchange/exchange_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看交易所管理详情
 */
Exchange.openExchangeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '交易所管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/exchange/exchange_update/' + Exchange.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除交易所管理
 */
Exchange.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/exchange/delete", function (data) {
            Feng.success("删除成功!");
            Exchange.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("exchangeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询交易所管理列表
 */
Exchange.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Exchange.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Exchange.initColumn();
    var table = new BSTable(Exchange.id, "/exchange/list", defaultColunms);
    table.setPaginationType("client");
    Exchange.table = table.init();
});
