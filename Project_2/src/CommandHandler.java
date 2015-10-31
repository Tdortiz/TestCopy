import java.util.*;

/**
 * Wrapper class that handles the command input.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class CommandHandler {

	private TreeMap<Integer, Integer> map; // TreeMap
	private Tree tree; // Tree
	private int idCounter; // id incrementer 

	public CommandHandler() {
		this.tree = new Tree();
		map = new TreeMap<Integer, Integer>();
		idCounter = 1;
	}

	public void insert(int priority) {
		if(map.containsValue(priority)){
			System.out.println("+ " + priority);
			Ticket t = new Ticket(priority, idCounter);// prioirty id descendants
			map.put(idCounter, priority); // id is key, priority is value
			tree.insert(t);
			System.out.println("    id = " + idCounter);
	
			idCounter++;
		} else {  
			// TODO say Warning: a ticket with priority p is already in the queue
		}
	}

	public void remove(int id) {
		// make isEmpty
		if( map.containsKey(id) ){
			System.out.println("- " + id);
	
			int priority = map.get(id);
			map.remove(priority);
			
			tree.remove(priority);
			System.out.println("    " + priority + ", pos = "); // + position in queue based off of descendants
			// TODO FIX THIS POSTION THING
		} else {
			// Warning: there is no ticket with id = i in the queue 
			// Warning: removal attempted when queue is empty
		}
	}

	public void removeHighest() {
		// if !isempty() {
		System.out.println("*");

		int highest = map.lastKey();
		tree.remove(highest);
		map.remove(highest);
		// } else { 
		// Warning: there is no ticket with id = i in the queue 
		// Warning: removal attempted when queue is empty
	}

	public void query(int id) {
		if( map.containsKey(id) ){ 
			System.out.println("? " + id);
	
			int priority = map.get(id);
			tree.query(priority);
		} else {
			// Warning: there is no ticket with id = i in the queue
		}
	}
}
