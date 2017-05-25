/**
 * Created by xiezhenyu on 2017/5/17.
 */
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

});
