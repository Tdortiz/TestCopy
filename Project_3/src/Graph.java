import java.util.ArrayList;

public class Graph {

  private ArrayList<Node> nodes;
  private ArrayList<Edge> edges;
  
  /**
   * Constructs graph.
   */
  public Graph(){
    nodes = new ArrayList<Node>();
    edges = new ArrayList<Edge>();
  }
  
  public boolean isEmpty() {
    
    return nodes.isEmpty() && edges.isEmpty();
  
  }
  
  //adds given edge.
  public void add(Edge edge){
    edges.add(edge);
    nodes.add(edge.getFirstNode());
    nodes.add(edge.getSecondNode());
  }
  
  //returns true if the graph contains this edge
  public boolean edgeExists(Edge edge) {
    
    for(int i = 0; i < edges.size(); i++){
      if(edges.get(i).equals(edge)){
        return true;
      }
    }
    return false;
  }
  
  //Returns true if the graph has this node
  public boolean nodeExists(Node node) {
    
    for(int i = 0; i < nodes.size(); i++){
      if(nodes.get(i).equals(node)){
        return true;
      }
    }
    return false;
  }
  
  /**
   * Returns the node with the given ID.
   *
   * @return node with given ID or null if absent.
   */
  public Node getNode(int nodeID){
    for(int i = 0; i < nodes.size(); i++){
      if(nodes.get(i).getid() == nodeID){
        return nodes.get(i);
      }
    }
    return null;
  }
  
  //returns the array of nodes. Used in printing.
  public ArrayList<Node> getNodeArray(){
    return nodes;
  }
  
  public Edge getRemoveEdge(){
    Edge removed = edges.remove(0);
    nodes.remove(removed.getFirstNode());
    nodes.remove(removed.getSecondNode());
    return removed;
  }
  
  public Node getRemoveHigestNode() {
    
    Node max;
    return null;
  }

}