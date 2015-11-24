/**
 * Represents a node/vertex in a graph.
 * 
 * @author Curtis Moore
 */
public class Vertex {

	/** Array containing all the edges of the node */
	private GenericList<Vertex> adjVertices;
	/** ID of the node, an String*/
	private String id;
	/** Determines if the vertex is marked or not */
	private boolean marked;
	private double popularity;
	private Vertex backPointer;

	/**
	 * Contructs the node with the given ID.
	 *
	 * @param id
	 *            of node to be created.
	 */
	public Vertex(String id) {
		this.id = id;
		this.marked = false;
		adjVertices = new GenericList<Vertex>();
		this.backPointer = null;
	}

	/**
	 * Constructs the node with given ID. Links it to given second node.
	 *
	 * @param id
	 *            of node to be created.
	 * @param node2
	 *            node that this will be linked to.
	 */
	//public Node(String id, Node node2) {
		//this(id);
		//adjNodes.add(new Node(this, node2));
	//}

	/**
	 * Returns ID of this node.
	 *
	 * @return id of this node.
	 */
	public String getid() {
		return this.id;
	}

	/**
	 * Returns number of edges associated with this node.
	 *
	 * @return number of edges attached to this node.
	 */
	public int getDegree() {
		return adjVertices.size();
	}

	/**
	 * Indicates if given node is attached to this node.
	 *
	 * @param node
	 *            the node to check against.
	 * @return true if the nodes have an edge.
	 */
	public boolean isAttached(Vertex vrt) {
		for (int i = 0; i < adjVertices.size(); i++) {
			if ( adjVertices.get(i).getid().equals(vrt.getid()) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines if two nodes are the same.
	 * 
	 * @return true if the nodes have the same id.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Vertex))
			return false;
		Vertex vrt = (Vertex) o;

		return (vrt.getid() == this.getid());
	}

	/**
	 * Adds an edge to the given node.
	 *
	 * @param node
	 *            node to link to.
	 */
	//public void addLink(Node node) {
		//edges.add(new Edge(this, node));
	//}

	
	/**
	 * Basic override of default toString method.
	 * 
	 * @return string version of this node
	 */
	public String toString() {
		return "" + this.id;
	}
	
	public void setMarked (boolean flag) {
		this.marked = flag;
	}
	
	public boolean isMarked() {
		return this.marked;
	}
	
	public GenericList<Vertex> getAdjVertices() {
		return adjVertices;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	
	public Vertex getBackPointer() {
		return this.backPointer;
	}
	
	public void setBackPointer( Vertex v ) {
		this.backPointer = v;
	}

}
