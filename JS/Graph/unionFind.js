//Union find with path compression, and ranks
class UnionFind {
  constructor() {
    this.parents = {};
    this.ranks = {}
  }

  createSet(value) {
    this.parents[value] = value;
    this.ranks[value] = 0;
  }

  find(value) {
    if(!(value in this.parents)) return null;

    if(value !== this.parents[value]){
      this.parents[value] = this.find(this.parents[value]);
    }

    return this.parents[value];
  }

  union(valueOne, valueTwo) {
    if(!(valueOne in this.parents) || !(valueTwo in this.parents)) return null;

    const valueOneRoot = this.find(valueOne);
    const valueTwoRoot = this.find(valueTwo);

    if(valueOneRoot === valueTwoRoot) return null;
    
    if(this.ranks[valueOneRoot] < this.ranks[valueTwoRoot]){
      this.parents[valueOneRoot] = valueTwoRoot;
    }

    else if(this.ranks[valueTwoRoot] < this.ranks[valueOneRoot]){
      this.parents[valueTwoRoot] = valueOneRoot;
    }
    //Having same height
    else{
      this.parents[valueTwoRoot] = valueOneRoot;
      this.ranks[valueOneRoot]++;
    }
    return true;
  }
}

//TC: (Find / Union): O(Inverse Ackermann Function(n))
//SC: (Find / Union): O(Inverse Ackermann Function(n)) due to recursion + O(n) for storing parents & ranks
