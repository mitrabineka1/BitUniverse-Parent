/**
 * 数据图表管理初始化
 */
var Count = {
    id: "CountTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Count.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Count.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Count.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加数据图表
 */
Count.openAddCount = function () {
    var index = layer.open({
        type: 2,
        title: '添加数据图表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/count/count_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看数据图表详情
 */
Count.openCountDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '数据图表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/count/count_update/' + Count.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除数据图表
 */
Count.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/count/delete", function (data) {
            Feng.success("删除成功!");
            Count.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("countId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询数据图表列表
 */
Count.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Count.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Count.initColumn();
    var table = new BSTable(Count.id, "/count/list", defaultColunms);
    table.setPaginationType("client");
    Count.table = table.init();
});
