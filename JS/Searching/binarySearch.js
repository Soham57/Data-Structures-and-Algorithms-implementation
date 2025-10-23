function binarySearch(arr, element) {
  let start = 0;
  let end = arr.length - 1;

  while (start <= end) {
    let midIndex = Math.floor((start + end) / 2);
    if (arr[midIndex] === element) {
      return true;
    } else if (arr[midIndex] < element) {
      start = midIndex + 1;
    } else {
      end = midIndex - 1;
    }
  }

  return false;
}

console.log(binarySearch([0, 5, 10, 12, 15, 19, 21, 22, 24, 30], 102));
