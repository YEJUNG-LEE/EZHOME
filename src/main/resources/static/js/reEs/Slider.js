var Navi_Slider = ".ReEs-navi-category-select";
$(document).ready(function(){

    // 네비게이션의 슬라이더입니다.
    $('.ReEs-navi-font').click(function(){

        if($(this).hasClass('ReEs-NaviOn')){
            $('.ReEs-navi-font').removeClass('ReEs-NaviOn');
        }else{
            $('.ReEs-navi-font').removeClass('ReEs-NaviOn');
            $(this).addClass('ReEs-NaviOn');
        }

        // 네비게이션 슬라이더가 보여지고 있을때
        if($(Navi_Slider).css("display") == "block"){
            // 기존에 선택했던것을 다시 선택했을 경우
            if(Navi_Slider == ("." + $(this).attr("class").split(" ")[0] + "-select")){
                $(Navi_Slider).slideToggle("slow");
            }else{
                $(Navi_Slider).slideToggle("slow");
                Navi_Slider="." + $(this).attr("class").split(" ")[0] + "-select";
                $(Navi_Slider).slideToggle("slow");
            }
        }else{
            Navi_Slider="." + $(this).attr("class").split(" ")[0] + "-select";
            $(Navi_Slider).slideToggle("slow");
        }
    });

    // 조건, List 슬라이드입니다.
    $('.ReEs-leftButton').click(function(){
        $('.ReEs-rightButton').css('display', 'block')
        $('.ReEs_List-rightButton').css('display','none');
        $('.ReEs_List').css('display', 'none');
        $('.ReEs-leftButton').toggle();
        $('.ReCS').animate({width:"toggle"},600);
        window.setTimeout(function(){$('.ReCs-leftButton').css('display', 'block')}, 650);
    });
    $('.ReCs-leftButton').click(function(){
        $('.ReEs-rightButton').css('display', 'block')
        $('.ReEs_List').css('display', 'none');
        $('.ReCs-leftButton').toggle();
        $('.ReCS').animate({width:"toggle"},600);
        window.setTimeout(function(){$('.ReEs-leftButton').css('display', 'block')}, 650);
    });

    // 조건 기본 - 맞춤 선택상황입니다.
    $('.ReCs-normal').click(function(){
        $('.ReCs-normal').css('background-color', '#6c93f7')
        $('.ReCs-custom').css('background-color', '#cfcfcf')
        $('.ReCs-collection').css('display', 'none');
        $('.ReCs-div').css('display','block');
    });
    $('.ReCs-custom').click(function(){
        $('.ReCs-custom').css('background-color', '#6c93f7')
        $('.ReCs-normal').css('background-color', '#cfcfcf')
        $('.ReCs-div').css('display','none');
        $('.ReCs-collection').css('display', 'block');
    });

    // 리스트 버튼 슬라이드입니다.
    $('.ReEs-rightButton').click(function(){
        $('.ReEs-leftButton').css('display', 'block')
        $('.ReCS').css('display', 'none');
        $('.ReEs-rightButton').css('display', 'none');
        $('.ReEs_List').animate({width:"toggle"},600);
        window.setTimeout(function(){$('.ReEs_List-rightButton').css('display', 'block')}, 650);
    });
    $('.ReEs_List-rightButton').click(function(){
        $('.ReEs-leftButton').css('display', 'block')
        $('.ReCS').css('display', 'none');
        $('.ReEs_List-rightButton').css('display', 'none');
        $('.ReEs_List').animate({width:"toggle"},600);
        window.setTimeout(function(){$('.ReEs-rightButton').css('display', 'block')}, 650);
    });
});

