/**
 * Message class of the project.
 * Has a getter to make the message number public access
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Message {
	
	/**
	 * the number for the message
	 */
	private int messNum;
	
	/**
	 * the packet to get returned
	 */
	private PacketList sixPack;
	
	/**
	 * constructor for the message
	 * @param messNum the message number
	 * @param packNum the packet number
	 * @param message the message to be printed
	 */
	public Message(int messNum, int packNum, String message){
		sixPack = new PacketList();
	}
	
	/**
	 * getter for the message number
	 * @return the current message number
	 */
	public int getMessageNum(){
		return messNum;
		
	}
	
	/**
	 * toString method that prints the packet number and message
	 * @param packNum the number of the packet
	 * @param message the message to be printed
	 * @return s the string to be printed
	 */
	public String messToString(int messNum, int packNum, String message){
		String s = "";
		Packet pack = new Packet(packNum, message);
		s = messNum + pack.packToString(packNum, message);
		return s;
	}
	
	/**
	 * returns the packet list
	 * @return sixpack the packet list
	 */
	public PacketList getPacketList() {
		return sixPack;
	}

	/**
	 * toString method to print out a message and its packets.
	 * @return s message with its packets
	 */
	public String toString(){
		String s = "";
		s += "--- Message " + this.messNum + "\n";
		
		System.out.println(sixPack.toString());
		
		s += "--- End Message " + this.messNum + "\n";
		return s;
	}	
	
}