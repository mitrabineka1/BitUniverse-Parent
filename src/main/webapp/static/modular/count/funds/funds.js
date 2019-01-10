/**
 * 资产分布图表管理初始化
 */
var Funds = {
    id: "FundsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Funds.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Funds.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Funds.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加资产分布图表
 */
Funds.openAddFunds = function () {
    var index = layer.open({
        type: 2,
        title: '添加资产分布图表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/funds/funds_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看资产分布图表详情
 */
Funds.openFundsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '资产分布图表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/funds/funds_update/' + Funds.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除资产分布图表
 */
Funds.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/funds/delete", function (data) {
            Feng.success("删除成功!");
            Funds.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("fundsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询资产分布图表列表
 */
Funds.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Funds.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Funds.initColumn();
    var table = new BSTable(Funds.id, "/funds/list", defaultColunms);
    table.setPaginationType("client");
    Funds.table = table.init();
});

function detail(c2) {
    var myChart = echarts.init(document.getElementById('main')); //渲染组件
    myChart.showLoading({ //加载动画
        text: '正在加载数据。。。。'
    });

    //加载数据
    jQuery.ajax({
        url: "funds/fundDIs",
        type: 'get',
        data: {coinId: c2},
        datatype: 'json',
        async: true,
        success: function (jsons) {

            if (jsons) {
                myChart.hideLoading(); //隐藏动画
                jsons = JSON.parse(jsons);
                console.info(jsons);
                var builderJson = {
                    "all": 7000000000,
                    "charts": jsons.buy,
                    "components": jsons.sale,
                    "ie": 9743
                };

                var downloadJson = jsons.buy;

                var themeJson = jsons.sale;


                var waterMarkText = '';

                var canvas = document.createElement('canvas');
                var ctx = canvas.getContext('2d');
                canvas.width = canvas.height = 100;
                ctx.textAlign = 'center';
                ctx.textBaseline = 'middle';
                ctx.globalAlpha = 0.08;
                ctx.font = '20px Microsoft Yahei';
                ctx.translate(50, 50);
                ctx.rotate(-Math.PI / 4);
                ctx.fillText(waterMarkText, 0, 0);

                option = {
                    backgroundColor: {
                        type: 'pattern',
                        image: canvas,
                        repeat: 'repeat'
                    },
                    tooltip: {},
                    title: [{
                        text: '资金分布（红色买入，黑色卖出）',
                        subtext: '总计 ' + builderJson.all,
                        x: '25%',
                        textAlign: 'center'
                    }, {
                        text: '买入',
                        subtext: '总计 ' + Object.keys(downloadJson).reduce(function (all, key) {
                            return all + downloadJson[key];
                        }, 0),
                        x: '75%',
                        textAlign: 'center'
                    }, {
                        text: '卖出',
                        subtext: '总计 ' + Object.keys(themeJson).reduce(function (all, key) {
                            return all + themeJson[key];
                        }, 0),
                        x: '75%',
                        y: '50%',
                        textAlign: 'center'
                    }],
                    grid: [{
                        top: 50,
                        width: '50%',
                        bottom: '45%',
                        left: 10,
                        containLabel: true
                    }, {
                        top: '55%',
                        width: '50%',
                        bottom: 0,
                        left: 10,
                        containLabel: true
                    }],
                    xAxis: [{
                        type: 'value',
                        max: builderJson.all,
                        splitLine: {
                            show: false
                        }
                    }, {
                        type: 'value',
                        max: builderJson.all,
                        gridIndex: 1,
                        splitLine: {
                            show: false
                        }
                    }],
                    yAxis: [{
                        type: 'category',
                        data: Object.keys(builderJson.charts),
                        axisLabel: {
                            interval: 0,
                            rotate: 30
                        },
                        splitLine: {
                            show: false
                        }
                    }, {
                        gridIndex: 1,
                        type: 'category',
                        data: Object.keys(builderJson.components),
                        axisLabel: {
                            interval: 0,
                            rotate: 30
                        },
                        splitLine: {
                            show: false
                        }
                    }],
                    series: [{
                        type: 'bar',
                        stack: 'chart',
                        z: 3,
                        label: {
                            normal: {
                                position: 'right',
                                show: true
                            }
                        },
                        data: Object.keys(builderJson.charts).map(function (key) {
                            return builderJson.charts[key];
                        })
                    }, {
                        type: 'bar',
                        stack: 'chart',
                        silent: true,
                        itemStyle: {
                            normal: {
                                color: '#eee'
                            }
                        },
                        data: Object.keys(builderJson.charts).map(function (key) {
                            return builderJson.all - builderJson.charts[key];
                        })
                    }, {
                        type: 'bar',
                        stack: 'component',
                        xAxisIndex: 1,
                        yAxisIndex: 1,
                        z: 3,
                        label: {
                            normal: {
                                position: 'right',
                                show: true
                            }
                        },
                        data: Object.keys(builderJson.components).map(function (key) {
                            return builderJson.components[key];
                        })
                    }, {
                        type: 'bar',
                        stack: 'component',
                        silent: true,
                        xAxisIndex: 1,
                        yAxisIndex: 1,
                        itemStyle: {
                            normal: {
                                color: '#eee'
                            }
                        },
                        data: Object.keys(builderJson.components).map(function (key) {
                            return builderJson.all - builderJson.components[key];
                        })
                    }, {
                        type: 'pie',
                        radius: [0, '30%'],
                        center: ['75%', '25%'],
                        data: Object.keys(downloadJson).map(function (key) {
                            return {
                                name: key.replace('.js', ''),
                                value: downloadJson[key]
                            }
                        })
                    }, {
                        type: 'pie',
                        radius: [0, '30%'],
                        center: ['75%', '75%'],
                        data: Object.keys(themeJson).map(function (key) {
                            return {
                                name: key.replace('.js', ''),
                                value: themeJson[key]
                            }
                        })
                    }]
                };
                myChart.setOption(option);
            }
        },
        error: function () {
            alert("数据加载失败！请检查数据链接是否正确");
        }
    });
}