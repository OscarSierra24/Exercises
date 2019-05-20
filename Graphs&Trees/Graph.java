import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  }
}