/**
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Ticket {

	/**
	 * priority of the ticket
	 */
	private int priority;
	/**
	 * id of the ticket
	 */
	private int id;
	/**
	 * count of decendants of the ticket
	 */
	private int descendants; // count 
	
	/**
	 * constructor for the ticket
	 * @param priority the priority of the ticket
	 * @param id the id of the ticket 
	 * @param decendants the number of decendants of the ticket
	 */
	public Ticket(int priority, int id, int decendants){
		this.priority=priority;
		this.id = id;
		this.descendants = decendants;
		
	}
	
	/**
	 * returns the ID of the ticket
	 * @return id the id of the ticket
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * returns the priority of the ticket
	 * @return priority the priority of the ticket
	 */
	public int getPriority(){
		return priority;
	}
	
}
