/**
 * Created by xiezhenyu on 2017/5/17.
 */
$(function(){
    //为tab标签设置点击事件
    var tablist = ["#tab1", "#tab2", "#tab3", "#tab4"];
    var pagelist = ["#zixuangu-part", "#makestrategy-part", "#usestrategy-part", "#history-part"];
    function myRemoveClass(tabName) {
        for(var i = 0;i < tablist.length - 1;i++)
        {
            if(tabName != tablist[i])
            {
                $(tablist[i]).removeClass("active");
            }
        }
    }
    function showPage(pageName) {
        $(pageNum).removeClass("disappear");
        for (var i = 0;i < pagelist.length - 1;i++)
        {
            if(pagelist[i] != pageName)
            {
                $(pagelist[i]).addClass("disappear");
            }

        }
    }
    $("#tab1").click(function () {
        this.addClass("active");
        myRemoveClass("#tab1");
    });
    $("#tab2").click(function () {
        this.addClass("active");
        myRemoveClass("#tab2");
    });
    $("#tab3").click(function () {
        this.addClass("active");
        myRemoveClass("#tab3");
    });
    $("#tab4").click(function () {
        this.addClass("active");
        myRemoveClass("#tab4");
    });


});