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
	
	public AbstractTree() {	}
	
	public abstract void insert(Ticket ticketToAdd);

	public abstract void remove(int p);
	
	public abstract int query( int p );
	
	public abstract boolean contains( int p);
	
	public abstract boolean isEmpty();
	
	public abstract Ticket getHighest();
}
