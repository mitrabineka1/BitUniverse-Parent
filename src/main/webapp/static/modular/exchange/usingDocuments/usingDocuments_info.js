/**
 * 初始化添加持仓帮助文档详情对话框
 */
var UsingDocumentsInfoDlg = {
    usingDocumentsInfoData : {}
};

/**
 * 清除数据
 */
UsingDocumentsInfoDlg.clearData = function() {
    this.usingDocumentsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UsingDocumentsInfoDlg.set = function(key, val) {
    this.usingDocumentsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UsingDocumentsInfoDlg.get = function(key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
UsingDocumentsInfoDlg.close = function() {
    parent.layer.close(window.parent.UsingDocuments.layerIndex);
};

/**
 * 收集数据
 */
UsingDocumentsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('coinId');
    this.usingDocumentsInfoData['content'] = UsingDocumentsInfoDlg.editor.html();
};

/**
 * 提交添加
 */
UsingDocumentsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/usingDocuments/add", function(data){
        Feng.success("添加成功!");
        window.parent.UsingDocuments.table.refresh();
        UsingDocumentsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.usingDocumentsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UsingDocumentsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/usingDocuments/update", function(data){
        Feng.success("修改成功!");
        window.parent.UsingDocuments.table.refresh();
        UsingDocumentsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.usingDocumentsInfoData);
    ajax.start();
}

$(function() {

});
function sub() {
   var coinId = document.getElementById('coinId').value;
   var content = editor.txt.text();
    $.ajax({
        type : "post",
        url : Feng.ctxPath + "/usingDocuments/add",
        data : {
            coinId : coinId,
            "content" : content
        },
        success : function(result) {
            Feng.success("添加成功!");
            window.parent.UsingDocuments.table.refresh();
            UsingDocumentsInfoDlg.close();
        },
        error : function(data) {
            Feng.error("添加失败!");
        }
    });
}
