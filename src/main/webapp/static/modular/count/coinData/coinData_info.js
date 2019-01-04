/**
 * 初始化币种数据详情对话框
 */
var CoinDataInfoDlg = {
    coinDataInfoData : {}
};

/**
 * 清除数据
 */
CoinDataInfoDlg.clearData = function() {
    this.coinDataInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinDataInfoDlg.set = function(key, val) {
    this.coinDataInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinDataInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CoinDataInfoDlg.close = function() {
    parent.layer.close(window.parent.CoinData.layerIndex);
}

/**
 * 收集数据
 */
CoinDataInfoDlg.collectData = function() {
    this
    .set('id')
    .set('coin')
    .set('exchangeId')
    .set('price')
    .set('priceUsdt')
    .set('priceChange')
    .set('priceChangePercent')
    .set('dayHigh')
    .set('dayLow')
    .set('dayVolume')
    .set('marketCap')
    .set('circulation')
    .set('rank');
}

/**
 * 提交添加
 */
CoinDataInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinData/add", function(data){
        Feng.success("添加成功!");
        window.parent.CoinData.table.refresh();
        CoinDataInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinDataInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CoinDataInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinData/update", function(data){
        Feng.success("修改成功!");
        window.parent.CoinData.table.refresh();
        CoinDataInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinDataInfoData);
    ajax.start();
}

$(function() {

});
