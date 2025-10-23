class Queue {
  constructor() {
    this.dataStore = [];
  }

  front() {
    return this.dataStore[0];
  }

  back() {
    return this.dataStore[this.dataStore.length - 1];
  }

  enqueue(element) {
    this.dataStore.push(element);
  }

  dequeue() {
    return this.dataStore.shift();
  }

  isEmpty() {
    if (this.dataStore.length == 0) {
      return false;
    }

    return true;
  }
}

let peopleQueue = new Queue();
peopleQueue.dequeue();
peopleQueue.enqueue("Cynthia");
peopleQueue.enqueue("Estonia");
peopleQueue.enqueue("Casey");
peopleQueue.enqueue("Ross");
peopleQueue.dequeue();

//console.log(peopleQueue.dataStore);
