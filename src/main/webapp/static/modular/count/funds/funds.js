/**
 * 资产分布图表管理初始化
 */
var Funds = {
    id: "FundsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Funds.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Funds.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Funds.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加资产分布图表
 */
Funds.openAddFunds = function () {
    var index = layer.open({
        type: 2,
        title: '添加资产分布图表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/funds/funds_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看资产分布图表详情
 */
Funds.openFundsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '资产分布图表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/funds/funds_update/' + Funds.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除资产分布图表
 */
Funds.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/funds/delete", function (data) {
            Feng.success("删除成功!");
            Funds.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("fundsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询资产分布图表列表
 */
Funds.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Funds.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Funds.initColumn();
    var table = new BSTable(Funds.id, "/funds/list", defaultColunms);
    table.setPaginationType("client");
    Funds.table = table.init();
});
