/* 03_nested-function(중첩 함수)
함수 내부에 정의 된 함수를 중첩 함수 또는 내부 함수라고 한다.
중첩 함수를 포함하는 함수는 외부 함수라고 한다.
일반적으로 중첩 함수는 자신을 포함하는 외부 함수를 돕는 헬퍼 함수의 역할을 한다.
*/
function outer() {
   var outerVal = '외부 함수';

   function inner() {
       var innerVal = '내부 함수';
       // 외부 함수의 변수를 참조할 수 있다.
       console.log(outerVal, innerVal); // 클로저  - 내부 함수가 외부 함수의 지역변수에 접근할 수 있고
                                                 // 외부 함수는 지역변수를 사용하는 내부 함수가 소멸될 때까지 소멸되지 않는 특성이 있다.
   }

   inner();
}

outer();
