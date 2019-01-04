/**
 * 资金分布管理初始化
 */
var CapDistribution = {
    id: "CapDistributionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CapDistribution.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所id', field: 'exchangeId', visible: true, align: 'center', valign: 'middle'},
            {title: '参数 大单 中单 小单 流入流出/数量', field: 'param', visible: true, align: 'center', valign: 'middle'},
            {title: '资金流向 0流入 1流出', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '金额', field: 'amount', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CapDistribution.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CapDistribution.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加资金分布
 */
CapDistribution.openAddCapDistribution = function () {
    var index = layer.open({
        type: 2,
        title: '添加资金分布',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/capDistribution/capDistribution_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看资金分布详情
 */
CapDistribution.openCapDistributionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '资金分布详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/capDistribution/capDistribution_update/' + CapDistribution.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除资金分布
 */
CapDistribution.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/capDistribution/delete", function (data) {
            Feng.success("删除成功!");
            CapDistribution.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("capDistributionId",this.seItem.id);
        ajax.start();
    }
};

CapDistribution.resetSearch = function () {
    $("#coin").val("");
    CapDistribution.search();
};

/**
 * 查询资金分布列表
 */
CapDistribution.search = function () {
    var queryData = {};
    queryData['coin'] = $("#coin").val();
    CapDistribution.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CapDistribution.initColumn();
    var table = new BSTable(CapDistribution.id, "/capDistribution/list", defaultColunms);
    table.setPaginationType("client");
    CapDistribution.table = table.init();
});
