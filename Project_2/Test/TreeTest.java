import org.junit.Assert.*;
import org.junit.Test;

public class TreeTest {

	
	@Test
	public void testCase1(){
		Tree tree = new Tree();
		Ticket ticket1 = new Ticket(1, 1);
		Ticket ticket2 = new Ticket(3, 1);
		Ticket ticket3 = new Ticket(2, 1);
		Ticket ticket4 = new Ticket(8, 1);
		Ticket ticket5 = new Ticket(6, 1);
		Ticket ticket6 = new Ticket(5, 1);
		Ticket ticket7 = new Ticket(9, 1);
		
		tree.insert(ticket1);
		tree.insert(ticket2);
		tree.insert(ticket3);
		tree.insert(ticket4);
		tree.insert(ticket5);
		tree.insert(ticket6);
		tree.insert(ticket7);
		
		tree.printInorder(tree.getRoot());
		System.out.println();
		tree.remove(3);
		tree.printInorder(tree.getRoot());
		System.out.println();
		
		
		tree.remove(1);
		tree.printInorder(tree.getRoot());
		System.out.println();
	}
	
}
