/**
 * Created by xiezhenyu on 2017/5/27.
 */
$(function () {
    $(".left-and-right-holder").css("display", "none");
    //为使用策略和制定策略两个按钮设定事件响应
    $("#use-strategy-button").click(function () {
        $("body").scrollTo(980,600);

    });
    $("#make-strategy-button").click(function () {
        $("body").scrollTo(980,600);
    });

    //为tab设置切换响应
    $("#use-strategy-tab").click(function () {
        $("body").scrollTo(980);
        if(!$(this).hasClass("active")){
            hideResult();
        }
        $("#make-strategy-model").css("display", "none");
        $("#main-body").css("height","270px");
        $("#use-strategy-model").css("display", "block");
        $("#use-strategy-tab").parent().addClass("active");
        $("#make-strategy-tab").parent().removeClass("active");

    });
    $("#make-strategy-tab").click(function () {
        $("body").scrollTo(980);
        if(!$(this).hasClass("active")){
            hideResult();
        }
        $("#use-strategy-model").css("display", "none");
        $("#main-body").css("height","435px");
        $("#make-strategy-model").css("display", "block");
        $("#make-strategy-tab").parent().addClass("active");
        $("#use-strategy-tab").parent().removeClass("active");

    });

    /*为中部界面的三个算法的使用策略按钮设置事件响应*/
    $("#use-strategy-button-one").click(function () {
        $("body").scrollTo(980,500);
        $("#algorithm-list").find("option[value='BP神经网络算法']").attr("selected",true);
    });
    $("#use-strategy-button-two").click(function () {
        $("body").scrollTo(980,500);
        $("#algorithm-list").find("option[value='动量交易算法']").attr("selected",true);
    });
    $("#use-strategy-button-three").click(function () {
        $("body").scrollTo(980,500);
        $("#algorithm-list").find("option[value='均值回归算法']").attr("selected",true);
    });

    /*为使用策略界面设置相应*/

    //开始回测按钮设置相应
    $("#startButtonOne").click(function () {
        $("#main-body").css("height","1055px");
        showResult();
        $("#make-strategy-model").css("display","none");
        $("#use-strategy-model").css("display","block");
        $(".left-and-right-holder").css("padding-top", "250px");
    });

    /*为制定策略界面设置相应*/
    $("#startButtonTwo").click(function () {
        $("#main-body").css("height","1200px");
        showResult();
        $("#use-strategy-model").css("display","none");
        $("#make-strategy-model").css("display","block");
        $(".left-and-right-holder").css("padding-top", "400px");
    });
});

function showResult() {
    $(".left-and-right-holder").css("display", "block");
}
function hideResult() {
    $(".left-and-right-holder").css("display", "none");
}
