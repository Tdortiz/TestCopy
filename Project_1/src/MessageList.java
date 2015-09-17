/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */

public class MessageList {

	public MessageNode head;
	public MessageNode current;

	/**
	 * This should check if Param A is already in the message list and if it is
	 * add the new packet to the already existing message in the list.
	 * 
	 * If the Param A isn't in the message list add A to the MessageList
	 * 
	 * @param a
	 */
	public void add(Message a) {
		if (head == null) {
			head = new MessageNode(a);
			return;
		}
		if (head.next == null) {
			current = new MessageNode(a, null);
			head.next = current;
			return;
		}
		current.next = new MessageNode(a, null);
		current = current.next;

	}

	public Message next() {
		Message nextData;
		if (head.next == null) {
			nextData = head.data;
			head = null;
			return nextData;
		}
		nextData = head.data;
		head = head.next;
		return nextData;
	}

	public Message getNext() {
		Message nextData;
		if (head.next == null) {
			nextData = head.data;
			head = null;
			return nextData;
		} else if (current == null) {
			current = head.next;
			return current.data;
		}
		current = current.next;
		return current.data;
	}

	public MessageNode getHead() {
		return head;
	}

	/**
	 * Sends message to a string
	 */
	public String toString() {
		String s = "";
		return toStringRec(s, head);
	}
	
	private String toStringRec(String s, MessageNode here ) {
		if(here.next == null) {
			return s;
		}
		s += here.data.toString() + "\n\n";
		return toStringRec(s, here.next);
	}

	/**
	 * Inner class to create nodes for lists.
	 * 
	 * @author Curtis
	 *
	 */
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