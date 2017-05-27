/**
 * Created by xiaoJun on 2017/5/25.
 */

function areaChart(mychart,xData,yData) {


    window.onresize = mychart.resize;

    option = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['意向','预购','成交']
        },
        calculable : true,
        grid:{
            x:0,
            x2:0,
            y:0,
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : xData
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                type:'line',
                smooth:true,
                itemStyle: {
                    normal: {
                        color: "#407FCE",
                        areaStyle: {
                            color: "#CFE2F3"
                            // type: 'default'
                        },
                        lineStyle:{
                            color:"#407FCE"
                        }
                    }
                },
                data:yData,
                markLine : {
                    symbol: ['none', 'none'],
                    data : [
                        {type : 'average', name: '平均值'}
                    ],
                    label:{
                        normal:{
                            position:"middle",
                            color: {
                                type: 'radial',
                                x: 0.5,
                                y: 0.5,
                                r: 0.5,
                                colorStops: [{
                                    offset: 0, color: 'red' // 0% 处的颜色
                                }, {
                                    offset: 1, color: 'blue' // 100% 处的颜色
                                }],
                                globalCoord: false // 缺省为 false
                            }
                        }
                    },
                    lineStyle:{
                        normal:{
                            color:"#D75442",
                            type:'dashed'
                        }
                    }
                }
            }
        ]
    };

    mychart.setOption(option);
}
