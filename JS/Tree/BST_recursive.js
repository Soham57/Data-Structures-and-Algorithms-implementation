class Node {
    constructor(value) {
        this.val = value;
        this.right = null;
        this.left = null;
    }
}

class Tree {
    constructor() {
        this.root = null;
    }

    search(target, root = this.root) {
        if (target === null || target === undefined) {
            throw new Error("Target cannot be null or undefined");
        }

        if (!root) {
            return false;
        }

        if (target < root.val) {
            return this.search(target, root.left);
        } else if (target > root.val) {
            return this.search(target, root.right);
        } else {
            return true;
        }
    }

    insert(val, root = this.root) {
        if (!root) {
            this.root = new Node(val);
            return this.root;
        }
    
        if (val < root.val) {
            if (!root.left) {
                root.left = new Node(val);
            } else {
                root.left = this.insert(val, root.left);
            }
        } else if (val > root.val) {
            if (!root.right) {
                root.right = new Node(val);
            } else {
                root.right = this.insert(val, root.right);
            }
        }
        return root;
    }
    

    remove(val, root = this.root) {
        if (!root) {
            return null;
        }

        if (val > root.val) {
            root.right = this.remove(val, root.right);
        } else if (val < root.val) {
            root.left = this.remove(val, root.left);
        } else {
            if (root.left === null) {
                return root.right;
            } else if (root.right === null) {
                return root.left;
            } else {
                let minNode = this.minValueNode(root.right);
                root.val = minNode.val;
                root.right = this.remove(minNode.val, root.right);
            }
        }
        return root;
    }

    minValueNode(node) {
        let current = node;
        while (current.left !== null) {
            current = current.left;
        }
        return current;
    }
}
