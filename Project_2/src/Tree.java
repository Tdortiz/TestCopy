import java.io.PrintStream;

/**
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Tree {

	private Node root; // null for an empty tree
	
	/**
	 * Base constructor for Tree.
	 */
	public Tree(){}
	
	/**
	 * Inserts a call with a given priority
	 */
	public void insert(Node a){
		// Any attempt to insert a ticket with the same priority as one already in the queue should generate a warning.
		// Add based off of a ticket's priority 
	}
	
	/**
	 *  Remove a call (using help ticket id)
	 */
	public void remove(String helpTicketID){
		// A similar warning should be generated if there is an attempt to remove a ticket that is not in the queue
		
	}
	
	/**
	 * Identify and remove highest priority call.
	 */
	public void removeHighest(){
		// possibly return the highest priority node?
		// Finally, there should be a warning if the queue is empty when a * command is issued. These warnings should read
	}
	
	/** 
	 * Query about position in the queue (using help ticket id) 
	 * @param helpTicketID
	 * @return
	 */
	public int query(String helpTicketID){
		return 0;
	}
	
	/** 
	 * Checks if the tree contains a node.
	 * @return true if tree does contain, false if not.
	 */
	public boolean contains(){
		return false;
	}
		
	/**
	 * Returns the current root of the tree.
	 * @return root of tree.
	 */
	public Node getRoot() {
		return root;
	}
	
	/** 
	 * Sets method for root field.
	 * @param root to set this.root to.
	 */
	public void setRoot(Node root) {
		this.root = root;
	}
	
	
	
	
	
/** ------------------------------------THIS IS CODE GIVEN TO US ------------------------------------------*/	
	/**
	 * This is just a code fragment to illustrate a way to print a binary search
	 * tree. 
	 * prints the subtree rooted at v using the given indenting printer
	 */
	  protected void recursiveInOrderPrint( BTPosition v, IndentPrinter printer )
	  {
	    checkPosition(v);
	    if ( hasRight(v) )
	      {
	        printer.increaseIndent();
	        BTPosition rv = right(v);
	        recursiveInOrderPrint( rv, printer );
	        printer.decreaseIndent();
	      }
	    printer.println( "-- value  = " + v.element() );
	    if ( hasLeft(v) )
	      {
	        printer.increaseIndent();
	        BTPosition lv = left(v);
	        recursiveInOrderPrint( lv, printer );
	        printer.decreaseIndent();
	      }
	  }

	  /**
	   * prints the tree using inorder indenting subtree below each node;
	   * uses backward inorder so that turning the printout sideways has the
	   * correct left/right orientation
	   * @param ps where to print
	   * @param indentString what to print for each indentation level
	   */
	  public void inOrderPrint( PrintStream ps, String indentString )
	  {
	    if( root == null )
	      {
	        ps.println("EMPTY TREE");
	        return;
	      } 
	    IndentPrinter printer = new IndentPrinter( ps, indentString );
	    recursiveInOrderPrint( root, printer ); 
	  } 

	  /**
	   * Node Class for Tree.
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
		   *  Constructs a leaf node with the given data.
		   * @param data ticket 
		   */
		  public Node(Ticket data) {
			  this(data, null, null);
		  }
			
		  /**
		   * Constructs a branch node with the given data and links.
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