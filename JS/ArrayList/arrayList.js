class ArrayList {
  constructor() {
    this.data = {};
    this.length = 0;
  }

  push(element) {
    this.data[this.length] = element;
    this.length++;
  }

  pop() {
    let poppedElement = this.data[this.length - 1];
    delete this.data[this.length - 1];
    this.length--;
    return poppedElement;
  }

  unshift(element) {
    this.moveArrayElements(0, 1);
    this.data[0] = element;
    this.length++;
  }

  shift() {
    let shiftElement = this.data[0];
    this.length--;
    this.moveArrayElements(1, -1);
    return shiftElement;
  }

  insertBetween(index, element) {
    this.moveArrayElements(index, 1);
    this.data[index] = element;
    this.length++;
    return true;
  }

  insertAt(index, value) {
    if (index > -1) this.data[index] = value;
    if (index > this.length) {
      this.length = index + 1;
    }
  }

  remove(index) {
    if (index > -1 && index < this.length) {
      let removedElement = this.data[index];
      this.length--;
      this.moveArrayElements(index + 1, -1);
      return removedElement;
    }
  }

  get(index) {
    if (index > -1) return this.data[index];
  }

  moveArrayElements(startIndex, moveFactor) {
    if (moveFactor === 1) {
      let currentIndex = this.length;
      while (currentIndex > startIndex) {
        this.data[currentIndex] = this.data[currentIndex - 1];
        currentIndex--;
      }
    } else {
      while (startIndex < this.length + 1) {
        //console.log("Start", this.data);
        //console.log(startIndex, " ", this.length);
        this.data[startIndex - 1] = this.data[startIndex];
        startIndex++;
      }
      delete this.data[startIndex - 1];
    }
  }
}

let arr = [1, 2, 3, 4, 5];
arr.push(7);
arr.pop();
arr.unshift(12);
arr.unshift(27);
arr.shift();
arr.splice(3, 0, 99);
arr[20] = 80;
arr[7] = 45;
arr.splice(6, 1); //removing element at index
let myArray = new ArrayList();

myArray.push(1);
myArray.push(2);
myArray.push(3);
myArray.push(4);
myArray.push(5);
myArray.push(7);
myArray.pop();
myArray.unshift(12);
myArray.unshift(27);
myArray.shift();
myArray.insertBetween(3, 99);
myArray.insertAt(20, 80);
myArray.insertAt(7, 45);
myArray.remove(6);

console.log("JS", arr.length, arr);

console.log("My", myArray.length, myArray.data);
