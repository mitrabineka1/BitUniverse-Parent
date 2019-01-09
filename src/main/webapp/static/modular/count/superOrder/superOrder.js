/**
 * 超级大单管理初始化
 */
var SuperOrder = {
    id: "SuperOrderTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SuperOrder.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'superOrder', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所', field: 'eid', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '数量', field: 'size', visible: true, align: 'center', valign: 'middle'},
            {title: '交易类型', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '交易额', field: 'total', visible: true, align: 'center', valign: 'middle'},
            {title: '时间', field: 'time', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SuperOrder.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SuperOrder.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加超级大单
 */
SuperOrder.openAddSuperOrder = function () {
    var index = layer.open({
        type: 2,
        title: '添加超级大单',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/superOrder/superOrder_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看超级大单详情
 */
SuperOrder.openSuperOrderDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '超级大单详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/superOrder/superOrder_update/' + SuperOrder.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除超级大单
 */
SuperOrder.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/superOrder/delete", function (data) {
            Feng.success("删除成功!");
            SuperOrder.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("superOrderId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询超级大单列表
 */
SuperOrder.search = function () {
    var queryData = {};
    queryData['coin'] = $("#coin").val();
    SuperOrder.table.refresh({query: queryData});
};
SuperOrder.resetSearch = function () {
    $("#coin").val("");
    SuperOrder.search();
};

$(function () {
    var defaultColunms = SuperOrder.initColumn();
    var table = new BSTable(SuperOrder.id, "/superOrder/list", defaultColunms);
    table.setPaginationType("server");
    SuperOrder.table = table.init();
});
