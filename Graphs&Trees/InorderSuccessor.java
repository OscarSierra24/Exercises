class InorderSuccessor {

  private static BtNode getLeftmostNode(BtNode node) {
    BtNode current = node;
    while (current.left != null) {
      current = current.left;
    }
    return current;
  }

  public static BtNode getInorderSuccessor(BtNode node) {
    // if node has right subtree return leftmost node of rightsubtree
    if (node.right != null) {
      return getLeftmostNode(node.right);
    }
    //if there's no right subtree then we must go up according to inorder states (left -> current -> right)
    //so visit parent until parent value > node value 
    BtNode itParent = node.parent;
    while (itParent != null) {
      if (itParent.value > node.value) {
        return itParent;
      }
      itParent = itParent.parent;
    }
    return null;
  }

  public static void main(String[] args) {
    BtTree tree = new BtTree();
    BtNode n6 = tree.add(6);
    BtNode n4 = tree.add(4);
    BtNode n8 = tree.add(8);
    BtNode n2 = tree.add(2);
    BtNode n5 = tree.add(5);
    BtNode n7 = tree.add(7);
    BtNode n9 = tree.add(9);
    BtNode n1 = tree.add(1);
    BtNode n3 = tree.add(3);

    System.out.println(getInorderSuccessor(n1));
    System.out.println(getInorderSuccessor(n2));
    System.out.println(getInorderSuccessor(n3));
    System.out.println(getInorderSuccessor(n4));
    System.out.println(getInorderSuccessor(n5));
    System.out.println(getInorderSuccessor(n6));
    System.out.println(getInorderSuccessor(n7));
    System.out.println(getInorderSuccessor(n8));
    System.out.println(getInorderSuccessor(n9));

  }
}