/* 04_callback-function(콜백 함수) 
함수의 매개변수를 통해 다른 함수의 내부로 전달되는 함수를 콜백 함수라고 한다. 
간단하게 다른 함수에 매개변수로 넘겨준 함수 , 
매개변수로 넘겨받은 함수는 일단 넘겨받고, 때가 되면 나중에 호출(called back)한다는 것이 콜백함수
매개변수를 통해 함수의 외부에서 콜백 함수를 전달 받은 함수를 고차 함수라고 한다. 
콜백 함수는 고차 함수에 전달 되어 헬퍼 함수의 역할을 한다. 즉, 고차 함수는 콜백 함수를 자신의 일부분으로 합성한다. 
*/

// 전달 받은 값을 증가 시켜주는 콜백함수
function increase (value) {
   return value + 1;
}

// 전달 받은 값을 감소 시켜주는 콜백함수
function decrease (value) {
   return value - 1;
}

// 전달 받은 함수(func)에 전달 받은 값(value)을 적용시켜주는 고차함수
function apply(func, value) {
   return func(value)
}

// 고차함수로 콜백함수를 전달하면서 호출
console.log(apply(increase, 5))
console.log(apply(decrease, 5))

// 콜백 함수가 고차 함수 내부에만 호출 된다면 콜백 함수를 익명 함수 리터럴로 정의하면서 곧바로 고차 함수에 전달하는 것이 일반적이다.
console.log(apply(function(value){ return value ** 2; }, 5));

/* 함수의 변하지 않는 공통 로직은 미리 정의해두고 경우에 따라 변경되는 로직은 추상화해서 함수 외부에서 내부로 전달하는 방식이다.
콜백 함수는 함수형 프로그래밍 패러다임뿐만 아니라 비동기 처리(이벤트, 타이머, ajax)에 활용되는 중요한 패턴이다.
또한 배열 고차 함수(map)에서도 사용 된다. */