/**
 * Ticket class represents a help ticket request 
 * that has a priority, id, and number of descendant.
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Ticket {

	/** priority of the ticket */
	private int priority;
	/** id of the ticket */
	private int id;
	/** count of decendants of the ticket */
	private int descendants; // count

	/**
	 * Constructor for the ticket.
	 * 
	 * @param priority
	 *            the priority of the ticket
	 * @param id
	 *            the id of the ticket
	 * @param decendants
	 *            the number of decendants of the ticket
	 */
	public Ticket(int priority, int id) {
		this.priority = priority;
		this.id = id;
		this.descendants = 0;
	}

	/**
	 * Returns the ID of the ticket
	 * 
	 * @return id the id of the ticket
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id field to newId.
	 * @param newId to set id to.
	 */
	public void setId(int newId) {
		id = newId;
	}

	/**
	 * Returns the priority of the ticket
	 * 
	 * @return priority the priority of the ticket
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority field to newPriority
	 * @param newPriority to set priority to.
	 */
	public void setPriority(int newPriority) {
		priority = newPriority;
	}
	
	/**
	 * Returns the descendants of this Ticket.
	 * @return descendants of ticket.
	 */
	public int getDescendants(){
		return this.descendants;
	}
	
	/**
	 * Increments the descendants by change.
	 * @param change to increment by.
	 */
	public void changeDescendants(int change) {
		this.descendants += change;
	}
}
