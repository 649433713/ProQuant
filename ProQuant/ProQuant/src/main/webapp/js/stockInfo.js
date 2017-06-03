/**
 * Created by xiaoJun on 2017/5/16.
 */

// import * as temp from '../charts/meterChart';

$(function () {
    $("#kLine div ul li").click(function () {
        $(this).addClass("blueBackground");
        $(this).siblings().removeClass("blueBackground");
    });
    var myChart = echarts.init(document.getElementById("meter"));
    meterChart(myChart);
    var mycharts = echarts.init(document.getElementById("main"));
    kLine(mycharts);
    $("#time").click(function () {
        meterChart(mycharts);
    });
    $("#dayLine").click(function () {
        kLine(mycharts);
    });
    $("#weekLine").click(function () {

    });


    $("#buyButton").click(function (e) {
        //edit_dialogIsShowed = true;
        e.stopPropagation();
        $(".buy-page-holder").removeClass("disappear");
        showPromptDoalog($(this));
    });

})