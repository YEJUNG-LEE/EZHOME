var floor_inputLeft = document.getElementById("floor-input-left");
var floor_inputRight = document.getElementById("floor-input-right");
var floor_inputMax = floor_inputRight.getAttribute('max');


var floor_thumbLeft = document.querySelector(".floorSlider > .thumb.left");
var floor_thumbRight = document.querySelector(".floorSlider > .thumb.right");
var floor_range = document.querySelector(".floorSlider > .range");
var floor_text_div = document.querySelector(".ReEs-navi-normal-floor-select-slider-txt");

if(floor_inputRight.value == floor_inputMax){
  floor_text_div.innerHTML = floor_inputLeft.value + " - 최대";
}else{
  floor_text_div.innerHTML = floor_inputLeft.value + " - " + floor_inputRight.value + "층";
}

var floor_setLeftValue = () => {
  var _this = floor_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(floor_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  floor_thumbLeft.style.left = percent + "%";
  floor_range.style.left = percent + "%";
  if(floor_inputRight.value == floor_inputMax){
    floor_text_div.innerHTML = floor_inputLeft.value + " - 최대";
  }else{
    floor_text_div.innerHTML = floor_inputLeft.value + " - " + floor_inputRight.value + "층";
  }
};

var floor_setRightValue = () => {
  var _this = floor_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(floor_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  floor_thumbRight.style.right = 100 - percent + "%";
  floor_range.style.right = 100 - percent + "%";
  if(floor_inputRight.value == floor_inputMax){
    floor_text_div.innerHTML = floor_inputLeft.value + " - 최대";
  }else{
    floor_text_div.innerHTML = floor_inputLeft.value + " - " + floor_inputRight.value + "층";
  }
};

floor_inputLeft.addEventListener("input", floor_setLeftValue);
floor_inputRight.addEventListener("input", floor_setRightValue);

