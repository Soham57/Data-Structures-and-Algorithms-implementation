class BloomFilter {
    constructor(size = 100) {
      this.size = size;
      this.bitArray = new Array(size).fill(false);
    }
  
    // Hash functions
    hash1(value) {
      let hash = 0;
      for (let i = 0; i < value.length; i++) {
        hash += value.charCodeAt(i);
      }
      return hash % this.size;
    }
  
    hash2(value) {
      let hash = 0;
      for (let i = 0; i < value.length; i++) {
        hash = (hash << 5) + hash + value.charCodeAt(i);
      }
      return hash % this.size;
    }
  
    hash3(value) {
      let hash = 5381;
      for (let i = 0; i < value.length; i++) {
        hash = (hash << 5) + hash + value.charCodeAt(i);
      }
      return hash % this.size;
    }
  
    insert(value) {
      const index1 = this.hash1(value);
      const index2 = this.hash2(value);
      const index3 = this.hash3(value);
  
      this.bitArray[index1] = true;
      this.bitArray[index2] = true;
      this.bitArray[index3] = true;
    }
  
    contains(value) {
      const index1 = this.hash1(value);
      const index2 = this.hash2(value);
      const index3 = this.hash3(value);
  
      return (
        this.bitArray[index1] &&
        this.bitArray[index2] &&
        this.bitArray[index3]
      );
    }
  }
  
  // Example usage:
  const bloom = new BloomFilter(100);
  bloom.insert('apple');
  bloom.insert('orange');
  
  console.log(bloom.contains('apple')); // Output: true
  console.log(bloom.contains('banana')); // Output: false
  