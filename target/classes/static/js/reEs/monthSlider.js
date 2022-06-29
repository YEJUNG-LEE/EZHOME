var month_inputLeft = document.getElementById("month-input-left");
var month_inputRight = document.getElementById("month-input-right");
var month_inputMax = month_inputRight.getAttribute('max');


var month_thumbLeft = document.querySelector(".monthSlider > .thumb.left");
var month_thumbRight = document.querySelector(".monthSlider > .thumb.right");
var month_range = document.querySelector(".monthSlider > .range");
var month_text_div = document.querySelector(".ReEs-navi-normal-month-select-slider-txt");

if(month_inputRight.value == month_inputMax){
  month_text_div.innerHTML = month_inputLeft.value + " - 최대";
}else{
  month_text_div.innerHTML = month_inputLeft.value + " - " + month_inputRight.value + "만원";
}

var month_setLeftValue = () => {
  var _this = month_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(month_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  month_thumbLeft.style.left = percent + "%";
  month_range.style.left = percent + "%";
  if(month_inputRight.value == month_inputMax){
    month_text_div.innerHTML = month_inputLeft.value + " - 최대";
  }else{
    month_text_div.innerHTML = month_inputLeft.value + " - " + month_inputRight.value + "만원";
  }
};

var month_setRightValue = () => {
  var _this = month_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(month_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  month_thumbRight.style.right = 100 - percent + "%";
  month_range.style.right = 100 - percent + "%";
  if(month_inputRight.value == month_inputMax){
    month_text_div.innerHTML = month_inputLeft.value + " - 최대";
  }else{
    month_text_div.innerHTML = month_inputLeft.value + " - " + month_inputRight.value + "만원";
  }
};

month_inputLeft.addEventListener("input", month_setLeftValue);
month_inputRight.addEventListener("input", month_setRightValue);

