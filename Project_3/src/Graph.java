public class Graph {

	private GraphList<Node> nodes;
	private GraphList<Edge> edges;

	/**
	 * Constructs graph.
	 */
	public Graph() {
		nodes = new GraphList<Node>();
		edges = new GraphList<Edge>();
	}

	/**
	 * True if the graph is empty.
	 * 
	 * @return true if the graph is empty.
	 */
	public boolean isEmpty() {

		return nodes.isEmpty() && edges.isEmpty();

	}

	/**
	 * Adds given edge to graph.
	 * 
	 * @param edge
	 *            to add to graph
	 */
	public void add(Edge edge) {
		edges.add(edge);
		nodes.add(edge.getFirstNode());
		nodes.add(edge.getSecondNode());
	}

	/**
	 * Returns true if the given edge is in the graph. 
	 * Runs in O(m) time.
	 * 
	 * @param edge
	 *            to search for.
	 * @return true if edge is in graph, false otherwise.
	 */
	public boolean edgeExists(Edge edge) {

		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).equals(edge)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if the graph has this node. 
	 * Runs in O(n) time.
	 * 
	 * @param node
	 *            to search for
	 * @return true if node is in graph.
	 */
	public boolean nodeExists(Node node) {

		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(node)) {
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
	public Node getNode(String nodeID) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getid().equals(nodeID) ) {
				return nodes.get(i);
			}
		}
		return null;
	}

	/**
	 * returns the array of nodes. Used in printing.
	 * 
	 * @return arrayList of nodes.
	 */
	public GraphList<Node> getNodeArray() {
		return nodes;
	}

	/**
	 * Removes an edge and returns it.
	 * 
	 * @return the removed edge
	 */
	//public Edge removeEdge() {
		//Edge removed = edges.remove(0);
		//nodes.remove(removed.getFirstNode());
		//nodes.remove(removed.getSecondNode());
		//return removed;
	//}

	/**
	 * Removes/returns highest degree node.
	 * 
	 * @return highest degree node on the graph, which has just been removed.
	 */
	public Node removeHigestNode() {

		Node max;
		return null;
	}
	
	/**
	 * Determines if person1 is a friend of person2
	 * @param person1
	 * @param person2
	 * @return
	 */
	public boolean isFriend( Node person1, Node person2 ) {
		return person1.isAttached(person2);
	}
	
	
	public void mutual (Node person1, Node person2 ) {
		
		
	}
}