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
    /** tree map for use */
	private TreeMap<Integer, Integer> map; 
	/**
	 * tree object
	 */
	private Tree tree; 
	/**
	 * incrementer for the id
	 */
	private int idCounter; 

	/**
	 * constructor for the command handler class
	 */
	public CommandHandler() {
		this.tree = new Tree();
		map = new TreeMap<Integer, Integer>();
		idCounter = 1;
	}

	/**
	 * method to insert into a list
	 * @param priority the priority of the node to be inserted
	 */
	public void insert(int priority) {
		if(!map.containsValue(priority)){
			System.out.println("+ " + priority);
			Ticket t = new Ticket(priority, idCounter);// prioirty id descendants
			map.put(idCounter, priority); // id is key, priority is value
			tree.insert(t);
			System.out.println("    id = " + idCounter);
	
			idCounter++;
		} else {  
			throw new Warning("Warning: a ticket with priority p is already in the queue");
		}
	}

	/**
	 * method to remove any node given the id of that node
	 * @param id the id of the node to be removed
	 */
	public void remove(int id) {
		if(tree.isEmpty()){
			throw new Warning("Warning: removal attempted when queue is empty");
		}
		
		if( map.containsKey(id) ){
			System.out.println("- " + id);
	
			int priority = map.get(id);
			map.remove(priority);
			
			System.out.println("    " + priority + ", pos = " + tree.query(priority)); // + position in queue based off of descendants
			tree.remove(priority);
			// TODO FIX THIS POSTION THING
		} else {
			throw new Warning("Warning: there is no ticket with id = i in the queue");
		}
	}

	/**
	 * method to remove the node with the highest key
	 * Iterates down the right hand side of the tree
	 * until it finds the bottom right node (the highest one)
	 */
	public void removeHighest() {
		if(tree.isEmpty()){
			throw new Warning("Warning: removal attempted when queue is empty");
		}
		
		System.out.println("*");
		//int highest = map.lastKey();
		//System.out.println("    id = " + highest + ", " + map.get(highest) );
		//tree.remove(highest);
		//map.remove(highest);
		
		Ticket highest = tree.getHighest();
		System.out.println("    id = " + highest.getId() + ", " + highest.getPriority() );
		map.remove(highest.getId());
		tree.remove(highest.getPriority());
		
	}

	/**
	 * given an id, give the position of the node in the tree
	 * @param id the id of the node
	 */
	public void query(int id) {
		if(tree.isEmpty()){
			throw new Warning("Warning: removal attempted when queue is empty");
		}
		
		if( map.containsKey(id) ){ 
			System.out.println("? " + id);
	
			int priority = map.get(id);
			//tree.printInorder();
			
			System.out.println("    pos = " + tree.query(priority));
		} else {
			throw new Warning("Warning: there is no ticket with id = i in the queue");
		}
	}
}
