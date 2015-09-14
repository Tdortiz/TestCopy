/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */

public class MessageList {

	public Node head;
	public Node current;

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
			head = new Node(a);
		}
	}

	public Message getHead() {
		return head.data;
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

	public class Node {

		public Message data;
		public Node next;

		public Node(Message data) {
			this(data, null);
		}

		public Node(Message data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public Message getNext() {
		Message nextData;
		if (head.next == null) {
			nextData = head.data;
			head = null;
			return nextData;
		}else if(current == null) {
			current = head.next;
			return current.data;
		}
		current = current.next;
		return current.data;
	}

}