var manage_inputLeft = document.getElementById("manage-input-left");
var manage_inputRight = document.getElementById("manage-input-right");
var manage_inputMax = manage_inputRight.getAttribute('max');


var manage_thumbLeft = document.querySelector(".manageSlider > .thumb.left");
var manage_thumbRight = document.querySelector(".manageSlider > .thumb.right");
var manage_range = document.querySelector(".manageSlider > .range");
var manage_text_div = document.querySelector(".ReEs-navi-normal-manage-select-slider-txt");

if(manage_inputRight.value == manage_inputMax){
  manage_text_div.innerHTML = manage_inputLeft.value + " - 최대";
}else{
  manage_text_div.innerHTML = manage_inputLeft.value + " - " + manage_inputRight.value + "만원";
}

var manage_setLeftValue = () => {
  var _this = manage_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(manage_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  manage_thumbLeft.style.left = percent + "%";
  manage_range.style.left = percent + "%";
  if(manage_inputRight.value == manage_inputMax){
    manage_text_div.innerHTML = manage_inputLeft.value + " - 최대";
  }else{
    manage_text_div.innerHTML = manage_inputLeft.value + " - " + manage_inputRight.value + "만원";
  }
};

var manage_setRightValue = () => {
  var _this = manage_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(manage_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  manage_thumbRight.style.right = 100 - percent + "%";
  manage_range.style.right = 100 - percent + "%";
  if(manage_inputRight.value == manage_inputMax){
    manage_text_div.innerHTML = manage_inputLeft.value + " - 최대";
  }else{
    manage_text_div.innerHTML = manage_inputLeft.value + " - " + manage_inputRight.value + "만원";
  }
};

manage_inputLeft.addEventListener("input", manage_setLeftValue);
manage_inputRight.addEventListener("input", manage_setRightValue);

