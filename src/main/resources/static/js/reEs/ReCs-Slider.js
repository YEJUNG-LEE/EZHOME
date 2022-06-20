var floor_inputLeft = document.getElementById("floor-input-left");
var floor_inputRight = document.getElementById("floor-input-right");
var floor_inputMax = floor_inputRight.getAttribute('max');


var floor_thumbLeft = document.querySelector(".floorSlider > .thumb.left");
var floor_thumbRight = document.querySelector(".floorSlider > .thumb.right");
var floor_range = document.querySelector(".floorSlider > .range");
var floor_text_div = document.querySelector(".ReCs-floorSlider-txt");

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


// ============================================================================
// ============================================================================

var extent_inputLeft = document.getElementById("extent-input-left");
var extent_inputRight = document.getElementById("extent-input-right");
var extent_inputMax = extent_inputRight.getAttribute('max');


var extent_thumbLeft = document.querySelector(".extentSlider > .thumb.left");
var extent_thumbRight = document.querySelector(".extentSlider > .thumb.right");
var extent_range = document.querySelector(".extentSlider > .range");
var extent_text_div = document.querySelector(".ReCs-extentSlider-txt");

if(extent_inputRight.value == extent_inputMax){
  extent_text_div.innerHTML = extent_inputLeft.value + " - 최대";
}else{
  extent_text_div.innerHTML = extent_inputLeft.value + " - " + extent_inputRight.value + "층";
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
    extent_text_div.innerHTML = extent_inputLeft.value + " - " + extent_inputRight.value + "층";
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
    extent_text_div.innerHTML = extent_inputLeft.value + " - " + extent_inputRight.value + "층";
  }
};

extent_inputLeft.addEventListener("input", extent_setLeftValue);
extent_inputRight.addEventListener("input", extent_setRightValue);

// =======================================================================
// =========================월세슬라이드===================================
// =======================================================================


var month_inputLeft = document.getElementById("month-input-left");
var month_inputRight = document.getElementById("month-input-right");
var month_inputMax = month_inputRight.getAttribute('max');


var month_thumbLeft = document.querySelector(".monthSlider > .thumb.left");
var month_thumbRight = document.querySelector(".monthSlider > .thumb.right");
var month_range = document.querySelector(".monthSlider > .range");
var month_text_div = document.querySelector(".ReCs-monthSlider-txt");

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

// =======================================================================
// =========================관리비입니다===================================
// =======================================================================

var manage_inputLeft = document.getElementById("manage-input-left");
var manage_inputRight = document.getElementById("manage-input-right");
var manage_inputMax = manage_inputRight.getAttribute('max');


var manage_thumbLeft = document.querySelector(".manageSlider > .thumb.left");
var manage_thumbRight = document.querySelector(".manageSlider > .thumb.right");
var manage_range = document.querySelector(".manageSlider > .range");
var manage_text_div = document.querySelector(".ReCs-manageSlider-txt");

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

// =======================================================================
// =========================보증금입니다===================================
// =======================================================================


var deposit_inputLeft = document.getElementById("deposit-input-left");
var deposit_inputRight = document.getElementById("deposit-input-right");
var deposit_inputMax = deposit_inputRight.getAttribute('max');


var deposit_thumbLeft = document.querySelector(".depositSlider > .thumb.left");
var deposit_thumbRight = document.querySelector(".depositSlider > .thumb.right");
var deposit_range = document.querySelector(".depositSlider > .range");
var deposit_text_div = document.querySelector(".ReCs-depositSlider-txt");

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

