/**
 * 初始化币种最新价格详情对话框
 */
var CoinPriceInfoDlg = {
    coinPriceInfoData : {}
};

/**
 * 清除数据
 */
CoinPriceInfoDlg.clearData = function() {
    this.coinPriceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinPriceInfoDlg.set = function(key, val) {
    this.coinPriceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinPriceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CoinPriceInfoDlg.close = function() {
    parent.layer.close(window.parent.CoinPrice.layerIndex);
}

/**
 * 收集数据
 */
CoinPriceInfoDlg.collectData = function() {
    this
    .set('id')
    .set('c1')
    .set('c2')
    .set('exchangeId')
    .set('price');
}

/**
 * 提交添加
 */
CoinPriceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinPrice/add", function(data){
        Feng.success("添加成功!");
        window.parent.CoinPrice.table.refresh();
        CoinPriceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinPriceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CoinPriceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinPrice/update", function(data){
        Feng.success("修改成功!");
        window.parent.CoinPrice.table.refresh();
        CoinPriceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinPriceInfoData);
    ajax.start();
}

$(function() {

});
