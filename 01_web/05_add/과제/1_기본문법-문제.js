let grade = "손님"

if (grade == "손님") {
    let authority = "글 읽기"
    console.log(grade + "의 경우 " + authority + "가 가능합니다.")
} else if (grade == "일반 회원") {
    let authority = "글 읽기, 글 쓰기"
    console.log(grade + "의 경우 " + authority + "가 가능합니다.")
} else if (grade == "운영자") {
    let authority = "글 읽기, 글 쓰기, 글 삭제"
    console.log(grade + "의 경우 " + authority + "가 가능합니다.")
} else {
    console.log("비정상적인 접근입니다.")
}


authority = (grade === "손님") ? "글 읽기" :
    (grade === "일반 회원") ? "글 읽기, 글 쓰기" :
        (grade === "운영자") ? "글 읽기, 글 쓰기, 글 삭제" :
            "비정상적인 접근입니다.";

console.log(grade + "의 경우 " + authority + "가 가능합니다.")


let browser = "Edge"
switch (browser) {
    case 'Edge':
        console.log("Edge를 사용하고 계시네요!");
        break;
    case 'Chrome', 'Firefox', 'Safari', 'Opera':
        console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
        break;
    default:
        console.log('현재 페이지가 괜찮아 보이길 바랍니다!');
        break;
}


let i = 0
while (i < 10) {
    console.log('number' + (i + 1))
    i++
}