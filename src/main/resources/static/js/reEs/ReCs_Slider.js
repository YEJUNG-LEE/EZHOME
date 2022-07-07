// 초기화 세팅
$(document).ready(function(){
  cs_floor_setLeftValue();
  cs_floor_setRightValue();
  cs_extent_setLeftValue();
  cs_extent_setRightValue();
  cs_month_setLeftValue();
  cs_month_setRightValue();
  cs_manage_setLeftValue();
  cs_manage_setRightValue();
  cs_deposit_setLeftValue();
  cs_deposit_setRightValue();
  cs_trade_setLeftValue();
  cs_trade_setRightValue();
})


var cs_floor_inputLeft = document.getElementById("cs-floor-input-left");
var cs_floor_inputRight = document.getElementById("cs-floor-input-right");
var cs_floor_inputMax = cs_floor_inputRight.getAttribute('max');


var cs_floor_thumbLeft = document.querySelector(".cs-floorSlider > .thumb.left");
var cs_floor_thumbRight = document.querySelector(".cs-floorSlider > .thumb.right");
var cs_floor_range = document.querySelector(".cs-floorSlider > .range");
var cs_floor_text_div = document.querySelector(".ReCs-floorSlider-txt");

if(cs_floor_inputRight.value == cs_floor_inputMax){
  cs_floor_text_div.innerHTML = cs_floor_inputLeft.value + " - 최대";
}else{
  cs_floor_text_div.innerHTML = cs_floor_inputLeft.value + " - " + cs_floor_inputRight.value + "층";
}

