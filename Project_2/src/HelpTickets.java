import java.util.Scanner;

/**
 * The main program, reads in input from standard input, or in our case, a file, and 
 * parses through each command passing them to the CommandHandler class. HelpTickets 
 * also handles all exceptions.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class HelpTickets {

	/**
	 * The main program parses commands from a file, and then calls methods corresponding
	 * to each command — methods of the wrapper class — and also catches exceptions.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input(input);
	}
	
    /**
     * Handles all input from the user/file.
     * @param input the input scanner passed from main
     */
	public static void input(Scanner input) {
		AbstractTree tree = new Tree(); // Simple binary search tree
		CommandHandler handler = new CommandHandler(tree); // Handles all commands
		Scanner lineParser = null; // Parses through a line
		String command = null; // Command from user.

		while (input.hasNextLine()) { // Runs until there is no more input
			lineParser = new Scanner(input.nextLine());
			while(lineParser.hasNext() ){
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
		}

		lineParser.close();
		input.close();
	}
}
