var Navi_Slider = ".ReEs-navi-category-select";
$(document).ready(function(){
    $('.ReEs-navi-font').click(function(){

        if($(this).hasClass('ReEs-NaviOn')){
            $('.ReEs-navi-font').removeClass('ReEs-NaviOn');
        }else{
            $('.ReEs-navi-font').removeClass('ReEs-NaviOn');
            $(this).addClass('ReEs-NaviOn');
        }

        if(!($(Navi_Slider).css("display") == "none")){
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
});

