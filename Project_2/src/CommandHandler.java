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
	private int idCounter;

	public CommandHandler() {
		this.tree = new Tree();
		map = new TreeMap<Integer, Integer>();
		idCounter = 1;
	}

	public void insert(int priority) {
		System.out.println("+ " + priority);

		Ticket t = new Ticket(priority, idCounter);// prioirty id descendants
		map.put(idCounter, priority); // id is key, priority is value
		tree.insert(t);
		System.out.println("    id = " + idCounter);

		idCounter++;
	}

	public void remove(int id) {
		System.out.println("- " + id);

		int priority = map.get(id);
		map.remove(priority);
		tree.remove(priority);
		System.out.println("    " + priority + ", pos = "); // + position in queue based off of descendants
		// TODO FIX THIS POSTION THING
	}

	public void removeHighest() {
		System.out.println("*");

		int highest = map.lastKey();
		tree.remove(highest);
		map.remove(highest);
	}

	public void query(int id) {
		System.out.println("? " + id);

		int priority = map.get(id);
		tree.query(priority);
	}
}
