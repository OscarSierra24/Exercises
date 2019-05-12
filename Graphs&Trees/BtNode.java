class BtNode {
  BtNode left;
  BtNode right;
  int value; 

  public BtNode(int value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }

  public BtNode getLeft() {
    return this.left;
  }

  public BtNode getRight() {
    return this.right;
  }

  public int getValue() {
    return this.value;
  }

  public void setLeft(BtNode left) {
    this.left = left;
  }

  public void setRight(BtNode right) {
    this.right = right;
  }

  public void setValue(int value) {
    this.value = value;
  }
}