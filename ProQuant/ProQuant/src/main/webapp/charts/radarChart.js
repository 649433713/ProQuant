/**
 * Created by xiaoJun on 2017/5/17.
 */

function radarChart() {
    var myChart = echarts.init(document.getElementById("radar"));
    window.onresize = myChart.resize;
    option = {
        title: {
            // text: '基础雷达图'
        },
        // legend: {
        //     data: ['预算分配（Allocated Budget）', '实际开销（Actual Spending）']
        // },
        radar: {
            // shape: 'circle',
            indicator: [
                { name: '技术', max: 10},
                { name: '资金', max: 10},
                { name: '消息', max: 10},
                { name: '行业', max: 10},
                { name: '基本', max: 10},
            ]
        },
        series: [{
            type: 'radar',
            // areaStyle: {normal: {}},
            label: {
                normal: {
                    show: true,
                    formatter:function(params) {
                        return params.value;
                    }
                }
            },
            data : [
                {
                    value : [7.60, 4.80, 5.50, 2.40, 4.80],
                    name : '预算分配（Allocated Budget）'
                }
            ]
        }]
    };
    myChart.setOption(option);
}

radarChart();