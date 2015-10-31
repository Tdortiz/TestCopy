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
	 * The main program should only parse commands, call methods corresponding
	 * to each command — methods of the wrapper class — and catch exceptions,
	 * passing these to the Warning class.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input(input);
	}

	public static void input(Scanner input) {
		CommandHandler handler = new CommandHandler(); // Handles all commands
		Scanner lineParser = null; // Parses through a line
		String command = null; // Command from user.

		while (input.hasNextLine()) { // Runs until there is no more input
			lineParser = new Scanner(input.nextLine());

			// TODO Handle warnings
			/**
			 * "Warning: a ticket with priority p is already in the queue"; s =
			 * "Warning: there is no ticket with id = i + in the queue"; s =
			 * "Warning: removal attempted when queue is empty"; s = "Warning:
			 * invalid command command; s = "Warning: id id is not an integer";
			 * s = "Warning: priority p is not an integer";
			 */
			command = lineParser.next(); // gets the commands +, -, *, ?

			try {
				if (command.equals("+")) { // ADD
					String str = lineParser.next().trim();
					try {
						handler.insert( Integer.parseInt(str) );
					} catch (NumberFormatException NFE) {
						lineParser.close();
						throw new Warning("Warning: priority " + str + " is not an integer");
					}
				} else if (command.equals("-")) { // REMOVE
					String str = lineParser.next().trim();
					try {
						handler.remove( Integer.parseInt(str) );
					} catch (NumberFormatException NFE) {
						lineParser.close();
						throw new Warning("Warning: id " + str + " is not an integer");
					}
				} else if (command.equals("*")) { // REMOVE HIGHEST
					handler.removeHighest();

				} else if (command.equals("?")) { // QUERY 
					String str = lineParser.next().trim();
					try {
						handler.query( Integer.parseInt(str) );
					} catch (NumberFormatException NFE) {
						lineParser.close();
						throw new Warning("Warning: id " + str + " is not an integer");
					}
				} else {
					lineParser.close();
					throw new Warning("Invalid command: " + command);
				}
			} catch (Warning invalidCommand) {
				System.out.println(invalidCommand.getMessage());
			}
		}

		lineParser.close();
		input.close();
	}
}
