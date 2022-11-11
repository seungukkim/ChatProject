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

let card = document.querySelectorAll('.card');
let toBack = document.querySelector('#toBack');
let front = document.querySelectorAll('.front');
let back = document.querySelectorAll('.back');
console.log(front);
front.forEach(element => {
  element.addEventListener('click', click);
});

function delay(){
  back1.style.animationName = 'test1';
}

function click(event) {
  var elem = event.currentTarget;
  var className = $(elem).attr('class'); 
  //부모 객체의 자식들 배열 가져옴
  //클릭한 요소는 위에서 가져옴
  //배열에서 클릭한 요소 빼고, 배열의 요소들을 dom에서 제거

  // 카드가 앞면일때
    elem.style.transform = "rotateY(180deg)";
    document.querySelector(".resttime").style.zIndex = '0';
}
// 주어.행동()
// 행동(목적어)
// 행동(); 
//안에서 누구에게 행동할건지를 정의해줘야하니까 하드코딩이 되는거고

function toback(asdf) {
  elem.style.transform = "rotateY(0deg)";

}


// 1. 클릭했을때 클릭한 객체 가져오는 함수 연동
// 1. 클릭한 객체 가져오는 함수 구현
