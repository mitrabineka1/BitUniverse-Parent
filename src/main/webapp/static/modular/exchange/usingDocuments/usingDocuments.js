/**
 * 添加持仓帮助文档管理初始化
 */
var UsingDocuments = {
    id: "UsingDocumentsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
UsingDocuments.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '币种名称', field: 'coin', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
UsingDocuments.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UsingDocuments.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加添加持仓帮助文档
 */
UsingDocuments.openAddUsingDocuments = function () {
    var index = layer.open({
        type: 2,
        title: '添加添加持仓帮助文档',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/usingDocuments/usingDocuments_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看添加持仓帮助文档详情
 */
UsingDocuments.openUsingDocumentsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加持仓帮助文档详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/usingDocuments/usingDocuments_update/' + UsingDocuments.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除添加持仓帮助文档
 */
UsingDocuments.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/usingDocuments/delete", function (data) {
            Feng.success("删除成功!");
            UsingDocuments.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("usingDocumentsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询添加持仓帮助文档列表
 */
UsingDocuments.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UsingDocuments.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UsingDocuments.initColumn();
    var table = new BSTable(UsingDocuments.id, "/usingDocuments/list", defaultColunms);
    table.setPaginationType("client");
    UsingDocuments.table = table.init();
});
