/**
 * Created by xiaoJun on 2017/5/17.
 */


function meterChart(mycharts) {
    // var myChart = echarts.init(document.getElementById("meter"));
    window.onresize = mycharts.resize;
    option = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}分"
        },
        series: [
            {
                name: '综合评分',
                type: 'gauge',
                min: 0,
                max: 10,
                detail: {formatter:'{value}分'},
                data: [{value: 5.5, name: ''}]
            }
        ]
    };
    mycharts.setOption(option,true);
}
