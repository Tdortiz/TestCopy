/**
 * Class that handles all warnings. 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Warning {

	/**
	 * Simple constructor for warning.
	 */
	public Warning(){}
	
	/**
	 * Prints a warning message if the priority entered is already in the queue.
	 * @param p priority entered.
	 */
	public void priorityAlreadyInQueue(int p){
		System.out.println("Warning: a ticket with priority " + p + " is already in the queue");
	}
	
	/**
	 * Prints a warning message if the id is not in the queue.
	 * @param i id entered.
	 */
	public void IdNotInQueue(int i){
		System.out.println("Warning: there is no ticket with id = " + i + " in the queue"); 
	}
	
	/**
	 * Prints a warning message if the user attempts to remove from an empty queue.
	 */
	public void queueEmpty(){
		System.out.println("Warning: removal attempted when queue is empty");
	}
	
	/**
	 * Prints a warning message if the user input the incorrect command.
	 * @param command entered by user.
	 */
	public void invalidCommand(String command){
		System.out.println("Warning: invalid command " +  command); 
	}
	
	/**
	 * Prints a warning message if the id entered is not an integer.
	 * @param id entered by user.
	 */
	public void idNotInteger(int id){
		System.out.println("Warning: id " + id + " is not an integer");
	}
	/**
	 * Prints a warning message if the priority is not an integer.
	 * @param p priority entered by user.
	 */
	public void pNotInteger(int p){
		System.out.println("Warning: priority " + p + " is not an integer");
	}
	
}
