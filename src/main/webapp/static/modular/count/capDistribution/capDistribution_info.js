/**
 * 初始化资金分布详情对话框
 */
var CapDistributionInfoDlg = {
    capDistributionInfoData : {}
};

/**
 * 清除数据
 */
CapDistributionInfoDlg.clearData = function() {
    this.capDistributionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CapDistributionInfoDlg.set = function(key, val) {
    this.capDistributionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CapDistributionInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CapDistributionInfoDlg.close = function() {
    parent.layer.close(window.parent.CapDistribution.layerIndex);
}

/**
 * 收集数据
 */
CapDistributionInfoDlg.collectData = function() {
    this
    .set('id')
    .set('coin')
    .set('exchangeId')
    .set('param')
    .set('type')
    .set('amount');
}

/**
 * 提交添加
 */
CapDistributionInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/capDistribution/add", function(data){
        Feng.success("添加成功!");
        window.parent.CapDistribution.table.refresh();
        CapDistributionInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.capDistributionInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CapDistributionInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/capDistribution/update", function(data){
        Feng.success("修改成功!");
        window.parent.CapDistribution.table.refresh();
        CapDistributionInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.capDistributionInfoData);
    ajax.start();
}

$(function() {

});
