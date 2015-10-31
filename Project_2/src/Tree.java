import java.io.PrintStream;

/**
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Tree {

	private Node overallRoot; // null for an empty tree

	/**
	 * Base constructor for Tree.
	 */
	public Tree() {
		overallRoot = null;
	}

	/**
	 * Inserts a call with a given priority
	 */
	public void insert(Ticket ticketToAdd) {
		// Any attempt to insert a ticket with the same priority as one already
		// in the queue should generate a warning.
		// Add based off of a ticket's priority
		overallRoot = add(overallRoot, ticketToAdd);
	}

	public Node add(Node root, Ticket ticketToAdd) {
		if (root == null) {
			root = new Node(ticketToAdd);
		} else if (ticketToAdd.getPriority() < root.data.getPriority()) {
			root.left = add(root.left, ticketToAdd);
		} else {
			root.right = add(root.right, ticketToAdd);
		}
		root.data.changeDescendants(1);
		return root;
	}

	
	
	
	
	/**public boolean remove (int p) {
		if (overallRoot == null || !contains(p)) //if the tree is null or the priority is not in the tree.
			return false;
		if (overallRoot.data.getPriority() == p) {
			Node temp = new Node(null);
			temp.left = overallRoot;
			remove(p, temp);
			overallRoot = temp.left;
			return true;
		} else {
			remove(p, overallRoot);
			return true;
		}
	}
	
	private void remove (int p, Node root) {
		if (p == root.data.getPriority())
			removeByCase(root);
		else if (p < root.data.getPriority())
			remove(p, root.left);
		else // p > root.data.getPriority()
			remove(p, root.right);
	}
	
	
	
	private void removeByCase(Node root) {
		if (hasTwoChildren(root)) {
			Node followingNode = removeNextInOrder(root.right);
			set(root, followingNode);
			remove(followingNode.data.getPriority(), root.right);
		} else if ( root.right == null) {
			System.out.println( "I made it to the point where I will remove 2" );
			root = root.left;
			if (root == null)
				System.out.println( "The place where was is now null"  );
			printInorder(overallRoot);
			System.out.println();
			
		}
		else if (root.left == null)
			root = root.right;
		else
			root = null;
	} */
	
	public void remove(int p) {
		int temp = overallRoot.data.getPriority();
		overallRoot = remove(overallRoot, p);
		if (overallRoot.data.getPriority() != temp);
			overallRoot.data.changeDescendants(1);
	}
	
	private Node remove (Node root, int p) {
		if (root == null) {
			//empty tree or value not found, so there is nothing to do.
		} else if (root.data.getPriority() < p) {
			//value could be in the right subtree, lets go in.
			root.right = remove(root.right, p);
		} else if (root.data.getPriority() > p) {
			// value could be in the left subtree, lets go in.
			root.left = remove(root.left, p);
		} else {
			// root.data.getPriority() == p, this is the node to remove.
			if (root.left == null && root.right == null) {
				//Case 1: leaf, replace with null
				root = null;
			} else if (root.right == null ) {
				//Case 2: left child only; replace with a left child
				root = root.left;
			} else if (root.left == null) {
				//Case 3: right child only; replace with right child
				root = root.right;
			} else {
				//Case 4: both children, replace with next in-order from right subtree
				Node followingNode = removeNextInOrder(root.right);
				set(root, followingNode);
				root.right = remove(root.right, followingNode.data.getPriority());
			}
		}
		
		if (root != null) {
			root.data.changeDescendants(-1);
		}
		return root;
	}
	
	
	

	
	
	
	
	
	
	
	
	private boolean isInternal (Node root) {
		return (root.left != null || root.right != null);
	}
	
	private boolean hasTwoChildren(Node root){
		return (root.left != null && root.right != null);
	}
	
	private void set(Node dest, Node source) {
		dest.data.setPriority(source.data.getPriority());
		dest.data.setId(source.data.getId());
	}
	
	private Node removeNextInOrder(Node root) { // L H R
		if (root.left != null)
			return removeNextInOrder(root.left);
		else
			return root;
	}

	/**
	 * Identify and remove highest priority call.
	 */
	public void removeHighest() {
		// possibly return the highest priority node?
		// Finally, there should be a warning if the queue is empty when a *
		// command is issued. These warnings should read
	}

	/**
	 * Query about position in the queue (using help ticket id)
	 * 
	 * @param priority
	 * @return
	 */
	public int query(int priority) {
		int descendants = (search(overallRoot, priority).data.getDescendants());
		return ( (overallRoot.data.getDescendants()) - descendants);
	}

	public Node search(Node current, int priority){
		if(current.data.getPriority() == priority){
			return current;
		} else if(current.data.getPriority() > priority){
			return search(current.left, priority);
		} else { // if(current.data.getPriority() < priority)
			return search(current.right, priority);
		}
	}
	
	/**
	 * Checks if the tree contains a node.
	 * 
	 * @return true if tree does contain, false if not.
	 */
	public boolean contains( int p) {
		return true;
	}

	/**
	 * Returns the current root of the tree.
	 * 
	 * @return root of tree.
	 */
	public Node getRoot() {
		return this.overallRoot;
	}

	/**
	 * Sets method for root field.
	 * 
	 * @param root
	 *            to set this.root to.
	 */
	public void setRoot(Node root) {
		this.overallRoot = root;
	}
	
	public void printInorder(Node root){
		if( root != null){
			printInorder(root.left);
			System.out.print(" " + root.data.getPriority() + "[" + root.data.getDescendants() + "]");
			printInorder(root.right);
		}
	}

/** ------------------------------------THIS IS CODE GIVEN TO US ------------------------------------------*/
	
	/**
	 * This is just a code fragment to illustrate a way to print a binary search
	 * tree. prints the subtree rooted at v using the given indenting printer
	 */
	/**protected void recursiveInOrderPrint(BTPosition v, IndentPrinter printer) {
		checkPosition(v);
		if (hasRight(v)) {
			printer.increaseIndent();
			BTPosition rv = right(v);
			recursiveInOrderPrint(rv, printer);
			printer.decreaseIndent();
		}
		printer.println("-- value  = " + v.element());
		if (hasLeft(v)) {
			printer.increaseIndent();
			BTPosition lv = left(v);
			recursiveInOrderPrint(lv, printer);
			printer.decreaseIndent();
		}
	} */

	/**
	 * prints the tree using inorder indenting subtree below each node; uses
	 * backward inorder so that turning the printout sideways has the correct
	 * left/right orientation
	 * 
	 * @param ps
	 *            where to print
	 * @param indentString
	 *            what to print for each indentation level
	 */
	/**public void inOrderPrint(PrintStream ps, String indentString) {
		if (root == null) {
			ps.println("EMPTY TREE");
			return;
		}
		IndentPrinter printer = new IndentPrinter(ps, indentString);
		recursiveInOrderPrint(root, printer);
	} */

	/**
	 * Node Class for Tree.
	 * 
	 * @author Thomas Ortiz
	 * @author Michael Mackrell
	 * @author Jacob Stone
	 * @author Curtis Moore
	 */
	public class Node {
		public Ticket data; // data stored at this node
		public Node left; // reference to left subtree
		public Node right; // reference to right subtree

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
		}
	}
}
