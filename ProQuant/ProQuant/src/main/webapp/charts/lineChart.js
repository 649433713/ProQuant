/**
 * Created by xiaoJun on 2017/6/1.
 */

var xData = ['09:00','09:01','09:02','09:03','09:04','09:05','09:06','09:07','09:08','09:09','09:10','09:11','09:12','09:13','09:14','09:15'
    ,'09:16','09:17','09:18','09:19','09:20','09:21','09:22','09:23','09:24','09:25','09:26','09:27','09:28','09:29','09:30','09:31','09:32'
    ,'09:33','09:34','09:35','09:36','09:37','09:38','09:39','09:40','09:41','09:42','09:43','09:44','09:45','09:46','09:47','09:48','09:49'
    ,'09:50','09:51','09:52','09:53','09:54','09:55','09:56','09:57','09:58','09:59'];

var yData3 = [];
for(var i = 0; i < 60; i++){
    yData3[i] = Math.random()*40;
}

var yData4 = [];
for(var i = 0; i < 60; i++){
    yData4[i] = Math.random()*40;
}

function lineChart(stockNameArray) {

    var chart = echarts.init(document.getElementById("compareChartContainer"));
    window.onresize = chart.resize;
    // alert(stockNameArray.length);
    var yData = [];
    for(var i = 0; i < stockNameArray.length; i++){
        var yData1 = [];
        for(var j = 0; j < 60; j++){
            yData1[j] =Math.round(Math.random()*40);
        };
        yData[i] = yData1;
    }

    option = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:stockNameArray
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : xData
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} °C'
                }
            }
        ],
        // series : [
        //     {
        //         name:'最高气温',
        //         type:'line',
        //         data:yData1,
        //
        //     },
        //     {
        //         name:'最低气温',
        //         type:'line',
        //         data:yData3,
        //
        //     }
        // ]
    };

    var seriesData = [];
    for(var i = 0; i < stockNameArray.length; i++){
        var items = {
            name:stockNameArray[i],
            type:'line',
            data:yData[i],
            smooth:true,
            lineStyle:{
                normal:{
                    width:1
                }
            }
        };
        seriesData.push(items);
    }
    // option.legend.data = legendData;

    option.series = seriesData;
    chart.setOption(option);
}
