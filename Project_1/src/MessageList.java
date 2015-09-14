/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */

public class MessageList {
	
	public Message head;
	
	
		
	/**
	 * This should check if Param A is already in the message list and if it is
	 * add the new packet to the already existant message in the list. 
	 * 
	 * If the Param A isn't in the message list add A to the MessageList
	 * @param a
	 */
	public void add(Message a) {
		// TODO Auto-generated method stub
	}
	
	public Message getHead(){
		return head;
	}
	
	public Message next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public class Node {
		
		public int data;
		public Node next;
		
		public Node(int data){
			this(data, null);
		}
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}



	public Message getNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}