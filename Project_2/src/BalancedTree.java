/**
 * Tree represents an balanced AVL 
 * search tree for help ticket priorities.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class BalancedTree extends AbstractTree {
	/** The overall root of the tree */
	private Node overallRoot; // null for an empty tree

	/**
	 * Base constructor for Tree.
	 */
	public BalancedTree() {
		overallRoot = null;
	}

	 /* Function to get height of node */
    private int height(Node t ){
        return t == null ? -1 : t.height;
    }
	
	/**
	 * Inserts a call with a given priority
	 */
	public void insert(Ticket ticketToAdd) {
		// Any attempt to insert a ticket with the same priority as one already
		// in the queue should generate a warning.
		// Add based off of a ticket's priority
		printInorder();
		System.out.println();
		overallRoot = addAVL(ticketToAdd, overallRoot);
		printInorder();
		System.out.println();
	}
	
	private Node addAVL(Ticket ticketToAdd, Node t){
		if (t == null)
            t = new Node(ticketToAdd);
        else if (ticketToAdd.getPriority() < t.data.getPriority())
        {
            t.left = addAVL( ticketToAdd, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( ticketToAdd.getPriority() < t.left.data.getPriority() )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }else if( ticketToAdd.getPriority() > t.data.getPriority() ){
            t.right = addAVL( ticketToAdd, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( ticketToAdd.getPriority() > t.right.data.getPriority())
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }else
          ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
	}
	  
	/**
	 * Method to remove a node given a priority p
	 * @param p the priority of the node we are removing
	 */
	public void remove(int p) {
		int temp = overallRoot.data.getPriority();
		overallRoot = remove(overallRoot, p);
		if (overallRoot != null) {
			if (overallRoot.data.getPriority() != temp);
				(overallRoot.descendants)++; //overallRoot.data.changeDescendants(1);
		}
	}
	
	/**
	 * This (recursive) helper method deletes the node corresponding to a given key from a given tree.
	 * @param n		the root of the tree
	 * @param key	the key of the node to be deleted
	 * @return		the root of the new tree
	 */
	private Node deleteAVL(Node n, int key) {
		return null;
	}
	
	/**
	 * Recursive remove method
	 * @param root the root of the tree
	 * @param p the priority of the node to remove
	 * @return root the root of the tree
	 * @author Marty Stepp courses.cs.washington.edu
	 * @author Building Java Programs Third Edition - Marty Stepp & Stuart Reges
	 */
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
				return root;
			} else if (root.right == null ) {
				//Case 2: left child only; replace with a left child
				root = root.left;
				return root;
			} else if (root.left == null) {
				//Case 3: right child only; replace with right child
				root = root.right;
				return root;
			} else {
				//Case 4: both children, replace with next in-order from right subtree
				Node followingNode = removeNextInOrder(root.right);
				set(root, followingNode);
				root.right = remove(root.right, followingNode.data.getPriority());
				return root;
			}
		}
		
		if (root != null) {
			(root.descendants)--; 
		}
		return root;
	}
	
	/**
	 * Method to copy data from one node to another
	 * @param dest the node that data is copied to
	 * @param source the node that data is copied from
	 */
	private void set(Node dest, Node source) {
		dest.data.setPriority(source.data.getPriority());
		dest.data.setId(source.data.getId());
	}
	
	/**
	 * Removes the next node in the tree order
	 * @param root the root of the tree
	 * @return the root of the tree
	 */
	private Node removeNextInOrder(Node root) { // L H R
		if (root.left != null)
			return removeNextInOrder(root.left);
		else
			return root;
	}

	/**
	 * Identify and remove highest priority call.
	 */
	public void getHighest() {
		//return getHighest(overallRoot);
	}
	
	/**
	 * Returns the highest priority node in the tree
	 * @param root the root of the tree
	 * @return the data of the highest priority node
	 */
	private Ticket getHighest(Node root) {
		if (root.right != null)
			return getHighest(root.right);
		
		return root.data;
	}

	/**
	 * Query about position in the queue (using help ticket id)
	 * 
	 * @param priority
	 * @return
	 * */
	public int query( int p ) {
		return  query(overallRoot, p);
	}
	
	/**
	 * Method to find the priority of a given node
	 * @param root the root of the tree
	 * @param p the priority of the node 
	 * @return the key of the node we find
	 */
	private int query( Node root, int p ) {
		if (root == null)
			return 0;
		if ( root.data.getPriority() == p)
			return 1 + getNodeDescendants(root.right);
		if ( root.data.getPriority() > p)
		    return query(root.left, p) + 1 + getNodeDescendants(root.right);
		else // ( root.data.getPriority() < p)
		    return query(root.right, p);
	}
	
	/**
	 * Method to get the descendants of a node
	 * @param root the root of the tree
	 * @return the descendants or 0 if there are none
	 */
	private int getNodeDescendants(Node root) {
		if (root != null)
			return root.descendants;
		return 0;
	}
	
	/**
	 * Checks if the tree contains a node.
	 * @param p the priority of the node to find
	 * @return true if tree does contain, false if not.
	 */
	public boolean contains( int p) {
		return recContains(overallRoot, p);
	}
	
	/**
	 * Recursivly finds the requested node in the tree
	 * @param current node used for going through the tree
	 * @param p the priority of the node we are looking for
	 * @return true or false depending on if the node is found
	 */
	private boolean recContains(Node current, int p) {
		if(current.data.getPriority() == p) {
			return true;
		}
		if(current.data.getPriority() > p && current.left == null) {
			return false;
		}
		if(current.data.getPriority() < p && current.right == null) {
			return false;
		}
		
		if(current.data.getPriority() > p && current.left != null) {
			return recContains(current.left, p);
		}
		if(current.data.getPriority() < p && current.right != null) {
			return recContains(current.right, p);
		}	
		return false;
		
	}
	
	/**
	 * Returns whether or not a tree is empty
	 * @return true or false depending on the condition of the tree
	 */
	public boolean isEmpty(){
		return (overallRoot == null);
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
	
	 /* Function to max of left/right node */
    private int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
	
	/* Rotate binary tree node with left child */     
    private Node rotateWithLeftChild(Node k2){
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }
    
    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node k1){
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private Node doubleWithLeftChild(Node k3){
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private Node doubleWithRightChild(Node k1){
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }  
	
	/**
	 * Node Class for Tree.
	 * 
	 * @author Thomas Ortiz
	 * @author Michael Mackrell
	 * @author Jacob Stone
	 * @author Curtis Moore
	 */
	private class Node {
		public Ticket data; // data stored at this node
		public Node left; // reference to left subtree
		public Node right; // reference to right subtree
		public int descendants; // amount of descendants
		int height; // the height of the node

		/**
		 * Constructs a leaf node with the given data.
		 * 
		 * @param data ticket
		 */
		public Node(Ticket data) {
			this(data, null, null, 0);
		}

		/**
		 * Constructs a branch node with the given data and links.
		 * 
		 * @param data ticket
		 * @param left node
		 * @param right node
		 */
		public Node(Ticket data, Node left, Node right, int height) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.descendants = 0;
			this.height = 0;
		}
	}
}
