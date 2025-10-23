/*This approach reduces the number of iterations and enhances the algorithm's efficiency.
By keeping track of the number of swaps made in each pass, the algorithm can exit early if the array is already sorted.
This eliminates unnecessary iterations, resulting in improved performance for partially sorted or nearly sorted arrays.
The use of array destructuring assignment allows for a cleaner and more concise way to swap elements, making the code more readable. */

function bubbleSort(arr) {
  let swapCount = 1;

  while (swapCount > 0) {
    swapCount = 0;

    for (let j = 1; j < arr.length; j++) {
      if (arr[j - 1] > arr[j]) {
        // Swapping elements
        [arr[j - 1], arr[j]] = [arr[j], arr[j - 1]];
        swapCount++;
      }
    }
  }

  return arr;
}

console.log(bubbleSort([1, 5, 4, 2, 3]));
