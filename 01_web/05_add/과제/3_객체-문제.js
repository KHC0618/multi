const calculator = {
    a : 10,
    b : 20,
    // 코드 작성
    sum: function() {
        return this.a + this.b;
    },
    multi: function() {
        return this.a * this.b;
    }
  };
  // 코드 작성
  console.log("합 : " + calculator.sum())
  console.log("곱 : " + calculator.multi())

  function Calculator() {
    this.a = 10;
    this.b = 20;
    // 코드 작성
    this.sum = function() {
        return this.a + this.b
    }
    this.multi = function() {
        return this.a * this.b
    }
  }
  // 코드 작성
  const calc = new Calculator()

  console.log("합 : " + calc.sum())
  console.log("곱 : " + calc.multi())
  