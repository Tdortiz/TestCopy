/**
 * Represents an edge in a graph. More or less a link to two different nodes.
 *
 * @author Curtis moore
 */
public class Edge {

	/** array of nodes this edge connects */
	private Node[] nodes;

	/**
	 * Constructs this edge as a link between given nodes.
	 *
	 * @param node1
	 *            first node to link.
	 * @param node2
	 *            second node to link to.
	 */
	public Edge(Node node1, Node node2) {
		nodes = new Node[2];
		nodes[0] = node1;
		nodes[1] = node2;
	}

	/**
	 * True if this node has a link to the given node.
	 *
	 * @return true if this edge links the given node.
	 */
	public boolean contains(Node node) {
		return (nodes[0].equals(node) || nodes[1].equals(node));
	}

	/**
	 * @returns the first node.
	 */
	public Node getFirstNode() {
		return nodes[0];
	}

	/**
	 * @returns the second node.
	 */
	public Node getSecondNode() {
		return nodes[1];
	}

	/**
	 * Given a node, tells you the other node. Or null if the given node DNE.
	 *
	 * @param node
	 *            that is not returned
	 * @return the node other than the given, or null if the given node is not
	 *         on this graph.
	 */
	public Node getOtherNode(Node node) {
		if (nodes[0].equals(node)) {
			return nodes[1];
		}
		if (nodes[1].equals(node)) {
			return nodes[0];
		}
		return null;
	}

	/**
	 * Basic override of default equals method.
	 * 
	 * @return true if the object passed in is equal to the current one.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Edge))
			return false;
		Edge edge = (Edge) o;

		return (edge.getFirstNode().equals(this.getFirstNode()) && edge.getSecondNode().equals(this.getSecondNode()));
	}

}