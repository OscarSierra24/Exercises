class BtNode {
  BtNode left;
  BtNode right;
  BtNode parent;
  int value; 

  public BtNode(int value) {
    this.left = null;
    this.right = null;
    this.parent = null;
    this.value = value;
  }

  public BtNode getLeft() {
    return this.left;
  }

  public BtNode getRight() {
    return this.right;
  }

  public BtNode getParent() {
    return this.parent;
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

  public void setParent(BtNode parent) {
    this.parent = parent;
  } 

  public void setValue(int value) {
    this.value = value;
  }

  public String toString() {
    return this.value + "";
  }
}