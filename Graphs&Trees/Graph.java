import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Graph {
  private Map<GNode, List<GNode>> adjList;

  public Graph() {
    this.adjList = new HashMap<>(); 
  }

  void addNode(int value) {
    this.adjList.putIfAbsent(new GNode(value), new ArrayList<>());
  }

  void printGraph() {
    System.out.println(adjList);
  }

  void addEdge(int valueA, int valueB) {
    GNode nodeA = new GNode(valueA);
    GNode nodeB = new GNode(valueB);

    adjList.get(nodeA).add(nodeB);
  }

  List<GNode> getAdjNodes(int value) {
    return adjList.get(new GNode(value));
  }

  void removeEdge(int valueA, int valueB) {
    GNode nodeA = new GNode(valueA);
    GNode nodeB = new GNode(valueB);

    List<GNode> adjNodeA = adjList.get(nodeA);
    List<GNode> adjNodeB = adjList.get(nodeB);
    
    if (adjNodeA != null) {
      adjNodeA.remove(nodeB);
    }
    if (adjNodeB != null) {
      adjNodeB.remove(nodeA);
    }
    
  }

  void removeNode(int value) {
    this.adjList.remove(value);
  }

  public ArrayList<GNode> buildOrder() {
    //initialize structures
    ArrayList<GNode> buildOrder = new ArrayList<>();
    Queue<GNode> toBeProcessed = new LinkedList<>();
    HashMap<GNode, Integer> dependencies = new HashMap<>();

    //insert nodes to dependencies and increase dependency number if a dependency is found
    for (Map.Entry<GNode, List<GNode>> entry : this.adjList.entrySet()) {
      GNode currentNode = entry.getKey();
      if (!dependencies.containsKey(currentNode)) {
        dependencies.put(currentNode, 0);
      }
      for (GNode neighbor : entry.getValue()) {
        if (!dependencies.containsKey(neighbor)) {
          dependencies.put(neighbor, 1);
        } else {
          dependencies.put(neighbor, dependencies.get(neighbor) + 1);
        }
      }
    }
    //uncomment to see the dependency beginning
    //System.out.println(dependencies);

    //find roots and inserts them in toBeProcessed
    for (Map.Entry<GNode, Integer> entry : dependencies.entrySet()) {
      GNode currentNode = entry.getKey();
      if (dependencies.get(currentNode) == 0) {
        toBeProcessed.add(currentNode);
      }
    }
    //uncomment to see initial roots
    //System.out.println(toBeProcessed);

    while (!toBeProcessed.isEmpty()) {
      GNode current = toBeProcessed.remove();
      //System.out.println(current);
      for (GNode neighbor : this.adjList.get(current)) {
        dependencies.put(neighbor, dependencies.get(neighbor) - 1);
        if (dependencies.get(neighbor) == 0) {
          toBeProcessed.add(neighbor);
        }
      }          
      dependencies.remove(current);
      buildOrder.add(current);
    } 

    if (!dependencies.isEmpty()) {
      System.out.println("it's impossible to have a build order");
      return null;
    } else {
      return buildOrder;
    }
  }

  public static void main(String[] args) {
    //build order
    Graph graph = new Graph();
    
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    
    graph.addEdge(1, 4);
    graph.addEdge(6, 2);
    graph.addEdge(2, 4);
    graph.addEdge(6, 1);
    graph.addEdge(4, 3);

    graph.printGraph();

    ArrayList<GNode> al = graph.buildOrder();
    System.out.println(al);
  }
}