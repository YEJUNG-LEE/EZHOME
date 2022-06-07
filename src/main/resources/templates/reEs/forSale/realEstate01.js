const inputLeft = document.getElementById("floor-input-left");
const inputRight = document.getElementById("floor-input-right");

const thumbLeft = document.querySelector(".floorSlider > .thumb.left");
const thumbRight = document.querySelector(".floorSlider > .thumb.right");
const range = document.querySelector(".floorSlider > .range");
const text_div = document.querySelector(".ReEs-navi-normal-floor-select-slider-txt");
text_div.innerHTML = inputLeft.value + " - " + inputRight.value + "층";

const setLeftValue = () => {
  const _this = inputLeft;
  const [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.min(parseInt(_this.value), parseInt(inputRight.value) - 1);
  
  // input, thumb 같이 움직이도록
  const percent = ((_this.value - min) / (max - min)) * 100;
  thumbLeft.style.left = percent + "%";
  range.style.left = percent + "%";
  text_div.innerHTML = inputLeft.value + " - " + inputRight.value + "층";
};

const setRightValue = () => {
  const _this = inputRight;
  const [min, max] = [parseInt(_this.min), parseInt(_this.max)];
  
  // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
  _this.value = Math.max(parseInt(_this.value), parseInt(inputLeft.value) + 1);
  
  // input, thumb 같이 움직이도록
  const percent = ((_this.value - min) / (max - min)) * 100;
  thumbRight.style.right = 100 - percent + "%";
  range.style.right = 100 - percent + "%";
  text_div.innerHTML = inputLeft.value + " - " + inputRight.value + "층";

};

inputLeft.addEventListener("input", setLeftValue);
inputRight.addEventListener("input", setRightValue);

