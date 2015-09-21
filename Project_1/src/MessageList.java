/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */

public class MessageList {

	public MessageNode head;
	public MessageNode current;
	
	public MessageList(){
		head = null;
		current = null;
	}
	
	/**
	 * Adds a message to the list in ascending order
	 * @param messageToAdd the packet to add to the list.
	 */
	public void add(Message messageToAdd) {
		if (head == null) {
			head = new MessageNode(messageToAdd, null);
		} else if (messageToAdd.getMessageNum() == head.data.getMessageNum()) {
			head = new MessageNode(messageToAdd, head.next);
		} else {
			this.addHelper(messageToAdd);
		}
	}	
	
	/**
	 * Adds a message to the rest of the list
	 * PRE: the front of the list is not null
	 * @param messageToAdd the packet to add to the list
	 */
	public void addHelper(Message messageToAdd) {
		if (messageToAdd.getMessageNum() < head.data.getMessageNum()) {
			head = new MessageNode(messageToAdd, head);
		} else {
			this.addToRest(messageToAdd);
		}
	}
	
	/**
	 * Adds a message to the rest of the list
	 * PRE: Message does not need to enter the front of the list
	 * @param messageToAdd the packet to add to the list
	 */
	public void addToRest(Message messageToAdd) {
		MessageNode current = head;
		MessageNode previous = head;
		
		while (current != null) {
			System.out.println("AM I THE PROB?");
			int currentNum = current.data.getMessageNum();
			int toAddNum = messageToAdd.getMessageNum();
			if (toAddNum >= currentNum) {
				if (current.next == null){
					current.next = new MessageNode(messageToAdd, null);
					break;
				} else {
					previous = current;
					current = current.next;
				}
			} else {
				System.out.println("CurrNum is " + currentNum);
				System.out.println("toAddNum is " + toAddNum);
				previous.next = new MessageNode(messageToAdd, current);
				break;
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * This should check if Param A is already in the message list and if it is
	 * add the new packet to the already existing message in the list.
	 * 
	 * If the Param A isn't in the message list add A to the MessageList
	 * 
	 * @param a
	 */
	/**public void add(Message a) {
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
	} */
	/**
	 * Slightly broken.
	 * @param currNode
	 * @param messageToAdd
	 * @param prev
	 */
	/**private void recursiveAdd(MessageNode currNode, Message messageToAdd, MessageNode prev) {
		if(currNode.data.getMessageNum() > messageToAdd.getMessageNum()) { */
			/*if(currNode.next == null){
				currNode.next = new MessageNode(messageToAdd, null);
			}*/
			/**recursiveAdd(currNode.next, messageToAdd, currNode);
			return;
		}
		if(currNode.data.getMessageNum() == messageToAdd.getMessageNum()) {
			prev.next= new MessageNode(messageToAdd, currNode.next);
			return;
		}
		MessageNode nodeToAdd = new MessageNode(messageToAdd, currNode.next);
		currNode.next = nodeToAdd;
	} */

	public MessageNode getHead() {
		return head;
	}

	/**
	 * Sends message to a string
	 */
	/**public String toString() {
		//String s = "";
		if(head == null){
			return null;
		}
		return toStringRec(head.data.toString(), head);
	}
	
	private String toStringRec(String s, MessageNode here ) {
		if(here == null || here.next == null) {
			return s;
		}
		s += here.data.toString() + "\n\n";
		return toStringRec(s, here.next);
	} */
	
	public String toString(){
		String s = "";
		MessageNode current = head;
		while(current != null){
			s += current.data.toString() + "\n\n";
			current = current.next;
		}
		return s;
	}
	
	public Message contains (int messToFind) {
		return recContains(messToFind, head);
	}
	
	private Message recContains(int messToFind, MessageNode curr) {
		if(curr == null) {
			return null;
		}
		if(curr.next == null && messToFind != curr.data.getMessageNum()) {
			return null;
		}
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