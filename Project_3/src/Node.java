import java.util.ArrayList;

/**
 * Represents a node/vertex in a graph.
 * 
 * @author Curtis Moore
 */
public class Node {

	/** Array containing all the edges of the node */
	private GenericList<Edge> edges;
	/** ID of the node, an String*/
	private String id;
	
	private boolean marked;

	/**
	 * Contructs the node with the given ID.
	 *
	 * @param id
	 *            of node to be created.
	 */
	public Node(String id) {
		this.id = id;
		this.marked = false;
		edges = new GenericList<Edge>();
	}

	/**
	 * Constructs the node with given ID. Links it to given second node.
	 *
	 * @param id
	 *            of node to be created.
	 * @param node2
	 *            node that this will be linked to.
	 */
	public Node(String id, Node node2) {
		this(id);
		edges.add(new Edge(this, node2));
	}

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
		return edges.size();
	}

	/**
	 * Indicates if given node is attached to this node.
	 *
	 * @param node
	 *            the node to check against.
	 * @return true if the nodes have an edge.
	 */
	public boolean isAttached(Node node) {
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).contains(node)) {
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
		if (!(o instanceof Node))
			return false;
		Node node = (Node) o;

		return (node.getid() == this.getid());
	}

	/**
	 * Adds an edge to the given node.
	 *
	 * @param node
	 *            node to link to.
	 */
	public void addLink(Node node) {
		edges.add(new Edge(this, node));
	}

	
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
	
	public GenericList<Edge> getEdges() {
		return edges;
	}

}
