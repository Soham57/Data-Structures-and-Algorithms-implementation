function countTo(max, current) {
  if (max < current) {
    return;
  }

  console.log(current);
  countTo(max, current + 1);
}

countTo(10, 0);
