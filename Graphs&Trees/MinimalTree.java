class MinimalTree {

  class Tree {
    private Node root;

    public Tree(int value) {
      this.root = new Node(value);
    }

    public Tree() {
      this.root = null;
    }

    private void minimalTree(int l, int r, int m, Node parent, int[] values, boolean isTravellingLeft){
      if (l > r) {
        return;
      }

      //add value      
      Node newNode = new Node(values[m]);

      if (isTravellingLeft) {
        parent.left = newNode;
      } else {
        parent.right = newNode;
      }
      
      //navigate left
      minimalTree(l, m - 1, (int) Math.ceil((l + (m - 1)) / 2.0), newNode, values, true);
      //System.out.println("left end");
      //navigate right
      minimalTree(m + 1, r, (int) Math.ceil(((m + 1) + r) / 2.0), newNode, values, false);
      //System.out.println("right end");
      
    }


    public void createMinimalTree(int[] values) {
      if (values == null) {
        return;
      }

      if (this.root != null) {
        System.out.println("The tree already contain data");
        return;
      }

      int m = (int) Math.ceil(values.length / 2.0);
      this.root = new Node(values[m]);
      minimalTree(0, m - 1, (int) Math.ceil((m - 1) / 2.0), this.root, values, true);
      minimalTree(m + 1, values.length - 1, (int) Math.ceil((m - 1) / 2.0), this.root, values, false);
    }

    public Node add(int value) {
      Node node = new Node(value);

      if (this.root == null) {
        this.root = node;
        return node;
      }

      Node current = this.root;
      
      while (true) {
        if (node.getValue() > current.getValue()) {
          if (current.getRight() == null) {
            current.setRight(node);
            break;
          }
          current = current.getRight();
        } else {
          if (current.getLeft() == null) {
            current.setLeft(node);
            break;
          }
          current = current.getLeft();
        }
      }
      return node;
    }



    public void printInorder() {
      printInorder(this.root);
    }

    private void printInorder(Node node) {
      if (node == null) {
        return;
      }

      if (node.left != null) {
        printInorder(node.left);
      }

      System.out.println("v:" + node.value);

      if (node.right != null) {
        printInorder(node.right);
      }
    }

  }

  class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }

    public Node getLeft() {
      return this.left;
    }

    public Node getRight() {
      return this.right;
    }

    public int getValue() {
      return this.value;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    
    MinimalTree.Tree tree = new MinimalTree().new Tree();

    int[] array = {1,2,3,4,5,6,7,8,9,10};
    tree.createMinimalTree(array);
    tree.printInorder();
  }

}