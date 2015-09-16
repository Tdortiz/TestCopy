/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */

public class MessageList {

	public MessageNode head;

	/**
	 * This should check if Param A is already in the message list and if it is
	 * add the new packet to the already existant message in the list.
	 * 
	 * If the Param A isn't in the message list add A to the MessageList
	 * 
	 * @param a
	 */
	public void add(Message a) {
		if (head == null) {
			head = new MessageNode(a);
		}
	}

	public MessageNode getHead() {
		return head;
	}
	
	public String toString(){
		String s = "";
		MessageNode current = head;
		while(current != null){
			s += current.data.toString() + "\n";
		}
		return s;
	}
	
	
	public class MessageNode {

		public Message data;
		public MessageNode next;

		public MessageNode(Message data) {
			this(data, null);
		}

		public MessageNode(Message data, MessageNode next) {
			this.data = data;
			this.next = next;
		}
	} 

	
}