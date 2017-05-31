/**
 * Created by xiaoJun on 2017/5/13.
 */

$(function () {
    //设置搜索框未获得焦点时长度缩小，获得焦点时长度变大
    $("#searchInput").blur(function (){
        if($(this).val() == "" || (this).val() == null){
            $(this).attr("placeholder","搜索");
            $(this).animate({width:"35px"},400);
        }
    }).focus(function () {
        $(this).animate({width:"120px"},400);
        $(this).attr("placeholder","请输入股票代码");
    });

    //为导航栏的点击添加监听
    $("#navigation li").click(function () {
        $(this).addClass("active");
        $(this).siblings().removeClass("active");
    });

    // document.querySelector('.cont_centrar').className = "cont_centrar cent_active";

    //点击登陆按钮，显示登陆弹出框
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

function sign_up(){
    var inputs = document.querySelectorAll('.input_form_sign');
    document.querySelectorAll('.ul_tabs > li')[0].className="";
    document.querySelectorAll('.ul_tabs > li')[1].className="active";

    for(var i = 0; i < inputs.length ; i++  ) {
        if(i == 2  ){

        }else{
            document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_block";
        }
    }

    setTimeout( function(){
        for(var d = 0; d < inputs.length ; d++  ) {
            document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign d_block active_inp";
        }
    },100 );

    document.querySelector('.link_forgot_pass').style.opacity = "0";
    document.querySelector('.link_forgot_pass').style.top = "-5px";
    document.querySelector('.btn_sign').innerHTML = "SIGN UP";
    setTimeout(function(){
        document.querySelector('.terms_and_cons').style.opacity = "1";
        document.querySelector('.terms_and_cons').style.top = "5px";
    },500);
    setTimeout(function(){
        document.querySelector('.link_forgot_pass').className = "link_forgot_pass d_none";
        document.querySelector('.terms_and_cons').className = "terms_and_cons d_block";
    },200);

}



function sign_in(){
    var inputs = document.querySelectorAll('.input_form_sign');
    document.querySelectorAll('.ul_tabs > li')[0].className = "active";
    document.querySelectorAll('.ul_tabs > li')[1].className = "";

    for(var i = 0; i < inputs.length ; i++  ) {
        switch(i) {
            case 1:
                console.log(inputs[i].name);
                break;
            case 2:
                console.log(inputs[i].name);
            default:
                document.querySelectorAll('.input_form_sign')[i].className = "input_form_sign d_block";
        }
    }

    setTimeout( function(){
        for(var d = 0; d < inputs.length ; d++  ) {
            switch(d) {
                case 1:
                    break;
                case 2:

                default:
                    document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign d_block";
                    document.querySelectorAll('.input_form_sign')[2].className = "input_form_sign d_block active_inp";
            }
        }
    },100 );

    document.querySelector('.terms_and_cons').style.opacity = "0";
    document.querySelector('.terms_and_cons').style.top = "-5px";

    setTimeout(function(){
        document.querySelector('.terms_and_cons').className = "terms_and_cons d_none";
        document.querySelector('.link_forgot_pass').className = "link_forgot_pass d_block";

    },300);

    setTimeout(function(){

        document.querySelector('.link_forgot_pass').style.opacity = "1";
        document.querySelector('.link_forgot_pass').style.top = "5px";
        for(var d = 0; d < inputs.length ; d++  ) {
            switch(d) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    document.querySelectorAll('.input_form_sign')[d].className = "input_form_sign";
            }
        }
    },700);
    document.querySelector('.btn_sign').innerHTML = "SIGN IN";
}







