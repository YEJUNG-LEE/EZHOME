$(document).ready(function(){
    $(".ReEs-custom-select-button").click(function(){
        tog($(this));
    });
    $(".ReEs-category-select-button").click(function(){
        tog($(this));
    });

    $('.ReEs-custom-select-AllOn').click(function(){
       allOn(".ReEs-custom-select-button");
    });
    $('.ReEs-custom-select-AllOff').click(function(){
        allOff(".ReEs-custom-select-button");
    });
    $('.ReEs-category-select-AllOn').click(function(){
        allOn(".ReEs-category-select-button");
     });
     $('.ReEs-category-select-AllOff').click(function(){
         allOff(".ReEs-category-select-button");
     });
     
});
    
function tog(sel){
    $(sel).toggleClass("ReEs-on");
}
function allOn(sel){
    $(sel).addClass("ReEs-on");
}

function allOff(sel){
    $(sel).removeClass("ReEs-on");
}


