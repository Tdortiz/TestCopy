/**
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Ticket {

	private int priority;
	private int id;
	private int descendants; // count 
	
	public Ticket(int priority, int id, int decendants){
		this.priority=priority;
		this.id = id;
		this.descendants = decendants;
		
	}
	
	public int getId(){
		return id;
	}
	
	public int getPriority(){
		return priority;
	}
	
}
