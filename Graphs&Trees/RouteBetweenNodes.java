import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RouteBetweenNodes {
  class Graph {
    Set<Node> nodes;
    
    public Graph() {
      this.nodes = new HashSet<Node>();
    }

    public void addVertex(Node newNode) {
      this.nodes.add(newNode);
    }

    public void addEdge(Node a, Node b) {
      if (this.nodes.contains(a) && this.nodes.contains(b)) {
        a.neighbors.add(b);
        b.neighbors.add(a);
      } else {
        System.out.println("Error: there's a node that does not exists in the graph");
      }
    }

    
    public void bfs(Node node) {
      Queue<Node> queue = new LinkedList<Node>(); 
      HashSet<Node> visited = new HashSet<>();
      Node current;
      
      queue.add(node);
      visited.add(node);

      while (!queue.isEmpty()) {
        current = queue.remove();
        
        for (Node neighbor : current.neighbors) {  
          if (!visited.contains(neighbor)) {
            visited.add(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    public boolean existsRouteBetweenNodes(Node a, Node b) {
      Queue<Node> queueA = new LinkedList<Node>();
      Queue<Node> queueB = new LinkedList<Node>();
      HashSet<Node> visitedA = new HashSet<>();
      HashSet<Node> visitedB = new HashSet<>();
      
      Node current;

      queueA.add(a);
      queueB.add(b);
      visitedA.add(a);
      visitedB.add(b);

      boolean isATurn = false;
      while (!queueA.isEmpty() || !queueB.isEmpty()) {
        isATurn = !isATurn;
        if (isATurn && !queueA.isEmpty()) {
          current = queueA.remove();  
          
          for (Node neighbor : current.neighbors) {
            if (visitedB.contains(neighbor)) {
              return true;
            } 

            if (!visitedA.contains(neighbor)) {
              visitedA.add(neighbor);
              queueA.add(neighbor);
            }
          }
        } else if (!queueB.isEmpty()) {
          current = queueB.remove();

          for (Node neighbor : current.neighbors) {
            if (visitedA.contains(neighbor)) {
              return true;
            } 

            if (!visitedB.contains(neighbor)){
              visitedB.add(neighbor);
              queueB.add(neighbor);
            }
          }
        } 
      }

      return false;
    }
  }

  class Node {
    String value;
    ArrayList<Node> neighbors;

    public Node(String value) {
      this.value = value;
      neighbors = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    RouteBetweenNodes.Graph graph = new RouteBetweenNodes().new Graph();
    
    RouteBetweenNodes.Node a = new RouteBetweenNodes().new Node("1");
    RouteBetweenNodes.Node b = new RouteBetweenNodes().new Node("2");
    RouteBetweenNodes.Node c = new RouteBetweenNodes().new Node("3");
    RouteBetweenNodes.Node d = new RouteBetweenNodes().new Node("4");
    RouteBetweenNodes.Node e = new RouteBetweenNodes().new Node("5");
    RouteBetweenNodes.Node f = new RouteBetweenNodes().new Node("6");
    
    graph.addVertex(a);
    graph.addVertex(b);
    graph.addVertex(c);
    graph.addVertex(d);
    graph.addVertex(e);

    graph.addEdge(a, b);
    graph.addEdge(a, c);
    graph.addEdge(c, e);
    graph.addEdge(e, d);
    

    System.out.println(graph.existsRouteBetweenNodes(a, d));
    System.out.println(graph.existsRouteBetweenNodes(a, f));

  }
}