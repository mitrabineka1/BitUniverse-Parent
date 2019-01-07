/**
 * 币种信息管理初始化
 */
var Info = {
    id: "InfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Info.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'coinInfo', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '简介', field: 'info', visible: true, align: 'center', valign: 'middle'},
            {title: '编辑头像url', field: 'edit_img_url', visible: true, align: 'center', valign: 'middle'},
            {title: '板块', field: 'plate', visible: true, align: 'center', valign: 'middle'},
            {title: '编辑人', field: 'edit_name', visible: true, align: 'center', valign: 'middle'},
            {title: '编辑评语', field: 'edit_info', visible: true, align: 'center', valign: 'middle'},
            {title: '团队介绍', field: 'team_info', visible: true, align: 'center', valign: 'middle'},
            {title: '源码地址', field: 'github', visible: true, align: 'center', valign: 'middle'},
            {title: 'reddit', field: 'reddit', visible: true, align: 'center', valign: 'middle'},
            {title: 'twitter', field: 'twitter', visible: true, align: 'center', valign: 'middle'},
            {title: 'facebook', field: 'facebook', visible: true, align: 'center', valign: 'middle'},
            {title: '官网', field: 'website', visible: true, align: 'center', valign: 'middle'},
            {title: '白皮书', field: 'white_paper', visible: true, align: 'center', valign: 'middle'},
            {title: '区块站', field: 'explorer', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
Info.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Info.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加币种信息
 */
Info.openAddInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加币种信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/info/info_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看币种信息详情
 */
Info.openInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '币种信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/info/info_update/' + Info.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除币种信息
 */
Info.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/info/delete", function (data) {
            Feng.success("删除成功!");
            Info.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("infoId",this.seItem.id);
        ajax.start();
    }
};

Info.resetSearch = function () {
    $("#coin").val("");
    Info.search();
};
/**
 * 查询币种信息列表
 */
Info.search = function () {
    var queryData = {};
    queryData['coin'] = $("#coin").val();
    Info.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Info.initColumn();
    var table = new BSTable(Info.id, "/info/list", defaultColunms);
    table.setPaginationType("client");
    Info.table = table.init();
});
