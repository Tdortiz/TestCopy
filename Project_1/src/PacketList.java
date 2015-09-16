/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 * 
 * A sorted linked list of packets.
 */
public class PacketList {
	
	/** The front of the list */
	Node front;
	
	/** Simple constructor for PacketList */
	public PacketList () {
		front = null;
	}
	
	/** extended constructor for PacketList.
	 * @param packetToStart the packet to start off the list
	 */
	public PacketList (Packet packetToStart) {
		this.add(packetToStart);
	}
	
	/**
	 * Adds a packet to the list in ascending order
	 * @param packetToAdd the packet to add to the list.
	 */
	public void add(Packet packetToAdd) {
		if (front == null) {
			front = new Node(packetToAdd, null);
		} else {
			this.addHelper(packetToAdd);
		}
	}	
	
	/**
	 * Adds a packet to the rest of the list
	 * PRE: the front of the list is not null
	 * @param packetToAdd the packet to add to the list
	 */
	public void addHelper(Packet packetToAdd) {
		if (packetToAdd.getPackNum() < front.packet.getPackNum()) {
			front = new Node(packetToAdd, front);
		} else {
			this.addToRest(packetToAdd);
		}
	}
	
	/**
	 * Adds a packet to the rest of the list
	 * PRE: Packet does not need to enter the front of the list
	 * @param packetToAdd the packet to add to the list
	 */
	public void addToRest(Packet packetToAdd) {
		Node current = front;
		Node previous = front;
		
		while (current != null) {
			int currentNum = current.packet.getPackNum();
			int toAddNum = packetToAdd.getPackNum();
			if ( toAddNum > currentNum) {
				if (current.next == null) {
					current.next = new Node(packetToAdd, null);
					break;
				} else {
					previous = current;
					current = current.next;
				}
			} else {
				previous.next = new Node(packetToAdd, current);
			}
		}
	}
	
	/**
	 * Creates a string of the packet list
	 * and returns it to the caller.
	 * PRE: list is in ascending order
	 * @param messageNum the message the list belongs to
	 * @return listString the string of the packet list
	 */
	public String toString(int messageNum) {
		Node current = front;
		int nextNum = 1;
		String listString = "";
		
		while (current != null) {
			if (nextNum == current.packet.getPackNum()) {
				listString += current.packet.getMessage() + "\n";
			} else {
				while (nextNum != current.packet.getPackNum()) {
					listString += "WARNING: packet " + nextNum + " of message ";
					listString += messageNum + " is missing\n";
					nextNum++;
				}
				listString += current.packet.getMessage() + "\n";
			}
			nextNum++;
			current = current.next;
		}
		
		return listString;
	}
	
	public Node getFront(){
		return this.front;
	}
	
	/**
	 * The node object used in a linked list.
	 * @author Jacob Stone
	 * @author Michael Mackrell
	 * @author Jacob Stone
	 * @author Curtis Moore
	 */
	public class Node {
		
		/**
		 * The packet that the Node contains.
		 */
		public Packet packet;
		
		/**
		 * The reference to the next Node in the list.
		 */
		public Node next;
		
		/**
		 * Constructor for node objects.
		 * @param device the device inside the node
		 * @param next the reference to the next node
		 */
		public Node(Packet packet, Node next) {
			this.packet = packet;
			this.next = next;
		}
	}
	
	
	
}