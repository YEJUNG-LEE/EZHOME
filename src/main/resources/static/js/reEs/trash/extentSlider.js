var extent_inputLeft = document.getElementById("extent-input-left");
var extent_inputRight = document.getElementById("extent-input-right");
var extent_inputMax = extent_inputRight.getAttribute('max');


var extent_thumbLeft = document.querySelector(".extentSlider > .thumb.left");
var extent_thumbRight = document.querySelector(".extentSlider > .thumb.right");
var extent_range = document.querySelector(".extentSlider > .range");
var extent_text_div = document.querySelector(".ReEs-navi-normal-extent-select-slider-txt");

if(extent_inputRight.value == extent_inputMax){
  extent_text_div.innerHTML = extent_inputLeft.value + " - 최대";
}else{
  extent_text_div.innerHTML = extent_inputLeft.value + " - " + extent_inputRight.value + "평";
}

var extent_setLeftValue = () => {
  var _this = extent_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(extent_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  extent_thumbLeft.style.left = percent + "%";
  extent_range.style.left = percent + "%";
  if(extent_inputRight.value == extent_inputMax){
    extent_text_div.innerHTML = extent_inputLeft.value + " - 최대";
  }else{
    extent_text_div.innerHTML = extent_inputLeft.value + " - " + extent_inputRight.value + "평";
  }
};

var extent_setRightValue = () => {
  var _this = extent_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(extent_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  extent_thumbRight.style.right = 100 - percent + "%";
  extent_range.style.right = 100 - percent + "%";
  if(extent_inputRight.value == extent_inputMax){
    extent_text_div.innerHTML = extent_inputLeft.value + " - 최대";
  }else{
    extent_text_div.innerHTML = extent_inputLeft.value + " - " + extent_inputRight.value + "평";
  }
};

extent_inputLeft.addEventListener("input", extent_setLeftValue);
extent_inputRight.addEventListener("input", extent_setRightValue);

