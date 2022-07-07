var deposit_inputLeft = document.getElementById("deposit-input-left");
var deposit_inputRight = document.getElementById("deposit-input-right");
var deposit_inputMax = deposit_inputRight.getAttribute('max');


var deposit_thumbLeft = document.querySelector(".depositSlider > .thumb.left");
var deposit_thumbRight = document.querySelector(".depositSlider > .thumb.right");
var deposit_range = document.querySelector(".depositSlider > .range");
var deposit_text_div = document.querySelector(".ReEs-navi-normal-deposit-select-slider-txt");

if(deposit_inputRight.value == deposit_inputMax){
  deposit_text_div.innerHTML = deposit_inputLeft.value + " - 최대";
}else{
  deposit_text_div.innerHTML = deposit_inputLeft.value + " - " + deposit_inputRight.value + "만원";
}

var deposit_setLeftValue = () => {
  var _this = deposit_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(deposit_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  deposit_thumbLeft.style.left = percent + "%";
  deposit_range.style.left = percent + "%";
  if(deposit_inputRight.value == deposit_inputMax){
    deposit_text_div.innerHTML = deposit_inputLeft.value + " - 최대";
  }else{
    deposit_text_div.innerHTML = deposit_inputLeft.value + " - " + deposit_inputRight.value + "만원";
  }
};

var deposit_setRightValue = () => {
  var _this = deposit_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(deposit_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  deposit_thumbRight.style.right = 100 - percent + "%";
  deposit_range.style.right = 100 - percent + "%";
  if(deposit_inputRight.value == deposit_inputMax){
    deposit_text_div.innerHTML = deposit_inputLeft.value + " - 최대";
  }else{
    deposit_text_div.innerHTML = deposit_inputLeft.value + " - " + deposit_inputRight.value + "만원";
  }
};

deposit_inputLeft.addEventListener("input", deposit_setLeftValue);
deposit_inputRight.addEventListener("input", deposit_setRightValue);

