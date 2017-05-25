/**
 * Created by xiaoJun on 2017/5/13.
 */

$(function () {
    $("#searchInput").blur(function (){
        if($(this).val() == "" || (this).val() == null){
            $(this).attr("placeholder","搜索");
            $(this).animate({width:"35px"},400);
        }
    }).focus(function () {
        $(this).animate({width:"120px"},400);
        $(this).attr("placeholder","请输入股票代码");
    });

    $("#navigation li").click(function () {
        $(this).addClass("active");
        $(this).siblings().removeClass("active");
    });


    var $loginMsg = $('.loginMsg'),
        $login = $('.login'),
        $signupMsg = $('.signupMsg'),
        $signup = $('.signup'),
        $frontbox = $('.frontbox');

    $('#switch1').on('click', function() {

        $loginMsg.toggleClass("visibility");
        $frontbox.addClass("moving");
        $signupMsg.toggleClass("visibility");

        $signup.toggleClass('hide');
        $login.toggleClass('hide');
        $(this).attr("disabled",true);
        $("#switch2").attr("disabled",false);

    })

    $('#switch2').on('click', function() {

        $loginMsg.toggleClass("visibility");
        $frontbox.removeClass("moving");
        $signupMsg.toggleClass("visibility");

        $signup.toggleClass('hide');
        $login.toggleClass('hide');
        $(this).attr("disabled",true);
        $("#switch1").attr("disabled",false);
    })

    setTimeout(function(){
        $('#switch1').click()
    },1000)

    setTimeout(function(){
        $('#switch2').click()
    },3000)

    $("#loginButton").click(function () {
        $("#loginModal").modal("show");
    })

    $("#searchText button").click(function () {
        setTimeout(slidein(2,"请输入股票名称"),1800);
    })

})

function slidein(index, remindness) {

    var pics = ["green_pic", "red_pic", "yellow_pic"];
    var words = ["green_word", "red_word", "yellow_word"];

    document.getElementById("pic_div").setAttribute("class", pics[index]);
    document.getElementById("remind").setAttribute("class", words[index]);
    document.getElementById("remind").innerHTML = remindness;

    if (remindness.length < 8) {
        document.getElementById("remind").style.marginLeft = "65px";
    } else if(remindness.length > 8) {
        document.getElementById("remind").style.fontSize = "15px";
        document.getElementById("remind").style.marginLeft = "55px";
    }

    window.location.href = '#toaster';
    setTimeout("window.location.href='#toaster_close'", 1500);
}



