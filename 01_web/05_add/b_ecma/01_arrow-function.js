/* 01_arrow-funciton-basic-syntax
ES6에서 도입 된 화살표 함수는 function 키워드 대신 화살표를 사용해 좀 더 간략한 방법으로 함수를 선언할 수 있다. 
화살표 함수는 항상 익명 함수로 정의한다. 본문이 한 줄인 함수를 작성할 때 유용하다.

// 1. 매개변수 지정 방법
    () => { ... }       // 매개변수가 없을 경우
    x => { ... }        // 매개변수가 한 개인 경우, 소괄호를 생략할 수 있다.
    (x, y) => { ... }   // 매개변수가 여러 개인 경우, 소괄호를 생략할 수 없다.

// 2.함수 지정 방법
    x => { return x * x }   
    x => x * x              // 한줄이면  중괄호를 생략할 수 있고  암묵적으로 return

    () => { return { a: 1 }; }
    () => ({ a: 1 })        // 객체 반환시 소괄호를 사용한다.

    () => {                 //멀티라인이면 중괄호를 생략할 수 없다
    const x = 5;
    return x * x;
    };

*/

let message

// 기존 function 정의
message = function () {
    return "hello world"
}

console.log(message())

message = () => {
    console.log("test")     // 이렇게 되는 경우 함수 내용이 2줄이라서 생략 불가능.
    return "Arrow Function"
}

console.log(message())

message = () => "Arrow Function simple"     // {}와 return을 생략할 수 있다.

console.log(message())


// 매개 변수가 있을 경우
message = val => "Arrow Function simple" + val

console.log(message(" 매개 변수 하나 "))

// 매개 변수가 두 개 이상 있을 경우
message = (val1, val2) => "Arrow " + val1 + val2;

console.log(message("Function ", "simple "))

const createUser = (id, name) => ({ id, name })
console.log(createUser(1, "유관순"))

console.log([1, 2, 3, 4, 5].map(function (val) { return val * 10 }))
console.log([1, 2, 3, 4, 5].map(val => val * 10))