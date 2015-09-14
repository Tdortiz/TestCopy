/**
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */


/**
 * Message class of the project.
 * Has a getter to make the message number public access
 */
public class Message {
	
	/**
	 * the number for the message
	 */
	private int messNum;
	
	/**
	 * constructor for the message
	 * @param messNum the message number
	 * @param packNum the packet number
	 * @param message the message to be printed
	 */
	public Message(int messNum, int packNum, String message){
		
		PacketList sixPack = new PacketList();
		
	}
	
	/**
	 * getter for the message number
	 * @return the current message number
	 */
	public int getMessNum(){
		return messNum;
		
	}
	
}
