import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Michael MacKrell
 *
 */
public class GraphTest {
	
	/**
	 * first node used for testing
	 */
	private Node node1 = new Node(2);
	/**
	 * second node used for testing
	 */
	private Node node2 = new Node(69);
	/**
	 * edge used for testing, composed
	 * of nodes 1 and 2
	 */
	private Edge e1 = new Edge(node1, node2);
	
	
	private ArrayList<Node> allTheNodes;
	private ArrayList<Edge> allTheEdges;

	
	/**
	 * tests to see if the graph has no edges
	 * or nodes. Should work well because there
	 * are no nodes or edges intantiazed in the
	 * graph
	 */
	@Test
	public void testIsEmpty() {
		Graph g = new Graph();
		assertEquals(true, g.isEmpty());

	}

	/**
	 * test for the method to add edges to a graph.
	 * Tested by adding a node to the graph then
	 * checking to see that isEmpty is false
	 */
	@Test
	public void testAdd() {
		Graph g = new Graph();
		assertEquals(true, g.isEmpty());
		
		g.add(e1);
		assertEquals(false, g.isEmpty());
		
	}

	/**
	 * test to see if edgeexists works
	 * add an edge and if it exists then the
	 * method works
	 */
	@Test
	public void testEdgeExists() {
		Graph g = new Graph();
		assertEquals(true, g.isEmpty());
		
		g.add(e1);
		assertEquals(true, g.edgeExists(e1));
	}

	/**
	 * test to see if nodeexists works.
	 * Add an edge and test to see if the two nodes
	 * in that edge exist. If true, the method works
	 */
	@Test
	public void testNodeExists() {
		Graph g = new Graph();
		assertEquals(true, g.isEmpty());
		
		g.add(e1);
		assertEquals(true, g.nodeExists(node1));
		assertEquals(true, g.nodeExists(node2));
		
	}

	/**
	 * tests the getnode method by adding an
	 * edge to the tree and seeing if the nodes
	 * in the edge are returned when the method is
	 * called
	 */
	@Test
	public void testGetNode() {
		Graph g = new Graph();
		assertEquals(true, g.isEmpty());
		
		g.add(e1);
		
		assertEquals(node2, g.getNode(69));
	}

	
	@Test
	public void testGetNodeArray() {
		fail("Not yet implemented");
	}

	/**
	 * tests the removeedge method by adding an edge,
	 * checking to see if it is added, removing it, then 
	 * checking to see if the graph is empty
	 */
	@Test
	public void testRemoveEdge() {
		Graph g = new Graph();
		assertEquals(true, g.isEmpty());
		
		g.add(e1);
		g.removeEdge();
		
		assertEquals(true, g.isEmpty());
	}

	@Test
	public void testRemoveHigestNode() {
		fail("Not yet implemented");
	}

}
