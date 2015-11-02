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
	
	/**
	 * Simple constructor for AbstractTree.
	 */
	public AbstractTree() {	}
	
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
	public abstract Ticket getHighest();
}
