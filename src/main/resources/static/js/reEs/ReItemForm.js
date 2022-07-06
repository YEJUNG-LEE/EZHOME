/* ReItemForm.js */
/* 맞춤, 카테고리 항목 클릭시 bg컬러 변경 */
$(document).ready(function () {
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
             $('.ReCs-buttons').click(function(){
                var tagId = $(this).attr("id");
                var tagName = $(this).parent().attr("id");
                console.log(tagId);
                $('input[name=' + tagName + ']').attr('value', tagId);
                $(this).css({'background-color':'#0081cc', 'color':'white'});
                $(this).siblings().css({'background-color':'#b8b7bb', 'color':'#858484'});
                values = $('input[name=' + tagName + ']').attr('value');
                console.log(tagName + " : " + values);
            })
        });

