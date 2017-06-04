/**
 * Created by xiaoJun on 2017/5/16.
 */

// import * as temp from '../charts/meterChart';
var buy_dialogIsShowed = false;

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

    //点击买入按钮，显示买入提示框
    $("#buyButton").click(function (e) {
        //edit_dialogIsShowed = true;
        if(buy_dialogIsShowed){

        }else{
            e.stopPropagation();
            $(".buy-page-holder").removeClass("disappear");
            showPromptDoalog($(this));
            buy_dialogIsShowed = true;
        }
    });

    //当浏览器大小改变时，调整买入提示框的位置
    window.onresize = function () {
        if(!$(".buy-page-holder").hasClass("disappear")){
            // alert($("#buyButton").offset().left);
            showPromptDoalog($("#buyButton"));
        }
    }

    //点击除买入提示框以外的提示框时，关闭提示框
    $(document).click(function (e) {
        // e.stopPropagation();
        e = window.event || e;
        var target = e.srcElement || e.target;
        if(buy_dialogIsShowed && (!$(target).is(".buy-page-holder, .buy-page-holder *"))){
            $(".buy-page-holder").addClass("disappear");
            buy_dialogIsShowed = false;
        }
    });


})

