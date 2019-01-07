/**
 * 短信管理管理初始化
 */
var Record = {
    id: "RecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Record.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'Id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '类型 1:注册 2:其他', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '返回状态', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '短信验证码', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '状态 0:无效 1有效', field: 'times', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Record.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Record.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加短信管理
 */
Record.openAddRecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加短信管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/record/record_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看短信管理详情
 */
Record.openRecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '短信管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/record/record_update/' + Record.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除短信管理
 */
Record.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/record/delete", function (data) {
            Feng.success("删除成功!");
            Record.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("recordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询短信管理列表
 */
Record.search = function () {
    var queryData = {};
    queryData['phone'] = $("#phone").val();
    Record.table.refresh({query: queryData});
};
Record.resetSearch = function () {
    $("#phone").val("");
    Record.search();
};


$(function () {
    var defaultColunms = Record.initColumn();
    var table = new BSTable(Record.id, "/record/list", defaultColunms);
    table.setPaginationType("client");
    Record.table = table.init();
});
