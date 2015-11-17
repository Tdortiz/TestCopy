import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the Edge class of the project
 * @author Michael MacKrell
 * @author Jacob Stone
 * @author Curtis Moore
 * @author Thomas Ortiz
 *
 */
public class EdgeTest {

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
	

	/**
	 * test for contains. Makes sure that the 
	 * contains method can tell whether or not 
	 * an edge contains a specific node
	 */
	@Test
	public void testContains() {
		
		
		assertEquals(true, e1.contains(node1));
		assertEquals(true, e1.contains(node2));
	}

	/**
	 * test for getfirstnode. Makes sure that the first 
	 * node of the edge is returned when called
	 */
	@Test
	public void testGetFirstNode() {
		assertEquals(node1, e1.getFirstNode());
	}

	/**
	 * test for getsecondnode. Makes sure that the second
	 * node of the edge is returned when called
	 */
	@Test
	public void testGetSecondNode() {
		assertEquals(node2, e1.getSecondNode());
	}

	/**
	 * test for getothernode. Makes sure that the second
	 * node is returned when the first node is passed in
	 * and vice versa
	 */
	@Test
	public void testGetOtherNode() {
		assertEquals(node2, e1.getOtherNode(node1));
		assertEquals(node1, e1.getOtherNode(node2));
	}
	
	

}
