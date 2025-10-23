class Stack {
  constructor() {
    this.dataStore = [];
    this.top = 0;
  }

  push(element) {
    this.dataStore[this.top] = element;
    this.top++;
  }

  pop() {
    if (this.top > 0) {
      let poppedElement = this.dataStore.pop();
      this.top--;
      return poppedElement;
    }
  }

  peek() {
    return this.dataStore[this.top];
  }
}

//Application of Stack Decimal to smaller base conversion.

function convertNumberToBase(numberToConvert, base) {
  let stack = new Stack();
  while (numberToConvert > 0) {
    stack.push(numberToConvert % base);
    numberToConvert = Math.floor(numberToConvert / base);
  }
  let convertedNum = convertStackToStr(stack);
  return convertedNum;
}

function convertStackToStr(stack) {
  let numStr = "";
  while (stack.top > 0) {
    numStr += stack.pop();
  }

  return numStr;
}

//Calling functions

let decimal = 926567;
const base = 8;
let convertedNum = convertNumberToBase(decimal, base);
console.log("Converted Num: ", convertedNum);
