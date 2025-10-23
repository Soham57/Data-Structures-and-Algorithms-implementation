function binarySearch(arr, element) {
  if (arr.length === 0) {
    return false;
  }

  let midIndex = Math.floor(arr.length / 2);

  if (arr[midIndex] === element) {
    return true;
  } else if (arr[midIndex] < element) {
    return binarySearch(arr.slice(midIndex + 1), element);
  } else {
    return binarySearch(arr.slice(0, midIndex), element);
  }
}

console.log(binarySearch([0, 5, 10, 12, 15, 19, 21, 22, 24, 30], 102));
