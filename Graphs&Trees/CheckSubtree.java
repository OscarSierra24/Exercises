import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/* Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl .
A tree T2 is a subtree of T1 if there exists a node n in Tl such that the subtree of n is identical to T2 .
That is, if you cut off the tree at node n, the two trees would be identical.
*/

class CheckSubtree {
  private static LinkedList<BtNode> getPreorderList(BtTree tree) {
    if (tree.root == null) {
      return null;
    }

    LinkedList<BtNode> list = new LinkedList<BtNode>();  
    Stack<BtNode> stack = new Stack<>();
    stack.add(tree.root);
    BtNode current;
    while (!stack.isEmpty()) {
      current = stack.pop();
      list.add(current);
      
      if (current.right != null) {
        stack.add(current.right);
      }
      if (current.left != null) {
        stack.add(current.left);
      }
    }
    
    return list;
  }

  public static boolean isSubtree(BtTree tree, BtTree subtree) {
    Stack<BtNode> stack = new Stack<>(); 
    Stack helper;
    if (tree.root == null) {
      if (subtree == null) {
        return true;
      }
      return false;
    }

    LinkedList<BtNode> list = getPreorderList(subtree);
    System.out.println(list);
    BtNode current = tree.root;
    Iterator<BtNode> i = list.iterator();

    while (!stack.isEmpty() || current != null) {
      while (current != null) {
        stack.add(current);
        System.out.println(current.value);
        
        if (!i.hasNext()) { //when finish iterating we know subtree exists in tree
          return true;
        } else {
          if (i.next().value != current.value) {
            i = list.iterator(); //reset iterator
          }
        }

        current = current.left;
      }
      if (!stack.isEmpty()) {
        current = stack.pop();
        current = current.right;  
      } 
    }

    if (!i.hasNext()) { //this is needed because when the subtree is a copy of tree, the first if is never reached
                        //when finish iterating we know subtree exists in tree
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    BtTree tree = new BtTree();
    BtTree subtree = new BtTree();
    
    tree.add(5);
    tree.add(3);
    tree.add(7);
    tree.add(1);
    tree.add(4);
    tree.add(6);
    tree.add(9);
    tree.add(2);
    tree.add(8);
    tree.add(10);

    subtree.add(1);
    subtree.add(0);
    subtree.add(3);
  
    System.out.println(isSubtree(tree, subtree));

  }
}