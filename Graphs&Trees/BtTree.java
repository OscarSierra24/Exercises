class BtTree {
  BtNode root;

  public BtTree() {
    this.root = null;
  }

  public BtNode getRoot() {
    return this.root;
  }

  public boolean isEmpty() {
    if (this.root == null) {
      return true;
    } else {
      return false;
    }
  }

  public BtTree(int value) {
    this.root = new BtNode(value);
  }

  public BtNode add(int value) {
    BtNode newNode = new BtNode(value);
    BtNode current = this.root;

    if (current == null) {
      this.root = newNode;
      return this.root;
    }

    while (current != null) {
      if (newNode.value > current.value) {
        if (current.right != null) {
          current = current.right;
        } else {
          newNode.parent = current;
          current.right = newNode;
          break;
        }
      } else {
        if (current.left != null) {
          current = current.left;
        } else {
          newNode.parent = current;
          current.left = newNode;
          break;
        }
      }
    }

    return newNode;
  }

  private void printInorder(BtNode node) {
    if (node == null) {
      return;
    }

    printInorder(node.left);
    System.out.println(node.value);
    printInorder(node.right);
  }

  public void printInorder(){
    printInorder(this.root);
  }
}