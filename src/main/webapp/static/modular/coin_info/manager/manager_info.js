/**
 * 初始化币种动态信息详情对话框
 */
var ManagerInfoDlg = {
    managerInfoData : {}
};

/**
 * 清除数据
 */
ManagerInfoDlg.clearData = function() {
    this.managerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ManagerInfoDlg.set = function(key, val) {
    this.managerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ManagerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ManagerInfoDlg.close = function() {
    parent.layer.close(window.parent.Manager.layerIndex);
}

/**
 * 收集数据
 */
ManagerInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('symbol')
    .set('websiteSlug')
    .set('logoUrl')
    .set('urlTransaction')
    .set('urlAddressInfo')
    .set('circulatingSupply')
    .set('marketCap')
    .set('volume24h')
    .set('maxSupply')
    .set('markeyRatio')
    .set('turnoverRate')
    .set('circulationRate')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
ManagerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/manager/add", function(data){
        Feng.success("添加成功!");
        window.parent.Manager.table.refresh();
        ManagerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.managerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ManagerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/manager/update", function(data){
        Feng.success("修改成功!");
        window.parent.Manager.table.refresh();
        ManagerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.managerInfoData);
    ajax.start();
}

$(function() {

});
