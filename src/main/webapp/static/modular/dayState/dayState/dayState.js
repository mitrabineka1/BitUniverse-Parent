/**
 * 每日统计管理初始化
 */
var DayState = {
    id: "DayStateTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DayState.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'dayState', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所', field: 'eid', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '流入', field: 'day_in', visible: true, align: 'center', valign: 'middle'},
            {title: '流出', field: 'day_out', visible: true, align: 'center', valign: 'middle'},
            {title: '净流入', field: 'actual', visible: true, align: 'center', valign: 'middle'},
            {title: '净流入比', field: 'ratio', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
DayState.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DayState.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加每日统计
 */
DayState.openAddDayState = function () {
    var index = layer.open({
        type: 2,
        title: '添加每日统计',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dayState/dayState_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看每日统计详情
 */
DayState.openDayStateDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '每日统计详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dayState/dayState_update/' + DayState.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除每日统计
 */
DayState.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/dayState/delete", function (data) {
            Feng.success("删除成功!");
            DayState.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("dayStateId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询每日统计列表
 */
DayState.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DayState.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DayState.initColumn();
    var table = new BSTable(DayState.id, "/dayState/list", defaultColunms);
    table.setPaginationType("client");
    DayState.table = table.init();
});
