class CheckBalanced {

  private static int getHeight(BtNode node, int height) {
    if (node == null) {
      return height;
    }

    return Math.max(getHeight(node.left, 1 + height), getHeight(node.right, 1 + height));
  }

  public static int getHeight(BtTree tree) {
    return getHeight(tree.getRoot(), -1);
  }

  private static int checkHeight(BtNode node, int height) throws Exception{
    if (node == null) {
      return height;
    }

    int leftH = getHeight(node.left, 1 + height);
    int rightH = getHeight(node.right, 1 + height);
    
    if (Math.abs(leftH - rightH) > 1) {
      throw new Exception("height difference is bigger than one");
    }

    int maxHeight = Math.max(leftH, rightH);
    return maxHeight;
  }

  private static boolean isBalanced(BtNode node) {
    try {
      if (Math.abs(checkHeight(node.getLeft(), -1) - checkHeight(node.getRight(), -1)) > 1) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isBalanced(BtTree tree) {
    if (tree.isEmpty()) {
      return true;
    }
    
    return isBalanced(tree.getRoot());
  }

  public static void main(String[] args) {
    BtTree tree = new BtTree();
    tree.add(6);    
    tree.add(4);    
    tree.add(8);    

    tree.add(2);    
    tree.add(5);    
    tree.add(7);    
    tree.add(9);    
    tree.add(1);    
    tree.add(3);    

    System.out.println(getHeight(tree));
    System.out.println(isBalanced(tree));

    tree = new BtTree();
    tree.add(6);    
    tree.add(7);    
    tree.add(8);    
    System.out.println(isBalanced(tree));

    tree = new BtTree();
    System.out.println(isBalanced(tree));

    tree = new BtTree();
    tree.add(6);    
    tree.add(5);    
    tree.add(4);    
    System.out.println(isBalanced(tree));

  }
}