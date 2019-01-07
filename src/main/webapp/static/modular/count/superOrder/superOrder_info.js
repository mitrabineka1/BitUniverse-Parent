/**
 * 初始化超级大单详情对话框
 */
var SuperOrderInfoDlg = {
    superOrderInfoData : {}
};

/**
 * 清除数据
 */
SuperOrderInfoDlg.clearData = function() {
    this.superOrderInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SuperOrderInfoDlg.set = function(key, val) {
    this.superOrderInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SuperOrderInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SuperOrderInfoDlg.close = function() {
    parent.layer.close(window.parent.SuperOrder.layerIndex);
}

/**
 * 收集数据
 */
SuperOrderInfoDlg.collectData = function() {
    this
    .set('id')
    .set('coin')
    .set('exchangeId')
    .set('price')
    .set('size')
    .set('side')
    .set('total')
    .set('time');
}

/**
 * 提交添加
 */
SuperOrderInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/superOrder/add", function(data){
        Feng.success("添加成功!");
        window.parent.SuperOrder.table.refresh();
        SuperOrderInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.superOrderInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SuperOrderInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/superOrder/update", function(data){
        Feng.success("修改成功!");
        window.parent.SuperOrder.table.refresh();
        SuperOrderInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.superOrderInfoData);
    ajax.start();
}

$(function() {

});
