import java.util.Scanner;

/**
 * main program will be in HelpTickets.java, but you are strongly encouraged to
 * encapsulate and separately test whatever you can in other classes.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class HelpTickets {
	
	/**  
	 * The main program should only parse commands, call methods corresponding to each command
	 *  — methods of the wrapper class — and catch exceptions, passing these to the Warning class.
	 */
	public static void main(String[] args){
		CommandHandler handler = new CommandHandler();
		
		Scanner input = new Scanner(System.in);
		Scanner line = null;
		
		String command = null;
		int num = 0;
		
		while( input.hasNextLine() ){
			line = new Scanner(input.nextLine());
			
			// TODO Handle warnings 
			/**
			 * String s = "Warning: a ticket with priority p is already in the queue";
			 * s = "Warning: there is no ticket with id = i + in the queue"; 
			 * s = "Warning: removal attempted when queue is empty";
			 * s = "Warning: invalid command command; 
			 * s = "Warning: id id is not an integer";
			 * s = "Warning: priority p is not an integer";
			 */
			command = line.next();
			num = line.nextInt();

			if(command.equals("+")){
				// TODO Call wrapper methods for add
				handler.insert();
				
			} else if(command.equals("-")){
				// TODO Call wrapper methods for remove
				handler.remove();
				
			} else if(command.equals("*")){
				// TODO Call wrapper methods for remove highest priority
				handler.removeHighest();
				
			} else if(command.equals("?")){
				// TODO Call wrapper methods for current position in queue of the ticket with given id
				handler.query();
			}
		}
		
		line.close();
		input.close();

	}
}
