/**
 * 初始化短信管理详情对话框
 */
var RecordInfoDlg = {
    recordInfoData : {}
};

/**
 * 清除数据
 */
RecordInfoDlg.clearData = function() {
    this.recordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RecordInfoDlg.set = function(key, val) {
    this.recordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RecordInfoDlg.close = function() {
    parent.layer.close(window.parent.Record.layerIndex);
}

/**
 * 收集数据
 */
RecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('phone')
    .set('type')
    .set('state')
    .set('code')
    .set('times')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
RecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/record/add", function(data){
        Feng.success("添加成功!");
        window.parent.Record.table.refresh();
        RecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.recordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/record/update", function(data){
        Feng.success("修改成功!");
        window.parent.Record.table.refresh();
        RecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.recordInfoData);
    ajax.start();
}

$(function() {

});
