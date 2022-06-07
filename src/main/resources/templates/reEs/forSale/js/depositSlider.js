var inputLeft = document.getElementById("floor-input-left");
var inputRight = document.getElementById("floor-input-right");
var inputMax = inputRight.getAttribute('max');


var thumbLeft = document.querySelector(".floorSlider > .thumb.left");
var thumbRight = document.querySelector(".floorSlider > .thumb.right");
var range = document.querySelector(".floorSlider > .range");
var text_div = document.querySelector(".ReEs-navi-normal-floor-select-slider-txt");

if(inputRight.value == inputMax){
  text_div.innerHTML = inputLeft.value + " - 최대";
}else{
  text_div.innerHTML = inputLeft.value + " - " + inputRight.value + "층";
}

var setLeftValue = () => {
  var _this = inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  thumbLeft.style.left = percent + "%";
  range.style.left = percent + "%";
  if(inputRight.value == inputMax){
    text_div.innerHTML = inputLeft.value + " - 최대";
  }else{
    text_div.innerHTML = inputLeft.value + " - " + inputRight.value + "층";
  }
};

var setRightValue = () => {
  var _this = inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  thumbRight.style.right = 100 - percent + "%";
  range.style.right = 100 - percent + "%";
  if(inputRight.value == inputMax){
    text_div.innerHTML = inputLeft.value + " - 최대";
  }else{
    text_div.innerHTML = inputLeft.value + " - " + inputRight.value + "층";
  }
};

inputLeft.addEventListener("input", setLeftValue);
inputRight.addEventListener("input", setRightValue);

