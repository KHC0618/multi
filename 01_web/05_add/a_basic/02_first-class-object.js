/* 01_first-class-object(일급 객체)
1. 무명의 리터럴로 생성할 수 있다. 즉, 런타임에 생성이 가능하다.
2. 변수나 자료구조(객체, 배열 등)에 저장할 수 있다.
3. 함수의 매개변수에 전달할 수 있다.
4. 함수의 반환값으로 사용할 수 있다.
*/

// 1. 무명의 리터럴로 생성할 수 있다. 
// 2. 변수에 저장할 수 있다.
let hello = function () {
    return '안녕하세요!';
};
// 2. 객체에 저장할 수 있다.
let obj = { hello };

// 3. 함수의 매개변수에 전달할 수 있다.
function repeat(func, count) {
    for(let i = 0; i < count; i++) {
        console.log(func());
    }
    // 4. 함수의 반환값으로 사용할 수 있다.
    return function () {
        console.log(`${count}번 반복 완료`);
    }
}

// 일급 객체는 객체와 동일하게 사용할 수 있다는 의미.
// 객체는 값이므로 함수는 값과 동일하게 취급할 수 있다.