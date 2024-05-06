console.log("hello")

// (base) PS C:\workspace\multi\01_web\05_add\a_basic> node .\01_function.js    실행할 때 node 명령어 한칸 띄우고 해당 파일명 작성
// hello
// (base) PS C:\workspace\multi\01_web\05_add\a_basic> cd ../   --> 상위 폴더로 올라감
// (base) PS C:\workspace\multi\01_web\05_add> cd ../           --> 상위 폴더로 올라감
// (base) PS C:\workspace\multi\01_web> cd .\05_add\a_basic\    --> 하위 폴더로 이동 시 파일명 쓰고 tab 하면 자동 생성
// (base) PS C:\workspace\multi\01_web\05_add\a_basic>

/*
템플릿 리터럴
ES6부터 도입 된 멀티라인 문자열, 표현식 삽입 등의 편리한 문자열 처리 기능을 제공하는 문자열 표기법이다.
이 때는 작은 따옴표, 큰 따옴표 대신 백틱을 사용해 표현한다.
*/

const lastName = '홍';
const firstName = '길동';

// 표현식 삽입은 반드시 백틱 내에서 사용해야 한다.
// 일반 문자열에서의 표현식 삽입은 문자열로 취급된다.
console.log(`제 이름은 ${lastName}${firstName}입니다.`)

console.log(hello('함수 호이스팅 체크'))

// 함수 선언문은 런타임 이전 자바스크립트 엔진에 의해 먼저 실행 된다. 
// 따라서 함수 선언문 이전에 함수를 참조할 수 있으며 호출할 수도 있다. 
// 함수 선언문이 코드의 선두로 끌어 올려진 것처럼 동작하는 자바스크립트 고유의 특징을 함수 호이스팅이라고 한다.

// 함수 선언문
function hello(name) {
    return `${name}님 안녕하세요.`;
}

// 함수 호출
console.log(hello(`제니`))

// 함수 식별자 구분 예제
// 식별자 hello2, 이름 hello1       만약에 식별자를 작성하지 않으면 내부적으로 식별자를 이름과 같이 만들어서 실행시키고 있던 것.
let hello2 = function hello1(name) {
    return `${name}님 안녕하세요.`;
}

console.log(hello2('홍길동'))

