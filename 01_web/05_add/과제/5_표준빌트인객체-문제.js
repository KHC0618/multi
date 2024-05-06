console.log(getWeekDay(2022, 6, 21));       // 2022년 6월 21일
console.log(getWeekDay(2022, 12, 12));      // 2022년 12월 12일 

function getWeekDay(year, month, date) {
    // 코드 작성
    const days = ['일', '월', '화', '수', '목', '금', '토']
    const targetDate = new Date(year, month - 1, date)
    const dayIndex = targetDate.getDay()
    return days[dayIndex]
}


console.log(getSecondsToday());
console.log(getSecondsToTomorrow());

function getSecondsToday() {
    // 코드 작성
    const now = new Date()
    const startOfDay = new Date(now.getFullYear(), now.getMonth(), now.getDate())
    const elapsedSeconds = (now - startOfDay) / 1000
    return "오늘은" + Math.round(elapsedSeconds) + "초나 흘렀습니다. 시간을 소중히 씁시다^^"
}

function getSecondsToTomorrow() {
    // 코드 작성
    const now = new Date()
    const endOfDay = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 1)
    const remainingSeconds = (endOfDay - now) / 1000
    return "오늘은" + Math.round(remainingSeconds) + "초 밖에 안 남았습니다. 다시는 오지 않는 오늘입니다^^"
}


const words = [
    '15',
    'AFC',
    'AAFC',
    'AAAFFCC',
    'AAFCC',
    'BAFC',
    'QWEDFGHJMNB',
    'DFAFCB',
    'ABCDEFC',
    'DADC'
];

// 코드 작성
function checkChromosomePattern(word) {
    if (!/^[A-F]?A+F+C+[A-F]?$/.test(word)) return 'Infected!'
    return 'Good'
}

words.forEach(word => {
    console.log(checkChromosomePattern(word))
})

let arr = ["1080px", "$100", "+200", "60kg", "6m", "-15"]
console.log(removeChar(arr))

function removeChar(arr) {
    // 코드 작성
    return arr.map(str => {
        const num = parseInt(str.replace(/[^0-9\-]/g, ''))
        return num;
    })
}


const list = ['기러기', '토마토', '스위스', '인도인', '별똥별', '유재석']

list.forEach(item => console.log(palindrom(item)))

function palindrom(str) {
    // 코드 작성
    const reverseStr = str.split('').reverse().join('')
    return str === reverseStr;
}