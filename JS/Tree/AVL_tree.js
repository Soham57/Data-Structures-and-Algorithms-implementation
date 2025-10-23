class TreeNode{
    constructor(value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class AVLTree{
    constructor(){
        this.root = null;
    }

    getHeight(node){
        if(node === null){
            return 0;
        }
        return node.height;
    }

    getBalanceFactor(node){
        if(node === null){
            return 0;
        }

        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    updateHeight(node){
        if(node === null){
            return 
        }

        node.height = 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right))
    }

    leftRotate(y){
        const x = y.right;
        const T2 = x.left;

        x.left = y;
        y.right = T2;

        this.updateHeight(y);
        this.updateHeight(x);

        return x;
    }

    rightRotate(x){
        const y = x.left;
        const T2 = y.right;

        y.right = x;
        x.left = T2;

        this.updateHeight(x);
        this.updateHeight(y);

        return y;
    }

    insert(value) {
        this.root = this.insertNode(this.root, value);
      }
    
      insertNode(node, value) {
        if (node === null) {
          return new Node(value);
        }
    
        if (value < node.value) {
          node.left = this.insertNode(node.left, value);
        } else if (value > node.value) {
          node.right = this.insertNode(node.right, value);
        } else {
          return node; // duplicates are not allowed in AVL trees
        }
    
        // Update height of this ancestor node
        this.updateHeight(node);
    
        // Get the balance factor of this ancestor node
        const balanceFactor = this.getBalanceFactor(node);
    
        // If the node becomes unbalanced, there are four cases
    
        // Left Left Case
        if (balanceFactor > 1 && value < node.left.value) {
          return this.rightRotate(node);
        }
    
        // Right Right Case
        if (balanceFactor < -1 && value > node.right.value) {
          return this.leftRotate(node);
        }
    
        // Left Right Case
        if (balanceFactor > 1 && value > node.left.value) {
          node.left = this.leftRotate(node.left);
          return this.rightRotate(node);
        }
    
        // Right Left Case
        if (balanceFactor < -1 && value < node.right.value) {
          node.right = this.rightRotate(node.right);
          return this.leftRotate(node);
        }
    
        return node;
      }
    
      remove(value) {
        this.root = this.removeNode(this.root, value);
      }
    
      removeNode(node, value) {
        if (node === null) {
          return node;
        }
    
        if (value < node.value) {
          node.left = this.removeNode(node.left, value);
        } else if (value > node.value) {
          node.right = this.removeNode(node.right, value);
        } else {
          if (node.left === null || node.right === null) {
            const tempNode = node.left ? node.left : node.right;
    
            if (tempNode === null) {
              node = null;
            } else {
              node = tempNode;
            }
          } else {
            const tempNode = this.getMinValueNode(node.right);
            node.value = tempNode.value;
            node.right = this.removeNode(node.right, tempNode.value);
          }
        }
    
        if (node === null) {
          return node;
        }
    
        // Update the height of the current node
        this.updateHeight(node);
    
        // Get the balance factor of this node
        const balanceFactor = this.getBalanceFactor(node);
    
        // If the node becomes unbalanced, there are four cases
    
        // Left Left Case
        if (balanceFactor > 1 && this.getBalanceFactor(node.left) >= 0) {
          return this.rightRotate(node);
        }
    
        // Left Right Case
        if (balanceFactor > 1 && this.getBalanceFactor(node.left) < 0) {
          node.left = this.leftRotate(node.left);
          return this.rightRotate(node);
        }
    
        // Right Right Case
        if (balanceFactor < -1 && this.getBalanceFactor(node.right) <= 0) {
          return this.leftRotate(node);
        }
    
        // Right Left Case
        if (balanceFactor < -1 && this.getBalanceFactor(node.right) > 0) {
          node.right = this.rightRotate(node.right);
          return this.leftRotate(node);
        }
    
        return node;
      }
    
      getMinValueNode(node) {
        let current = node;
        while (current.left !== null) {
          current = current.left;
        }
        return current;
      }
    
      // Function to perform an in-order traversal of the tree
      inOrderTraversal() {
        this.inOrderHelper(this.root);
      }
    
      inOrderHelper(node) {
        if (node !== null) {
          this.inOrderHelper(node.left);
          console.log(node.value);
          this.inOrderHelper(node.right);
        }
      }
    }