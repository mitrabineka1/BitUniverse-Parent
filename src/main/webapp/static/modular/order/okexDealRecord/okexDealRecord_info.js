/**
 * 初始化OKEX交易流水详情对话框
 */
var OkexDealRecordInfoDlg = {
    okexDealRecordInfoData : {}
};

/**
 * 清除数据
 */
OkexDealRecordInfoDlg.clearData = function() {
    this.okexDealRecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OkexDealRecordInfoDlg.set = function(key, val) {
    this.okexDealRecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OkexDealRecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OkexDealRecordInfoDlg.close = function() {
    parent.layer.close(window.parent.OkexDealRecord.layerIndex);
}

/**
 * 收集数据
 */
OkexDealRecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('coinId')
    .set('price')
    .set('volume')
    .set('type')
    .set('time');
}

/**
 * 提交添加
 */
OkexDealRecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/okexDealRecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.OkexDealRecord.table.refresh();
        OkexDealRecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.okexDealRecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OkexDealRecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/okexDealRecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.OkexDealRecord.table.refresh();
        OkexDealRecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.okexDealRecordInfoData);
    ajax.start();
}

$(function() {

});
