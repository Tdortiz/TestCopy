public class Graph {

	private GenericList<Node> nodes;
	private GenericList<Edge> edges;

	/**
	 * Constructs graph.
	 */
	public Graph() {
		nodes = new GenericList<Node>();
		edges = new GenericList<Edge>();
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
	public GenericList<Node> getNodeArray() {
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
	
	
	public String relation (Node person1, Node person2 ) {
		Queue<Node> q = new Queue<Node>();
		q.add(person1);
		person1.setMarked(true);
		
		boolean sameCom = false;
		String shortestPath = "";
		
		
		while (!q.isEmpty()) {
			Node current = q.remove();
			shortestPath += current.getid() + "\n";
			if ( current.getid().equals(person2.getid()) ) {
				sameCom = true;
				break;
			}
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Edge> e = current.getEdges().iterator();
			
			while ( e.hasNext() ) {
				Node adj = e.next().getSecondNode();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
				}
			}
		}
		
		if (sameCom) {
			return shortestPath;
		} else {
			return "\n";
		}
		
	}
	
	public String mutual (Node person1, Node person2 ) {
		Queue<Node> q = new Queue<Node>();
		q.add(person1);
		person1.setMarked(true);
		
		boolean sameCom = false;
		String shortestPath = "";
		
		
		while (!q.isEmpty()) {
			Node current = q.remove();
			
			
			if ( current.getid().equals(person2.getid()) ) {
				sameCom = true;
				break;
			}
			
			if ( !( current.getid().equals(person1.getid()) ) ) {
				shortestPath += current.getid() + "\n";
			}
			
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Edge> e = current.getEdges().iterator();
			
			while ( e.hasNext() ) {
				Node adj = e.next().getSecondNode();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
				}
			}
		}
		
		if (sameCom) {
			return shortestPath;
		} else {
			return "\n";
		}
	}
	
}
