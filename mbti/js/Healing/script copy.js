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
let front1 = document.querySelector('.front1');
let front2 = document.querySelector('.front2');
let front3 = document.querySelector('.front3');
card1.addEventListener('click', click);
card2.addEventListener('click', click);
card3.addEventListener('click', click);




function click(event) {
  let elem = event.currentTarget;
  var className = $(elem).attr('class');
  if (elem.style.transform == "rotateY(180deg)" || "rotateY(-180deg)") {
    console.log("실행됨");
    elem.style.transform = "rotateY(0deg)";
    switch (className) {
      case 'card1':
        card2.style.animation = '0.75';
        card3.style.animation = '0.75';
        break;
      case 'card2':
        card1.style.opacity = '0.75';
        card3.style.opacity = '0.75';
        break;
      case 'card3':
        card1.style.opacity = '0.75';
        card2.style.opacity = '0.75';
        break;
    }
  } 
  else {
    elem.style.transform = "rotateY(180deg)";
    switch (className) {
      case 'card1':
        front2.style.opacity = '0';
        front3.style.opacity = '0';
        break;
      case 'card2':
        front1.style.opacity = '0';
        front3.style.opacity = '0';
        break;
      case 'card3':
        front1.style.opacity = '0';
        front2.style.opacity = '0';
        break;
      }
    }
  }
  
  //부모 객체의 자식들 배열 가져옴
  //클릭한 요소는 위에서 가져옴
  //배열에서 클릭한 요소 빼고, 배열의 요소들을 dom에서 제거
  
