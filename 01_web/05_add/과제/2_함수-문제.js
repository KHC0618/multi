const num1 = 10;
const num2 = 20;
// 코드 작성
function min(num1, num2) {
    return num1 < num2 ? num1 : num2
}

function max(num1, num2) {
    return num1 > num2 ? num1 : num2
}

console.log("최소값 : " + min(num1, num2))
console.log("최대값 : " + max(num1, num2))

const x = 2;
const n = 10;
// 코드 작성
function pow(x, n) {
    let result = 1;
    for (let i = 0; i < n; i++) {
        result *= x
    }
    return result
}

if (n > 0) {
    console.log(pow(x, n))
} else {
    console.log(n + "은 양의 정수이어야 합니다.")
}

const a = 10;
const b = 20;
// 코드 작성
const min2 = (a, b) => a < b ? a : b
const max2 = (a, b) => a > b ? a : b

console.log("최소값 : " + min(a, b))
console.log("최대값 : " + max(a, b))