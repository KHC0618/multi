const str = '사과,바나나,당근,김밥,치즈,떡볶이,햄버거,환타,사이다,콜라,고양이,강아지';

console.log(findWord(str, '고양이'));
console.log(findWord(str, '샌드위치'));
console.log(findWord(str));

function findWord(str, word) {
    // 코드 작성
    const strArray = str.split(',')
    const index = strArray.indexOf(word)
    if (word == null) {
        return "결과를 확인할 수 없습니다."
    }
    if (index != -1) {
        return word + "는 배열 index " + index + "번째에 있습니다."
    } else {
        return word + "는 배열에 존재하지 않습니다."
    }
}


function filterRange(arr, a, b) {
    // 코드 작성
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < a || arr[i] > b) {
            arr.splice(i, 1)
            i--
        }
    }
}

const arr = [5, 3, 8, 1, 10, 4];

filterRange(arr, 1, 5);

console.log(arr);


let numbers = [20, 100, 37, 54, 88, 9];
let strings = ['wow', 'js', 'party', 'hello'];

// 코드 작성
let ascendingNumbers = numbers.slice().sort((a, b) => a - b)
let ascendingStrings = strings.slice().sort()

let descendingNumbers = numbers.slice().sort((a, b) => b - a)
let descendingStrings = strings.slice().sort().reverse()

console.log(ascendingNumbers)
console.log(descendingNumbers)
console.log(ascendingStrings)
console.log(descendingStrings)


function Student(firstName, lastName, score) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
}

const studentList = [
    new Student('길동', '홍', 60),
    new Student('보고', '장', 70),
    new Student('관순', '유', 80)
];

sortFromScore(studentList);
console.log(studentList);
console.log(makeFullName(studentList));

function sortFromScore(arr) {
    // 코드 작성
    arr.sort((a, b) => b.score - a.score)
}

function makeFullName(arr) {
    // 코드 작성
    return arr.map(student => {
        return {
            name: student.lastName + student.firstName,
            score: student.score
        }
    })
}