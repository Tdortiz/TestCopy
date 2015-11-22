public class Graph {

	private GenericList<Vertex> vertices;
	private GenericList<Edge> edges;

	/**
	 * Constructs graph.
	 */
	public Graph() {
		vertices = new GenericList<Vertex>();
		edges = new GenericList<Edge>();
	}

	/**
	 * True if the graph is empty.
	 * 
	 * @return true if the graph is empty.
	 */
	public boolean isEmpty() {

		return vertices.isEmpty() && edges.isEmpty();

	}

	/**
	 * Adds given edge to graph.
	 * 
	 * @param edge
	 *            to add to graph
	 */
	//public void add(Edge edge) {
		//edges.add(edge);
		//vertices.add(edge.getFirstNode());
		//vertices.add(edge.getSecondNode());
	//}

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
	public boolean VertexExists(Vertex vtr) {

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).equals(vtr)) {
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
	public Vertex getVertex(String nodeID) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getid().equals(nodeID) ) {
				return vertices.get(i);
			}
		}
		return null;
	}

	/**
	 * returns the array of nodes. Used in printing.
	 * 
	 * @return arrayList of nodes.
	 */
	public GenericList<Vertex> getVertexArray() {
		return vertices;
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
	public Vertex removeHigestNode() {

		Vertex max;
		return null;
	}
	
	/**
	 * Determines if person1 is a friend of person2
	 * @param person1
	 * @param person2
	 * @return
	 */
	public boolean isFriend( Vertex person1, Vertex person2 ) {
		return person1.isAttached(person2);
	}
	
	
	public String relation (Vertex person1, Vertex person2 ) {
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(person1);
		person1.setMarked(true);
		
		boolean sameCom = false;
		String shortestPath = "";
		
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			shortestPath += current.getid() + "\n";
			if ( current.getid().equals(person2.getid()) ) {
				sameCom = true;
				break;
			}
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
				}
			}
		}
		
		if (sameCom) {
			return shortestPath;
		} else {
			return "";
		}
		
	}
	
	public String mutual (Vertex person1, Vertex person2 ) {
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(person1);
		person1.setMarked(true);
		
		boolean sameCom = false;
		String shortestPath = "";
		
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			
			
			if ( current.getid().equals(person2.getid()) ) {
				sameCom = true;
				break;
			}
			
			if ( !( current.getid().equals(person1.getid()) ) ) {
				shortestPath += current.getid() + "\n";
			}
			
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
				}
			}
		}
		
		if (sameCom) {
			return shortestPath;
		} else {
			return "";
		}
	}
	
	
	public int notConnected() {
		int loners = 0;
		int notCon = 1;
		int componetNodes = 0;
		
		GraphIterator<Vertex> vrtList = vertices.iterator();
		
		while (vrtList.hasNext()) {
			Vertex current = vrtList.next();
			if (!current.isMarked()) {
				componetNodes = findComponentNodes(current);
				if ( componetNodes == 1 ) {
					loners++;
				} else {
					notCon *= componetNodes;
				}
			}
		}
		
		int notConLoners = loners * (vertices.size() - 1);
		notCon += notConLoners;
		
		return notCon;
	}
	
	public int findComponentNodes( Vertex person ) {
		int count = 0;
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(person);
		person.setMarked(true);
		count++;
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void unmark(){
		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).setMarked(false) ;
		}
	}
}