var cs_floor_setLeftValue = () => {
  var _this = cs_floor_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(cs_floor_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_floor_thumbLeft.style.left = percent + "%";
  cs_floor_range.style.left = percent + "%";
  if(cs_floor_inputRight.value == cs_floor_inputMax){
    cs_floor_text_div.innerHTML = cs_floor_inputLeft.value + " - 최대";
  }else{
    cs_floor_text_div.innerHTML = cs_floor_inputLeft.value + " - " + cs_floor_inputRight.value + "층";
  }
};

var cs_floor_setRightValue = () => {
  var _this = cs_floor_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];

  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(cs_floor_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_floor_thumbRight.style.right = 100 - percent + "%";
  cs_floor_range.style.right = 100 - percent + "%";
  if(cs_floor_inputRight.value == cs_floor_inputMax){
    cs_floor_text_div.innerHTML = cs_floor_inputLeft.value + " - 최대";
  }else{
    cs_floor_text_div.innerHTML = cs_floor_inputLeft.value + " - " + cs_floor_inputRight.value + "층";
  }
};

cs_floor_inputLeft.addEventListener("input", cs_floor_setLeftValue);
cs_floor_inputRight.addEventListener("input", cs_floor_setRightValue);


// ============================================================================
// ============================================================================

var cs_extent_inputLeft = document.getElementById("cs-extent-input-left");
var cs_extent_inputRight = document.getElementById("cs-extent-input-right");
var cs_extent_inputMax = cs_extent_inputRight.getAttribute('max');


var cs_extent_thumbLeft = document.querySelector(".cs-extentSlider > .thumb.left");
var cs_extent_thumbRight = document.querySelector(".cs-extentSlider > .thumb.right");
var cs_extent_range = document.querySelector(".cs-extentSlider > .range");
var cs_extent_text_div = document.querySelector(".ReCs-extentSlider-txt");

if(cs_extent_inputRight.value == cs_extent_inputMax){
  cs_extent_text_div.innerHTML = cs_extent_inputLeft.value + " - 최대";
}else{
  cs_extent_text_div.innerHTML = cs_extent_inputLeft.value + " - " + cs_extent_inputRight.value + "평";
}

var cs_extent_setLeftValue = () => {
  var _this = cs_extent_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(cs_extent_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_extent_thumbLeft.style.left = percent + "%";
  cs_extent_range.style.left = percent + "%";
  if(cs_extent_inputRight.value == cs_extent_inputMax){
    cs_extent_text_div.innerHTML = cs_extent_inputLeft.value + " - 최대";
  }else{
    cs_extent_text_div.innerHTML = cs_extent_inputLeft.value + " - " + cs_extent_inputRight.value + "평";
  }
};

var cs_extent_setRightValue = () => {
  var _this = cs_extent_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(cs_extent_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_extent_thumbRight.style.right = 100 - percent + "%";
  cs_extent_range.style.right = 100 - percent + "%";
  if(cs_extent_inputRight.value == cs_extent_inputMax){
    cs_extent_text_div.innerHTML = cs_extent_inputLeft.value + " - 최대";
  }else{
    cs_extent_text_div.innerHTML = cs_extent_inputLeft.value + " - " + cs_extent_inputRight.value + "평";
  }
};

cs_extent_inputLeft.addEventListener("input", cs_extent_setLeftValue);
cs_extent_inputRight.addEventListener("input", cs_extent_setRightValue);

// =======================================================================
// =========================월세슬라이드===================================
// =======================================================================


var cs_month_inputLeft = document.getElementById("cs-month-input-left");
var cs_month_inputRight = document.getElementById("cs-month-input-right");
var cs_month_inputMax = cs_month_inputRight.getAttribute('max');


var cs_month_thumbLeft = document.querySelector(".cs-monthSlider > .thumb.left");
var cs_month_thumbRight = document.querySelector(".cs-monthSlider > .thumb.right");
var cs_month_range = document.querySelector(".cs-monthSlider > .range");
var cs_month_text_div = document.querySelector(".ReCs-monthSlider-txt");

if(cs_month_inputRight.value == cs_month_inputMax){
  cs_month_text_div.innerHTML = cs_month_inputLeft.value + " - 최대";
}else{
  cs_month_text_div.innerHTML = cs_month_inputLeft.value + " - " + cs_month_inputRight.value + "만원";
}

var cs_month_setLeftValue = () => {
  var _this = cs_month_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(cs_month_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_month_thumbLeft.style.left = percent + "%";
  cs_month_range.style.left = percent + "%";
  if(cs_month_inputRight.value == cs_month_inputMax){
    cs_month_text_div.innerHTML = cs_month_inputLeft.value + " - 최대";
  }else{
    cs_month_text_div.innerHTML = cs_month_inputLeft.value + " - " + cs_month_inputRight.value + "만원";
  }
};

var cs_month_setRightValue = () => {
  var _this = cs_month_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(cs_month_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_month_thumbRight.style.right = 100 - percent + "%";
  cs_month_range.style.right = 100 - percent + "%";
  if(cs_month_inputRight.value == cs_month_inputMax){
    cs_month_text_div.innerHTML = cs_month_inputLeft.value + " - 최대";
  }else{
    cs_month_text_div.innerHTML = cs_month_inputLeft.value + " - " + cs_month_inputRight.value + "만원";
  }
};

cs_month_inputLeft.addEventListener("input", cs_month_setLeftValue);
cs_month_inputRight.addEventListener("input", cs_month_setRightValue);

// =======================================================================
// =========================관리비입니다===================================
// =======================================================================

var cs_manage_inputLeft = document.getElementById("cs-manage-input-left");
var cs_manage_inputRight = document.getElementById("cs-manage-input-right");
var cs_manage_inputMax = cs_manage_inputRight.getAttribute('max');


var cs_manage_thumbLeft = document.querySelector(".cs-manageSlider > .thumb.left");
var cs_manage_thumbRight = document.querySelector(".cs-manageSlider > .thumb.right");
var cs_manage_range = document.querySelector(".cs-manageSlider > .range");
var cs_manage_text_div = document.querySelector(".ReCs-manageSlider-txt");

if(cs_manage_inputRight.value == cs_manage_inputMax){
  cs_manage_text_div.innerHTML = cs_manage_inputLeft.value + " - 최대";
}else{
  cs_manage_text_div.innerHTML = cs_manage_inputLeft.value + " - " + cs_manage_inputRight.value + "만원";
}

var cs_manage_setLeftValue = () => {
  var _this = cs_manage_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(cs_manage_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_manage_thumbLeft.style.left = percent + "%";
  cs_manage_range.style.left = percent + "%";
  if(cs_manage_inputRight.value == cs_manage_inputMax){
    cs_manage_text_div.innerHTML = cs_manage_inputLeft.value + " - 최대";
  }else{
    cs_manage_text_div.innerHTML = cs_manage_inputLeft.value + " - " + cs_manage_inputRight.value + "만원";
  }
};

var cs_manage_setRightValue = () => {
  var _this = cs_manage_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(cs_manage_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_manage_thumbRight.style.right = 100 - percent + "%";
  cs_manage_range.style.right = 100 - percent + "%";
  if(cs_manage_inputRight.value == cs_manage_inputMax){
    cs_manage_text_div.innerHTML = cs_manage_inputLeft.value + " - 최대";
  }else{
    cs_manage_text_div.innerHTML = cs_manage_inputLeft.value + " - " + cs_manage_inputRight.value + "만원";
  }
};

cs_manage_inputLeft.addEventListener("input", cs_manage_setLeftValue);
cs_manage_inputRight.addEventListener("input", cs_manage_setRightValue);

// =======================================================================
// =========================보증금입니다===================================
// =======================================================================


var cs_deposit_inputLeft = document.getElementById("cs-deposit-input-left");
var cs_deposit_inputRight = document.getElementById("cs-deposit-input-right");
var cs_deposit_inputMax = cs_deposit_inputRight.getAttribute('max');


var cs_deposit_thumbLeft = document.querySelector(".cs-depositSlider > .thumb.left");
var cs_deposit_thumbRight = document.querySelector(".cs-depositSlider > .thumb.right");
var cs_deposit_range = document.querySelector(".cs-depositSlider > .range");
var cs_deposit_text_div = document.querySelector(".ReCs-depositSlider-txt");

if(cs_deposit_inputRight.value == cs_deposit_inputMax){
  cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + " - 최대";
}else{
  if(parseInt(cs_deposit_inputRight.value) >= 10000){
    if(parseFloat(cs_deposit_inputLeft.value) < 10000){
      cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + "만원 - " + parseFloat(cs_deposit_inputRight.value)/10000 + "억원";
    }else{
      cs_deposit_text_div.innerHTML = parseFloat(cs_deposit_inputLeft.value)/10000 + " - " + parseFloat(cs_deposit_inputRight.value)/10000 + "억원";
    }
  }else{
    cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + " - " + cs_deposit_inputRight.value + "만원";
  }
}

var cs_deposit_setLeftValue = () => {
  var _this = cs_deposit_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(cs_deposit_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_deposit_thumbLeft.style.left = percent + "%";
  cs_deposit_range.style.left = percent + "%";
  if(cs_deposit_inputRight.value == cs_deposit_inputMax){
    cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + " - 최대";
  }else{
    if(parseInt(cs_deposit_inputRight.value) >= 10000){
      if(parseFloat(cs_deposit_inputLeft.value) < 10000){
        cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + "만원 - " + parseFloat(cs_deposit_inputRight.value)/10000 + "억원";
      }else{
        cs_deposit_text_div.innerHTML = parseFloat(cs_deposit_inputLeft.value)/10000 + " - " + parseFloat(cs_deposit_inputRight.value)/10000 + "억원";
      }
    }else{
      cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + " - " + cs_deposit_inputRight.value + "만원";
    }
  }
};

var cs_deposit_setRightValue = () => {
  var _this = cs_deposit_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(cs_deposit_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_deposit_thumbRight.style.right = 100 - percent + "%";
  cs_deposit_range.style.right = 100 - percent + "%";
  if(parseInt(cs_deposit_inputRight.value) >= 10000){
    if(parseFloat(cs_deposit_inputLeft.value) < 10000){
      cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + "만원 - " + parseFloat(cs_deposit_inputRight.value)/10000 + "억원";
    }else{
      cs_deposit_text_div.innerHTML = parseFloat(cs_deposit_inputLeft.value)/10000 + " - " + parseFloat(cs_deposit_inputRight.value)/10000 + "억원";
    }
  }else{
    cs_deposit_text_div.innerHTML = cs_deposit_inputLeft.value + " - " + cs_deposit_inputRight.value + "만원";
  }
};

cs_deposit_inputLeft.addEventListener("input", cs_deposit_setLeftValue);
cs_deposit_inputRight.addEventListener("input", cs_deposit_setRightValue);


// ===========================================================================================
// ==================================매매가입니다==============================================
// ===========================================================================================
var cs_trade_inputLeft = document.getElementById("cs-trade-input-left");
var cs_trade_inputRight = document.getElementById("cs-trade-input-right");
var cs_trade_inputMax = cs_trade_inputRight.getAttribute('max');


var cs_trade_thumbLeft = document.querySelector(".cs-tradeSlider > .thumb.left");
var cs_trade_thumbRight = document.querySelector(".cs-tradeSlider > .thumb.right");
var cs_trade_range = document.querySelector(".cs-tradeSlider > .range");
var cs_trade_text_div = document.querySelector(".ReCs-tradeSlider-txt");

if(cs_trade_inputRight.value == cs_trade_inputMax){
  cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + " - 최대";
}else{
  if(parseInt(cs_trade_inputRight.value) >= 10000){
    if(parseFloat(cs_trade_inputLeft.value) < 10000){
      cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + "만원 - " + parseFloat(cs_trade_inputRight.value)/10000 + "억원";
    }else{
      cs_trade_text_div.innerHTML = parseFloat(cs_trade_inputLeft.value)/10000 + " - " + parseFloat(cs_trade_inputRight.value)/10000 + "억원";
    }
  }else{
    cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + " - " + cs_trade_inputRight.value + "만원";
  }
}

var cs_trade_setLeftValue = () => {
  var _this = cs_trade_inputLeft;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(cs_trade_inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_trade_thumbLeft.style.left = percent + "%";
  cs_trade_range.style.left = percent + "%";
  if(cs_trade_inputRight.value == cs_trade_inputMax){
    cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + " - 최대";
  }else{
    if(parseInt(cs_trade_inputRight.value) >= 10000){
      if(parseFloat(cs_trade_inputLeft.value) < 10000){
        cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + "만원 - " + parseFloat(cs_trade_inputRight.value)/10000 + "억원";
      }else{
        cs_trade_text_div.innerHTML = parseFloat(cs_trade_inputLeft.value)/10000 + " - " + parseFloat(cs_trade_inputRight.value)/10000 + "억원";
      }
    }else{
      cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + " - " + cs_trade_inputRight.value + "만원";
    }
  }
};

var cs_trade_setRightValue = () => {
  var _this = cs_trade_inputRight;
  var [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(cs_trade_inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  var percent = ((_this.value - min) / (max - min)) * 100;
  cs_trade_thumbRight.style.right = 100 - percent + "%";
  cs_trade_range.style.right = 100 - percent + "%";
  if(cs_trade_inputRight.value == cs_trade_inputMax){
    cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + " - 최대";
  }else{
    if(parseInt(cs_trade_inputRight.value) >= 10000){
      if(parseFloat(cs_trade_inputLeft.value) < 10000){
        cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + "만원 - " + parseFloat(cs_trade_inputRight.value)/10000 + "억원";
      }else{
        cs_trade_text_div.innerHTML = parseFloat(cs_trade_inputLeft.value)/10000 + " - " + parseFloat(cs_trade_inputRight.value)/10000 + "억원";
      }
    }else{
      cs_trade_text_div.innerHTML = cs_trade_inputLeft.value + " - " + cs_trade_inputRight.value + "만원";
    }
  }
};

cs_trade_inputLeft.addEventListener("input", cs_trade_setLeftValue);
cs_trade_inputRight.addEventListener("input", cs_trade_setRightValue);

