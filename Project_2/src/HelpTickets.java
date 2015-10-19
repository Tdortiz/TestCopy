import java.util.InputMismatchException;
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
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		/**  The main program should only parse commands, call methods corresponding to each command
		 *  — methods of the wrapper class — and catch exceptions, passing these to the Warning class.
		 */
		
		Scanner input = new Scanner(System.in);
		Scanner line = null;
		String command = null;
		int num = 0;
		
		while( input.hasNextLine() ){
			line = new Scanner(input.nextLine());
			
			// TODO Handle warnings 
			command = line.next();
			num = line.nextInt();

			if(command.equals("+")){
				// TODO Call wrapper methods for add
				
			} else if(command.equals("-")){
				// TODO Call wrapper methods for remove
				
			} else if(command.equals("*")){
				// TODO Call wrapper methods for remove highest priority
				
			} else if(command.equals("?")){
				// TODO Call wrapper methods for current position in queue of the ticket with given id
				
			}
		}
		
		line.close();
		input.close();

	}
}
