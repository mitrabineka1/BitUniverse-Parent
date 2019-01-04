/**
 * 币种动态信息管理初始化
 */
var Manager = {
    id: "ManagerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Manager.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '币种代码', field: 'symbol', visible: true, align: 'center', valign: 'middle'},
            {title: '站点名称', field: 'websiteSlug', visible: true, align: 'center', valign: 'middle'},
            {title: '币种logo图片地址', field: 'logoUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '获取交易信息', field: 'urlTransaction', visible: true, align: 'center', valign: 'middle'},
            {title: '获取地址信息（余额）', field: 'urlAddressInfo', visible: true, align: 'center', valign: 'middle'},
            {title: '流通量', field: 'circulatingSupply', visible: true, align: 'center', valign: 'middle'},
            {title: '市值', field: 'marketCap', visible: true, align: 'center', valign: 'middle'},
            {title: '24H成交额', field: 'volume24h', visible: true, align: 'center', valign: 'middle'},
            {title: '发行量', field: 'maxSupply', visible: true, align: 'center', valign: 'middle'},
            {title: '全球市值占比', field: 'markeyRatio', visible: true, align: 'center', valign: 'middle'},
            {title: '换手率', field: 'turnoverRate', visible: true, align: 'center', valign: 'middle'},
            {title: '流通率', field: 'circulationRate', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Manager.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Manager.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加币种动态信息
 */
Manager.openAddManager = function () {
    var index = layer.open({
        type: 2,
        title: '添加币种动态信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/manager/manager_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看币种动态信息详情
 */
Manager.openManagerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '币种动态信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/manager/manager_update/' + Manager.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除币种动态信息
 */
Manager.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/manager/delete", function (data) {
            Feng.success("删除成功!");
            Manager.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("managerId",this.seItem.id);
        ajax.start();
    }
};


Manager.resetSearch = function () {
    $("#coin").val("");

    Manager.search();
}
/**
 * 查询币种动态信息列表
 */
Manager.search = function () {
    var queryData = {};
    queryData['coin'] = $("#coin").val();
    Manager.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Manager.initColumn();
    var table = new BSTable(Manager.id, "/manager/list", defaultColunms);
    table.setPaginationType("client");
    Manager.table = table.init();
});
