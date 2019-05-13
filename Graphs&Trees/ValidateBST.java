import java.util.Stack;

//Validate 8ST: Implement a function to check if a binary tree is a binary search tree.

class ValidateBST {
  public static boolean validateBST(BtTree tree) {
    if (tree.isEmpty()) {
      return true;
    }

    Stack<BtNode> stack = new Stack<>();
    stack.push(tree.getRoot());
    BtNode current = tree.getRoot().getLeft();
    BtNode prev = null;
    while (!stack.isEmpty() || current != null) {

      while (current != null) {
        stack.push(current);
        current = current.getLeft();
      }
      

      current = stack.pop();
      if (current != null && prev != null) {
        if (prev.value > current.value) {
          return false;
        }
      }
      if (current != null) {
        prev = current;
      }

      current = current.getRight();

    }

    return true;
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
       

    System.out.println(validateBST(tree));
    
  }
}