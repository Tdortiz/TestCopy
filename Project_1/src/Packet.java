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
	
	public int packNum;
	public String message;
	
	/**
	 * constructor for packet objects
	 * @param packNum the number of the packet
	 * @param message the message to be printed
	 */
	public Packet(int packNum, String message){
		
		
	}
	
	/**
	 * prints error message if packet is not found
	 * @param packNum the number of the packet
	 * @param messNum the number of the message
	 * @return the error message to be printed
	 */
	public String getErrorMessage(int packNum, int messNum){
		
		String errorMessage = ("WARNING: packet " + packNum + " of message " + messNum + " is missing");
		return errorMessage;
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