/**
 * Created by xiaoJun on 2017/6/1.
 */

var stockNameArray = [];  //保存对比股票名字的数组

$(function () {
    //点击按钮切换热门股票和最近访问
    $("#hotCompareStockButton").click(function () {
        $(this).addClass("hotStockBottomBorder");
        $(this).siblings().removeClass("hotStockBottomBorder");
        $("#hotCompareStock").removeClass("displayNone");
        $("#hotBrowseStock").addClass("displayNone");
    });

    $("#browseCompareStockButton").click(function () {
        $(this).addClass("hotStockBottomBorder");
        $(this).siblings().removeClass("hotStockBottomBorder");
        $("#hotCompareStock").addClass("displayNone");
        $("#hotBrowseStock").removeClass("displayNone");
    });

    //点击添加按钮，将对应股票添加到对比列表中
    $(".addCompareStockButton").click(function () {
        var node = $(this).parent();
        var stockName = node.siblings().first().children().first().text();
        if(isRepeat(stockName)){
            setTimeout(slidein(2,"股票已在对比列表中"),1800);
        }else{
            if(stockNameArray.length < 5){
                stockNameArray.push(stockName);
                addNodeToStockContainer(stockName);
            }else{
                setTimeout(slidein(2,"最多对比五只股票"),1800);
            }
        }
    });

    //点击删除按钮，将对应股票从对比列表中删除
    $(".stockCardDelete").click(function () {
        var stockName = $(this).siblings().first().text();
        stockNameArray.splice(indexOf(stockName),1);
        $(this).parent().remove();
    });

    //点击清空按钮，清空对比列表
    $("#deleteAllButton").click(function () {
        stockNameArray.splice(0,stockNameArray.length);
        $("#stockContainer").empty();
        slidein(0,"已清空对比股票")
    });

    $("#compareButton").click(function () {
        fillInTable(stockNameArray);
        lineChart(stockNameArray);
    });
})

/**
 * 创建节点并添加到对比股票容器中
 * @param stockName 股票名称
 */
function addNodeToStockContainer(stockName) {
    var $li = $("<li class='stockCard'></li>");
    var $span = $("<span class='stockCardName'>"+stockName+"</span>");
    var $button = $("<button class='stockCardDelete'><i class='fa fa-times-circle' aria-hidden='true'></i></button>");
    $button.click(function () {
        var stockName = $(this).siblings().first().text();
        stockNameArray.splice(indexOf(stockName),1);
        $(this).parent().remove();
    });
    $li.append($span);
    $li.append($button);
    $("#stockContainer").append($li);
}

/**
 * 判断添加对比时，股票是否已经在对比列表中
 * @param stockName
 */
function isRepeat(stockName) {
    for(var i = 0; i < stockNameArray.length; i++){
        if(stockNameArray[i] == stockName){
            return true;
        }
    }
    return false;
}

/**
 * 获取对应元素在数组中的下标
 * @param val 搜索的元素
 */
function indexOf(val) {
    for(var i = 0; i < stockNameArray.length; i++){
        if(stockNameArray[i] == val){
            return i;
    }
    }
    return -1;
}

/**
 * 将对比的股票信息填写到股票表格中
 * @param stockNameArray 对比的股票名称
 */
function fillInTable(stockNameArray) {
    for(var i = 0; i < stockNameArray.length; i++){
        var $a = $("<a>"+stockNameArray[i]+"</a>");
        $("#compareTableHead th:eq("+(i+1)+")").text("");
        $("#compareTableHead th:eq("+(i+1)+")").append($a);
    }
}