function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    let numToBeInserted = arr[i];
    let j;

    // Find the correct position to insert numToBeInserted
    for (j = i - 1; j >= 0 && arr[j] > numToBeInserted; j--) {
      arr[j + 1] = arr[j];
    }

    // Insert numToBeInserted at the correct position
    arr[j + 1] = numToBeInserted;
  }

  return arr;
}

// Test the function
console.log(insertionSort([1, 5, 2, 4, 3]));
