/**
 * 初始化系统参数详情对话框
 */
var SysparamsInfoDlg = {
    sysparamsInfoData : {}
};

/**
 * 清除数据
 */
SysparamsInfoDlg.clearData = function() {
    this.sysparamsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysparamsInfoDlg.set = function(key, val) {
    this.sysparamsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysparamsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SysparamsInfoDlg.close = function() {
    parent.layer.close(window.parent.Sysparams.layerIndex);
}

/**
 * 收集数据
 */
SysparamsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('keyName')
    .set('keyVal')
    .set('remark')
    .set('type');
}

/**
 * 提交添加
 */
SysparamsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysparams/add", function(data){
        Feng.success("添加成功!");
        window.parent.Sysparams.table.refresh();
        SysparamsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sysparamsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SysparamsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysparams/update", function(data){
        Feng.success("修改成功!");
        window.parent.Sysparams.table.refresh();
        SysparamsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sysparamsInfoData);
    ajax.start();
}

$(function() {

});
