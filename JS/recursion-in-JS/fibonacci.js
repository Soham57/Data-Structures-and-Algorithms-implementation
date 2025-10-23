function fibonacci(lastTerm) {
  //Beginner
  if (lastTerm === 2 || lastTerm === 1) {
    return 1;
  } else if (lastTerm < 1) {
    return 0;
  }

  return fibonacci(lastTerm - 1) + fibonacci(lastTerm - 2);
}

console.log(fibonacci(8));
