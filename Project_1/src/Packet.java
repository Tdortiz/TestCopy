/**
 * Class to represent the packet objects
 * contains a constructor as well as a toString method and an
 * error message
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Packet {
	/**
	 * packet number
	 */
	public int packNum;
	/**
	 * message
	 */
	public String message;
	
	/**
	 * constructor for packet objects
	 * @param packNum the number of the packet
	 * @param message the message to be printed
	 */
	public Packet(int packNum, String message){
		this.packNum = packNum;
		this.message = message;
		
	}
	
	
	/**
	 * toString method that prints the packet number and message
	 * @param packNum the number of the packet
	 * @param message the message to be printed
	 * @return s the string to be printed
	 */
	public String packToString(int packNum, String message){
		String s = "";
		s = " " + packNum + " " + message;
		return s;
	}
	
	
	/**
	 * toString method to print out a packet.
	 * @return s packet message
	 */
	public String toString(){
		return this.message;
	}

	public int getPackNum() {
		return this.packNum;
	}
	
	public String getMessage(){
		return this.message;
	}
}