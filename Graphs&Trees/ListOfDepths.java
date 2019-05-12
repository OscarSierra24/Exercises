import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a 
 * linked list of all the nodes at each depth (e.g., if you have a tree
 * with depth D, you'll have D linked lists).
 */

class ListOfDepths {
 
  public static ArrayList<LinkedList<BtNode>> getLlOfDepths(BtTree tree) {
    if (tree.isEmpty()) {
      return null;
    }
    
    Queue<BtNode> queue = new LinkedList<BtNode>();
    Queue<BtNode> queueHelper = new LinkedList<BtNode>();

    LinkedList<BtNode> ll = new LinkedList<>();
    ArrayList<LinkedList<BtNode>> storedLl = new ArrayList<>();

    BtNode current = tree.getRoot();
    queue.add(current);

    while (!queue.isEmpty()) {
      while (!queue.isEmpty()) {
        current = queue.remove();
        ll.add(current);

        if (current.getLeft() != null) {
          queueHelper.add(current.getLeft());
        }
        if (current.getRight() != null) {
          queueHelper.add(current.getRight());
        }
      }

      storedLl.add(ll);
      ll = new LinkedList<BtNode>();
      
      queue = queueHelper;
      queueHelper = new LinkedList<BtNode>();
    }

    return storedLl;
  }

  public static void printNodesByDepth(BtTree tree) {
    
    int i = 0;
    ArrayList<LinkedList<BtNode>> llByDepth = getLlOfDepths(tree);
    if (llByDepth == null) {
      System.out.println("the tree is empty");
      return;
    }

    for (LinkedList<BtNode> ll : llByDepth) {
      System.out.println("---------Depth: " + i + "---------");  
      for (BtNode node : ll) {
        System.out.println("node: " + node.value);
      }
      i++;
    }
    System.out.println("--------------------------");       
  }

  public static void main(String[] args) {
    BtTree tree = new BtTree();
    
    tree.add(2);
    tree.add(1);
    tree.add(2);
    tree.add(3);
    tree.add(4);
    tree.add(2);
    tree.add(3);

    printNodesByDepth(tree);   
    
    System.out.println("next test:");
    tree = new BtTree();
    printNodesByDepth(tree);

    System.out.println("next test:");
    tree = new BtTree();
    tree.add(6);    
    tree.add(4);    
    tree.add(8);    
    tree.add(2);    
    tree.add(5);    
    tree.add(7);    
    tree.add(9);    
    tree.add(1);    
    tree.add(3);    
    printNodesByDepth(tree);

  }
}