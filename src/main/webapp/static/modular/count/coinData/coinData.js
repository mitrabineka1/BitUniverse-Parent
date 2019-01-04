/**
 * 币种数据管理初始化
 */
var CoinData = {
    id: "CoinDataTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CoinData.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所id', field: 'exchangeId', visible: true, align: 'center', valign: 'middle'},
            {title: '当前价格（rmb）', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '当前价格（usdt）', field: 'priceUsdt', visible: true, align: 'center', valign: 'middle'},
            {title: '24小时价格变化', field: 'priceChange', visible: true, align: 'center', valign: 'middle'},
            {title: '24小时价格变化百分比', field: 'priceChangePercent', visible: true, align: 'center', valign: 'middle'},
            {title: '24小时最高价', field: 'dayHigh', visible: true, align: 'center', valign: 'middle'},
            {title: '24小时最低价', field: 'dayLow', visible: true, align: 'center', valign: 'middle'},
            {title: '24小时交易量（usdt）', field: 'dayVolume', visible: true, align: 'center', valign: 'middle'},
            {title: '市值', field: 'marketCap', visible: true, align: 'center', valign: 'middle'},
            {title: '流通量', field: 'circulation', visible: true, align: 'center', valign: 'middle'},
            {title: '排名', field: 'rank', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CoinData.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CoinData.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加币种数据
 */
CoinData.openAddCoinData = function () {
    var index = layer.open({
        type: 2,
        title: '添加币种数据',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/coinData/coinData_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看币种数据详情
 */
CoinData.openCoinDataDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '币种数据详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/coinData/coinData_update/' + CoinData.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除币种数据
 */
CoinData.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/coinData/delete", function (data) {
            Feng.success("删除成功!");
            CoinData.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("coinDataId",this.seItem.id);
        ajax.start();
    }
};
CoinData.resetSearch = function () {
    $("#coin").val("");
    CoinData.search();
};

/**
 * 查询币种数据列表
 */
CoinData.search = function () {
    var queryData = {};
    queryData['coin'] = $("#coin").val();
    CoinData.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CoinData.initColumn();
    var table = new BSTable(CoinData.id, "/coinData/list", defaultColunms);
    table.setPaginationType("client");
    CoinData.table = table.init();
});
