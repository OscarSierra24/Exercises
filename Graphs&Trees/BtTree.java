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

  public BtNode add(BtNode newNode) {
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

  public BtNode add(int value) {
    BtNode newNode = new BtNode(value);
    return add(newNode);
  }

  public void printInorder() {
    printInorder(this.root);
  }

  private void printInorder(BtNode node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.println(node.value);
    printInorder(node.right);
  }

  public void printPreorder() {
    printPreorder(this.root);
  }

  public void printPreorder(BtNode node) {
    if (node == null) {
      return;
    }

    System.out.println(node.value);
    printPreorder(node.left);
    printPreorder(node.right);
  }

  public void printPostorder(){
    printPostorder(this.root);
  }

  private void printPostorder(BtNode node) {
    if (node == null) {
      return;
    }

    printPostorder(node.left);
    printPostorder(node.right);
    System.out.println(node);
  }

}