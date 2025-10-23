class Node {
  constructor(data = null) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  //adding the element at the end
  append(element) {
    let nodeToBeAdded = new Node(element);
    if (this.length == 0) {
      //Assigning two empty nodes to head and tail

      this.head = new Node();
      this.tail = new Node();
      //Pointing to the new Node
      this.head.next = nodeToBeAdded;
      this.tail.next = nodeToBeAdded;
    }
    //If list is not empty.
    else {
      let lastNode = this.tail.next;
      lastNode.next = nodeToBeAdded;
      this.tail.next = nodeToBeAdded;
    }
    this.length++;
  }

  //Add at the start of LinkedList
  prepend(element) {
    //if list is empty
    if (this.length == 0) {
      this.append(element);
    } else {
      let nodeToBeAdded = new Node(element);
      let firstNode = this.head.next;
      nodeToBeAdded.next = firstNode;
      this.head.next = nodeToBeAdded;
      this.length++;
    }
  }

  insertAt(index, element) {
    if (this.indexOutOfBound(index)) {
      return { Error: "Index out of bound." };
    }

    if (index == 0) {
      this.prepend(element);
    } else if (index == this.length - 1) {
      this.append(element);
    } else {
      let nodeToBeAdded = new Node(element);

      let nodeBeforeTarget = this.getNodeBeforeTarget(this.head.next, index);

      let nextNode = nodeBeforeTarget.next;
      nodeBeforeTarget.next = nodeToBeAdded;
      nodeToBeAdded.next = nextNode;
      this.length++;
    }
  }

  removeIndex(index) {
    if (this.indexOutOfBound(index)) {
      return { Error: "Index out of bound." };
    }

    //first Index removal

    if (index == 0) {
      if (this.length == 1) {
        this.head = null;
        this.tail = null;
      } else {
        this.head.next = this.head.next.next;
      }
    }
    //index other than 0
    else {
      let nodeBeforeTarget = this.getNodeBeforeTarget(this.head.next, index);
      let nextNode = nodeBeforeTarget.next;
      nodeBeforeTarget.next = nextNode.next;
    }
    this.length--;
  }

  getListAsArray() {
    let listArray = [];
    let runningNode = this.head.next;
    while (runningNode) {
      listArray.push(runningNode.data);
      runningNode = runningNode.next;
    }
    return listArray;
  }

  indexOutOfBound(index) {
    if (index > this.length - 1 || index < 0) {
      return true;
    }
    return false;
  }

  getNodeBeforeTarget(nodeBeforeTarget, index) {
    let indexCount = 0;
    while (indexCount < index - 1) {
      nodeBeforeTarget = nodeBeforeTarget.next;
      indexCount++;
    }
    return nodeBeforeTarget;
  }
}

const linkedList = new LinkedList();

// Test the append method
linkedList.append(10);
linkedList.append(20);
linkedList.append(30);

console.log(linkedList.getListAsArray());

// Test the prepend method
linkedList.prepend(5);
linkedList.prepend(2);

// Test the insertAt method
linkedList.insertAt(2, 15);
linkedList.insertAt(4, 25);

// Test the removeIndex method
linkedList.removeIndex(3);
linkedList.removeIndex(0);

// Test the getListAsArray method
console.log(linkedList.getListAsArray()); //[ 5, 15, 25, 20, 30 ]
