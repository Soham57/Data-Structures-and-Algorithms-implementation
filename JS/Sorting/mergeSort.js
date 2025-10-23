function mergeSort(arr) {
  // Base case: if the array length is 1, it is already sorted
  if (arr.length === 1) {
    return arr;
  }

  // Find the middle index of the array
  let len = arr.length;
  let middle = Math.floor(len / 2);

  // Split the array into two halves
  let left = arr.slice(0, middle);
  let right = arr.slice(middle);

  // Recursively sort the left and right halves
  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  let leftIndex = 0;
  let rightIndex = 0;
  let resultArr = [];

  // Compare elements from the left and right arrays and merge them in sorted order
  while (leftIndex < left.length && rightIndex < right.length) {
    if (left[leftIndex] < right[rightIndex]) {
      resultArr.push(left[leftIndex]);
      leftIndex++;
    } else {
      resultArr.push(right[rightIndex]);
      rightIndex++;
    }
  }

  // Add any remaining elements from the left and right arrays
  return resultArr
    .concat(left.slice(leftIndex))
    .concat(right.slice(rightIndex));
}

console.log(mergeSort([2, 8, 1, 3, 6, 7, 5, 4]));
