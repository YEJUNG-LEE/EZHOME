/* main.js */

$(function(){

var $window = $(window),
    $mainHeader = $('header'),
    $defultLogo = '/img/logo01.png' ,
    $smallLogo = '/img/logo03.png' ;

    $window.scroll(function(){
        /* 스크롤이 100 보다 커지면 */
        if($(this).scrollTop() > 250){
            /* 메인헤더에 슈랭크가 없으면 추가 하겠다 */
            if(!$mainHeader.hasClass('shrink')){
                $mainHeader.addClass('shrink') ;
                /* 스위치이미지 함수, 이미지체인지 
                100보다 커지면 스몰로고를 보여줘라 */
                switchImages($smallLogo);
            }
        } else {
            /* 메인헤더에 슈랭크가 있으면  빼겠다 */
            if($mainHeader.hasClass('shrink')){
                $mainHeader.removeClass('shrink') ;
                switchImages($defultLogo);
            }
        }
    });

    // switchImages 함수
    function switchImages(newPath){
        var $logo = $('#logo') ;
        // fadeOut으로 로고가 3초에 걸처 사라지고 function(){} 새로시작
        $logo.fadeOut(300, function(){
            // var c =  A.attr('src') ;
            // A.attr('src', 'c');
            $logo.attr('src', newPath);
            $logo.fadeIn(300);
        }); // jquery fadeOut
    }

    // 검색 조건 탭( 임시 수정해야함 )
    $(".condition01").click(function(){ 
        $("#condition01-select").addClass("on"); 
    }); 

    // 챗봇 
    $(".cb-click-img").click(function(){
        $(".cb-div-wrap").slideToggle();
    })
    $("#cb-btn-can").click(function(){
        $(".cb-div-wrap").slideToggle();
    })
    
    
});
