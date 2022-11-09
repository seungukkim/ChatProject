$(document).ready(function () {
  var stars = 800;
  var $stars = $(".stars");
  var r = 800;
  for (var i = 0; i < stars; i++) {
    var $star = $("<div/>").addClass("star");
    $stars.append($star);
  }
  $(".star").each(function () {
    var cur = $(this);
    var s = 0.2 + (Math.random() * 1);
    var curR = r + (Math.random() * 300);
    cur.css({
      transformOrigin: "0 0 " + curR + "px",
      transform: " translate3d(0,0,-" + curR + "px) rotateY(" + (Math.random() * 360) + "deg) rotateX(" + (Math.random() * -50) + "deg) scale(" + s + "," + s + ")"

    })
  })
})

let card1 = document.querySelector('.card1');
let card2 = document.querySelector('.card2');
let card3 = document.querySelector('.card3');
card1.addEventListener('click', click);
card2.addEventListener('click', click);
card3.addEventListener('click', click);




function click(event) {
  let elem = event.currentTarget;
  //부모 객체의 자식들 배열 가져옴
  //클릭한 요소는 위에서 가져옴
  //배열에서 클릭한 요소 빼고, 배열의 요소들을 dom에서 제거
  if (elem.style.transform == "rotateY(180deg)") {
    elem.style.transform = "rotateY(0deg)";
  } else {
    elem.style.transform = "rotateY(180deg)";
  }

  let card1 = document.querySelector(".card1");
  // console.log(card1.style);
  // if (card1.style.left == "") {
  //   card1.style.left = "20vw";
  // }
  // else {
  //   card1.style.left = "";
  // }
}