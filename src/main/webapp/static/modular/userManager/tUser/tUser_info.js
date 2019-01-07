/**
 * 初始化用户管理详情对话框
 */
var TUserInfoDlg = {
    tUserInfoData : {}
};

/**
 * 清除数据
 */
TUserInfoDlg.clearData = function() {
    this.tUserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserInfoDlg.set = function(key, val) {
    this.tUserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TUserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TUserInfoDlg.close = function() {
    parent.layer.close(window.parent.TUser.layerIndex);
}

/**
 * 收集数据
 */
TUserInfoDlg.collectData = function() {
    this
    .set('id')
    .set('phone')
    .set('userPassword')
    .set('secretKey')
    .set('token')
    .set('tokenCreateTime')
    .set('loginTime')
    .set('deviceInfo')
    .set('deviceType')
    .set('deviceOs')
    .set('state');
}

/**
 * 提交添加
 */
TUserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUser/add", function(data){
        Feng.success("添加成功!");
        window.parent.TUser.table.refresh();
        TUserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TUserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tUser/update", function(data){
        Feng.success("修改成功!");
        window.parent.TUser.table.refresh();
        TUserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tUserInfoData);
    ajax.start();
}

$(function() {

});
