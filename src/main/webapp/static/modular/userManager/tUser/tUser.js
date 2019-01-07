/**
 * 用户管理管理初始化
 */
var TUser = {
    id: "TUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '用户账号', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '用户密码', field: 'userPassword', visible: true, align: 'center', valign: 'middle'},
            {title: '密钥', field: 'secretKey', visible: true, align: 'center', valign: 'middle'},
            {title: 'token', field: 'token', visible: true, align: 'center', valign: 'middle'},
            {title: 'token生成时间', field: 'tokenCreateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '最后登录时间', field: 'loginTime', visible: true, align: 'center', valign: 'middle'},
            {title: '设备信息', field: 'deviceInfo', visible: true, align: 'center', valign: 'middle'},
            {title: '设备类型 1安卓 2ios', field: 'deviceType', visible: true, align: 'center', valign: 'middle'},
            {title: '操作系统', field: 'deviceOs', visible: true, align: 'center', valign: 'middle'},
            {title: '状态 0:有效 1:冻结 2:注销', field: 'state', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户管理
 */
TUser.openAddTUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户管理',
        area: ['1000px', '500px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tUser/tUser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户管理详情
 */
TUser.openTUserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户管理详情',
            area: ['1000px', '530px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tUser/tUser_update/' + TUser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户管理
 */
TUser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tUser/delete", function (data) {
            Feng.success("删除成功!");
            TUser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tUserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户管理列表
 */
TUser.search = function () {
    var queryData = {};
    queryData['phone'] = $("#phone").val();
    TUser.table.refresh({query: queryData});
};
TUser.resetSearch = function () {
    $("#phone").val("");

    TUser.search();
};


$(function () {
    var defaultColunms = TUser.initColumn();
    var table = new BSTable(TUser.id, "/tUser/list", defaultColunms);
    table.setPaginationType("client");
    TUser.table = table.init();
});
