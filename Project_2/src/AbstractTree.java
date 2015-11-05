/**
 * AbstractTree represents an abstract binary 
 * search tree for help ticket priorities.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public abstract class AbstractTree {
	
	/** The overall root of the tree */
	protected Node overallRoot; // null for an empty tree
	
	
	/**
	 * Simple constructor for AbstractTree.
	 */
	public AbstractTree() {	
		this.overallRoot = null;
	}
	
	/**
	 * Inserts a call with a given priority.
	 * @param ticketToAdd to the tree.
	 */
	public abstract void insert(Ticket ticketToAdd);

	/**
	 * Method to remove a node given a priority p
	 * @param p the priority of the node we are removing
	 */
	public abstract void remove(int p);
	
	/**
	 * Query about position in the queue (using help ticket id)
	 * 
	 * @param priority
	 * @return
	 * */
	public abstract int query( int p );
	
	/**
	 * Checks if the tree contains a node.
	 * @param p the priority of the node to find
	 * @return true if tree does contain, false if not.
	 */
	public abstract boolean contains( int p);
	
	/**
	 * Returns whether or not a tree is empty
	 * @return true or false depending on the condition of the tree
	 */
	public abstract boolean isEmpty();
	
	/**
	 * Identify and remove highest priority call.
	 */
	public abstract void getHighest();
	
	/**
	 * Prints the tree in order
	 */
	public void printInorder() {
		printInorder(overallRoot);
	}
	
	/**
	 * Prints the tree in order given a specific root
	 * @param root the root of the tree to print
	 */
	public void printInorder(Node root){
		if( root != null){
			printInorder(root.left);
			System.out.print(" " + root.data.getPriority() + "[" + root.descendants + "]");
			printInorder(root.right);
		}
	}
	
	/**
	 * Node Class for Tree.
	 * 
	 * @author Thomas Ortiz
	 * @author Michael Mackrell
	 * @author Jacob Stone
	 * @author Curtis Moore
	 */
	protected class Node {
		public Ticket data; // data stored at this node
		public Node left; // reference to left subtree
		public Node right; // reference to right subtree
		public int descendants; // amount of descendants

		/**
		 * Constructs a leaf node with the given data.
		 * 
		 * @param data ticket
		 */
		public Node(Ticket data) {
			this(data, null, null);
		}

		/**
		 * Constructs a branch node with the given data and links.
		 * 
		 * @param data ticket
		 * @param left node
		 * @param right node
		 */
		public Node(Ticket data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.descendants = 0;
		}
	
	}
}
