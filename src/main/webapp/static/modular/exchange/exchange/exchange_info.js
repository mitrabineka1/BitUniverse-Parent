/**
 * 初始化交易所管理详情对话框
 */
var ExchangeInfoDlg = {
    exchangeInfoData : {}
};

/**
 * 清除数据
 */
ExchangeInfoDlg.clearData = function() {
    this.exchangeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ExchangeInfoDlg.set = function(key, val) {
    this.exchangeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ExchangeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ExchangeInfoDlg.close = function() {
    parent.layer.close(window.parent.Exchange.layerIndex);
}

/**
 * 收集数据
 */
ExchangeInfoDlg.collectData = function() {
    this
    .set('id')
    .set('exId')
    .set('name')
    .set('slug')
    .set('logoUrl')
    .set('website')
    .set('twitter')
    .set('blog')
    .set('chat')
    .set('fee');
}

/**
 * 提交添加
 */
ExchangeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/exchange/add", function(data){
        Feng.success("添加成功!");
        window.parent.Exchange.table.refresh();
        ExchangeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.exchangeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ExchangeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/exchange/update", function(data){
        Feng.success("修改成功!");
        window.parent.Exchange.table.refresh();
        ExchangeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.exchangeInfoData);
    ajax.start();
}

$(function() {

});
