class Queue {
    constructor() {
      this.elements = {};
      this.head = 0;
      this.tail = 0;
      this.length = 0;
    }
    enqueue(element) {
      this.elements[this.tail] = element;
      this.tail++;
      this.length++;
    }
    dequeue() {
      if(this.length === 0){
          return null;
      }
      
      const item = this.elements[this.head];
      delete this.elements[this.head];
      this.head++;
      this.length--;
      return item;
    }
    peek() {
      return this.elements[this.head];
    }
    getLength() {
      return this.length;
    }
    isEmpty() {
      return this.length === 0;
    }
  }
