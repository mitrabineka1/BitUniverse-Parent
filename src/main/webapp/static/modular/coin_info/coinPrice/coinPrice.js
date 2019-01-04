/**
 * 币种最新价格管理初始化
 */
var CoinPrice = {
    id: "CoinPriceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CoinPrice.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '计价币', field: 'coin1', visible: true, align: 'center', valign: 'middle'},
            {title: '交易币', field: 'coin2', visible: true, align: 'center', valign: 'middle'},
            {title: '交易所id', field: 'eid', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CoinPrice.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CoinPrice.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加币种最新价格
 */
CoinPrice.openAddCoinPrice = function () {
    var index = layer.open({
        type: 2,
        title: '添加币种最新价格',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/coinPrice/coinPrice_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看币种最新价格详情
 */
CoinPrice.openCoinPriceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '币种最新价格详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/coinPrice/coinPrice_update/' + CoinPrice.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除币种最新价格
 */
CoinPrice.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/coinPrice/delete", function (data) {
            Feng.success("删除成功!");
            CoinPrice.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("coinPriceId",this.seItem.id);
        ajax.start();
    }
};

CoinPrice.resetSearch = function () {
    $("#c1").val("");
    $("#c2").val("");
    $("#eid").val("");

    CoinPrice.search();
}
/**
 * 查询币种最新价格列表
 */
CoinPrice.search = function () {
    var queryData = {};
    queryData['c1'] = $("#c1").val();
    queryData['c2'] = $("#c2").val();
    queryData['eid'] = $("#eid").val();
    CoinPrice.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CoinPrice.initColumn();
    var table = new BSTable(CoinPrice.id, "/coinPrice/list", defaultColunms);
    table.setPaginationType("client");
    CoinPrice.table = table.init();
});
