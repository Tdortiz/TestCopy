import java.util.*;
/**
 * Wrapper class that handles the command input.
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class CommandHandler {

	private TreeMap<Integer, Integer> map;  // create TreeMap
	private Tree tree;
	private int idCounter;
	
	public CommandHandler(){
		this.tree = new Tree();
		map = new TreeMap<Integer, Integer>();
		idCounter = 1;
		
	}
	
	public void insert(int priority){
		Ticket t = new Ticket(priority, idCounter);//prioirty id descendants
		map.put(idCounter, priority); // id is key, priority is value
		idCounter++;
		tree.insert(t); 
	}
	
	public void remove(int id){
		int priority = map.get(id);
		map.remove(priority);
		tree.remove(priority);
	}
	
	public void removeHighest(){
		int highest = map.lastKey();
		tree.remove(highest);;
		map.remove(highest);
	}
	
	public int query(int id){
		int priority = map.get(id);
		return tree.query(priority);
	}
}
