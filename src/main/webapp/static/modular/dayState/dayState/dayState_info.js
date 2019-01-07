/**
 * 初始化每日统计详情对话框
 */
var DayStateInfoDlg = {
    dayStateInfoData : {}
};

/**
 * 清除数据
 */
DayStateInfoDlg.clearData = function() {
    this.dayStateInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DayStateInfoDlg.set = function(key, val) {
    this.dayStateInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DayStateInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DayStateInfoDlg.close = function() {
    parent.layer.close(window.parent.DayState.layerIndex);
}

/**
 * 收集数据
 */
DayStateInfoDlg.collectData = function() {
    this
    .set('id')
    .set('exchangeId')
    .set('coin')
    .set('dayIn')
    .set('dayOut')
    .set('actual')
    .set('ratio');
}

/**
 * 提交添加
 */
DayStateInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dayState/add", function(data){
        Feng.success("添加成功!");
        window.parent.DayState.table.refresh();
        DayStateInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dayStateInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DayStateInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dayState/update", function(data){
        Feng.success("修改成功!");
        window.parent.DayState.table.refresh();
        DayStateInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dayStateInfoData);
    ajax.start();
}

$(function() {

});
