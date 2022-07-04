/* ReItemForm.js */
/* 맞춤, 카테고리 항목 클릭시 bg컬러 변경 */
$(document).ready(function(){
    console.log(typeof($('input[value="true"]')));
    $('input[value="true"]').parent().css({'background-color':'#52b0fb', 'color':'white'});

    $('.ReCs-button').click(function(){
    var tagId = $(this).attr("id");

    console.log(tagId);

    var values = $('input[name=' + tagId + ']').attr('value');

    if(values == 'false'){
        $(this).css({'background-color':'#52b0fb', 'color':'white'});
        $('input[name=' + tagId + ']').attr('value', 'true');

    }else{
        $(this).css({'background-color':'#FFFFFF', 'color':'#d1d1d1'});
        $('input[name=' + tagId + ']').attr('value', 'false');

    }
        values = $('input[name=' + tagId + ']').attr('value');
        console.log(values);

    });
});
