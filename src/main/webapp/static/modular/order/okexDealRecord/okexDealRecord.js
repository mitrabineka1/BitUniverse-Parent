/**
 * OKEX交易流水管理初始化
 */
var OkexDealRecord = {
    id: "OkexDealRecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
OkexDealRecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'okDeal', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '总额', field: 'volume', visible: true, align: 'center', valign: 'middle'},
            {title: '交易类型', field: 'orderType', visible: true, align: 'center', valign: 'middle'},
            {title: '时间', field: 'time', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
OkexDealRecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        OkexDealRecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加OKEX交易流水
 */
OkexDealRecord.openAddOkexDealRecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加OKEX交易流水',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/okexDealRecord/okexDealRecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看OKEX交易流水详情
 */
OkexDealRecord.openOkexDealRecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'OKEX交易流水详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/okexDealRecord/okexDealRecord_update/' + OkexDealRecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除OKEX交易流水
 */
OkexDealRecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/okexDealRecord/delete", function (data) {
            Feng.success("删除成功!");
            OkexDealRecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("okexDealRecordId",this.seItem.id);
        ajax.start();
    }
};

OkexDealRecord.resetSearch = function () {
    $("#coin").val("");
    OkexDealRecord.search();
};
/**
 * 查询OKEX交易流水列表
 */
OkexDealRecord.search = function () {
    var queryData = {};
    queryData['coin'] = $("#coin").val();
    OkexDealRecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = OkexDealRecord.initColumn();
    var table = new BSTable(OkexDealRecord.id, "/okexDealRecord/list", defaultColunms);
    table.setPaginationType("client");
    OkexDealRecord.table = table.init();
});
