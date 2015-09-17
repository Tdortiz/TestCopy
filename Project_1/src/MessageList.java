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
		if (head.next == null && head.data.getMessageNum() < a.getMessageNum()) {
			MessageNode nextNode = new MessageNode(a, null);
			head.next = nextNode;
			return;
		} else {
			MessageNode nextNode = head;
			head = new MessageNode(a, nextNode);
		}
		
		recursiveAdd(head, a, null);
	}
	
	private void recursiveAdd(MessageNode currNode, Message MessageToAdd, MessageNode prev) {
		if(currNode.data.getMessageNum() < MessageToAdd.getMessageNum()) {
			recursiveAdd(currNode.next, MessageToAdd, currNode);
			return;
		}
		if(currNode.data.getMessageNum() == MessageToAdd.getMessageNum()) {
			prev.next= new MessageNode(MessageToAdd, currNode.next);
			return;
		}
		MessageNode nodeToAdd = new MessageNode(MessageToAdd, currNode.next);
		currNode.next = nodeToAdd;
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
	
	public Message contains (int messToFind) {
		return recContains(messToFind, head);
	}
	
	private Message recContains(int messToFind, MessageNode curr) {
		if(messToFind < curr.data.getMessageNum()) {
			return recContains(messToFind, curr.next);
		}
		return curr.data;
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