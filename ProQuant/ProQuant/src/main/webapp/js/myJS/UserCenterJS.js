/**
 * Created by xiezhenyu on 2017/5/17.
 */
//全局变量，选中的第一行，选中的最后一行
var firstRowIndex, lastRowIndex, currentEle;


$(function(){
    //为tab标签设置点击事件
    var tablist = ["#tab1", "#tab2", "#tab3", "#tab4"];
    var pagelist = ["#zixuangu-part", "#makestrategy-part", "#usestrategy-part", "#history-part"];
    function myRemoveOtherClass(tabName) {
        for(var i = 0;i < tablist.length;i++)
        {
            if(tabName != tablist[i])
            {
                $(tablist[i]).removeClass("active");
            }
        }
    }
    function showPage(pageName) {
        $(pageName).removeClass("disappear");
        for (var i = 0;i < pagelist.length;i++)
        {
            if(pagelist[i] != pageName)
            {
                $(pagelist[i]).addClass("disappear");
            }

        }
    }
    $("#tab1").click(function () {
        $(this).addClass("active");
        myRemoveOtherClass("#tab1");
        $("#zixuangu-part").removeClass("disappear");
        showPage("#zixuangu-part");
    });
    $("#tab2").click(function () {
        $(this).addClass("active");
        myRemoveOtherClass("#tab2");
        $("#makestrategy-part").removeClass("disappear");
        showPage("#makestrategy-part");
    });
    $("#tab3").click(function () {
        $(this).addClass("active");
        myRemoveOtherClass("#tab3");
        $("#usestrategy-part").removeClass("disappear");
        showPage("#usestrategy-part");
    });
    $("#tab4").click(function () {
        $(this).addClass("active");
        myRemoveOtherClass("#tab4");
        $("#history-part").removeClass("disappear");
        showPage("#history-part");
    });

    //实现提示框拖动的效果
    $("#attentionDialog")[0].onmousedown = fnDown;
    $("#confirm-button").click();
    $("#cancel-button").click(function () {
        $("#attentionDialog")[0].style.display = "none";
        deSelectTableRows(currentEle, firstRowIndex, lastRowIndex);
    })

    //获取行的高度
    // var rowHeight = $("tr:first").height();
    // alert(rowHeight);
    //获取鼠标按下和弹起时各自的位置

    // $("tr").click(function () {
    //     alert("sadas");
    // });
    // $("table")[0].onmousedown = getY1;


    $("tr").mousedown(function () {
        firstRowIndex = $(this).index();
    });
    $("tr").mouseup(function () {
        lastRowIndex = $(this).index();
        currentEle = $(this);
        selectRows(currentEle, firstRowIndex, lastRowIndex);
    });
    // var trList = $("tr");
    // for(var i = 0;i < trList.length;i++){
    //     trList[i].onmousedown = tableSelect($(this));
    // }
});

function fnDown(event) {
    event = event || window.event;
    var oDrag = $("#attentionDialog").get(0),
        //光标按下时，光标距离面板左边的距离
        disX = event.clientX - oDrag.offsetLeft,
        //光标按下时，光标距离面板上边的距离
        disY = event.clientY - oDrag.offsetTop;
    //移动
    document.onmousemove = function (event) {
        event = event || window.event;
        fnMove(event, disX, disY);
    }
    //释放鼠标
    document.onmouseup = function () {
        document.onmousemove = null;
        //把本身时间也卸载掉
        document.onmouseup = null;
    }
}


function fnMove(e, posX, posY) {
    var oDrag = $("#attentionDialog").get(0),
        l = e.clientX - posX,
        t = e.clientY - posY,
        //获取浏览器窗口的宽度和高度
        winWidth = document.documentElement.clientWidth || document.body.clientWidth,
        winHeight = document.documentElement.clientHeight || document.body.clientHeight,
        //div.offsetWidth获取容器的宽度
        maxWidth = winWidth - oDrag.offsetWidth,
        maxHeight = winHeight - oDrag.offsetHeight;
    //最后确定容器位置的是left和top
    if(l < 0){
        l = 0;
    }else if(l > maxWidth){
        l = maxWidth;
    }
    if(t < 0){
        t = 0;
    }else if(t > maxHeight){
        t = maxHeight;
    }
    oDrag.style.left = l + 'px';
    oDrag.style.top = t + 'px';
}
// var Y1, Y2;
// function getY1(event) {
//     alert("getY1");
//     event = event || window.event;
//     Y1 = event.clientY;
// }
// function getY2(event) {
//     alert("getY2");
//     event = event || window.event;
//     Y2 = event.clientY;
//     document.write(Y1 + "<br>");
//     document.write(Y2 + "<br>");
//     document.write(Y2 - Y1);
// }

function selectRows(ele, frIndex, lrIndex) {
    //要用父级元素获得全部的行，在选中其中的某些行
    var tableRowList = ele[0].parentNode.rows;
    for(var i = 0;i < tableRowList.length;i++){
        if((i >= frIndex)&&(i <= lrIndex)&&((lrIndex - frIndex)>1)){
            $(tableRowList[i]).addClass("selectedClass")
        }
    }
    if((lrIndex - frIndex)>1){
        // setTimeout(showDialog, 200);
        showDialog();
    }

    // showDialog();
}
function deSelectTableRows(ele, frIndex, lrIndex) {
    //要用父级元素获得全部的行，在选中其中的某些行
    var tableRowList = ele[0].parentNode.rows;
    for(var i = 0;i < tableRowList.length;i++){
        if((i >= frIndex)&&(i <= lrIndex)){
            $(tableRowList[i]).removeClass("selectedClass")
        }
    }
    setTimeout(hideDialog, 200);
}

function showDialog() {
    $("#attentionDialog").fadeIn();
    // $("#attentionDialog")[0].style.display = "block";
}
function hideDialog() {

    $("#attentionDialog").fadeOut();
    // $("#attentionDialog")[0].style.display = "none";
}