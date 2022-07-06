/* ReItemForm.js */
/* 맞춤, 카테고리 항목 클릭시 bg컬러 변경 */
$(document).ready(function () {
            var menu_offset = $('.main-menu').offset();  //offset() : 반환하는 객체는 left와 top 속성제공

            $(window).scroll(function () {
                if ($(window).scrollTop() > menu_offset.top) {
                    $('.main-menu').addClass('menu-fixed');
                } else {
                    $('.main-menu').removeClass('menu-fixed');
                }
            });

            console.log(typeof($('input[value="true"]')));
            $('input[value="true"]').parent().css({'background-color':'#52b0fb', 'color':'white'});

        });

