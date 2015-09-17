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
	 * @param messNum the number of the message
	 * @return s the string to be printed
	 */
	public String toString(){
		String s = "";
		s = "--- Message " + messNum;
		s+= "/n";
		s+= sixPack.toString(messNum);
		s+= "/n";
		s+= "--- End Message " + messNum;
		
		return s;
	}
	
	/**
	 * returns the packet list
	 * @return sixpack the packet list
	 */
	public PacketList getPacketList() {
		return sixPack;
	}

	
}
