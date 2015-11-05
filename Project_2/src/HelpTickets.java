import java.util.Scanner;

/**
 * The main program, reads in input from standard input, or in our case, a file,
 * and parses through each command passing them to the CommandHandler class.
 * HelpTickets also handles all exceptions.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class HelpTickets {

	/**
	 * The main program parses commands from a file, and then calls methods
	 * corresponding to each command — methods of the wrapper class — and also
	 * catches exceptions.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		//input(input);
		
		Tree tree = new Tree(); // Simple binary search tree
		CommandHandler handler = new CommandHandler(tree);
	    Scanner scanInput = new Scanner( System.in );
	    
	    boolean keepGoing = true;
	    while ( keepGoing ){
	        try {
	          keepGoing = nextCommand(handler, scanInput);
	        } catch ( Warning w ) {
	          System.out.println(w);
	        }
	    }
	}

	/**
	 * Handles all input from the user/file.
	 * 
	 * @param input
	 *            the input scanner passed from main
	 */
	public static void input(Scanner input) {
		Tree tree = new Tree(); // Simple binary search tree
		CommandHandler handler = new CommandHandler(tree); // Handles all
															// commands
		Scanner lineParser = null; // Parses through a line
		String command = null; // Command from user.

		while (input.hasNextLine()) { // Runs until there is no more input
			lineParser = new Scanner(input.nextLine());
			while (lineParser.hasNext()) {
				command = lineParser.next(); // gets the commands +, -, *, ?

				try {
					if (command.equals("+")) { // ADD
						String str = lineParser.next().trim();
						try {
							handler.insert(Integer.parseInt(str));
						} catch (NumberFormatException NFE) {
							lineParser.close();
							throw new Warning("Warning: priority " + str + " is not an integer");
						}
					} else if (command.equals("-")) { // REMOVE
						String str = lineParser.next().trim();
						try {
							handler.remove(Integer.parseInt(str));
						} catch (NumberFormatException NFE) {
							lineParser.close();
							throw new Warning("Warning: id " + str + " is not an integer");
						}
					} else if (command.equals("*")) { // REMOVE HIGHEST
						handler.removeHighest();

					} else if (command.equals("?")) { // QUERY
						String str = lineParser.next().trim();
						try {
							handler.query(Integer.parseInt(str));
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

	public static boolean nextCommand(CommandHandler handler, Scanner input){
		if ( ! input.hasNextLine() ) return false;
		
	    String line = input.nextLine();
	    Scanner lineScanner = new Scanner( line );
	    
	    // check for blank line
	    if ( ! lineScanner.hasNext() ) throw new Warning("blank line");

	    // command is the first token of the line; look at it and decide what to
	    // do next
	    String command = lineScanner.next();
	    if ( command.equals( "+" ) ) handleAdd(handler, lineScanner);
	    else if ( command.equals( "-" ) ) handleRemove(handler,lineScanner);
	    else if ( command.equals( "?" ) ) handleQuery(handler,lineScanner);
	    else if ( command.equals( "*" ) ) handleRemoveHighest(handler);
	    else throw new Warning("invalid command " + command);
	    
	    if ( lineScanner.hasNext() )
	      throw new Warning("Extra stuff on command line, starting with "
	                        + lineScanner.next());
	    return true;
	}
	
	 private static void handleAdd(CommandHandler handler, Scanner lineScanner) throws Warning
	  {
	    if ( ! lineScanner.hasNext() ) throw new Warning( "missing priority for +" );
	    
	    int priority;
	    String pString = "";
	    
	    try {
	      pString = lineScanner.next();
	      priority = Integer.parseInt( pString );
	    }
	    catch ( NumberFormatException nfe ) {
	      throw new Warning("priority " + pString + " is not an integer");
	    }
	    
	    handler.insert(priority);
	  }

	  private static void handleRemove(CommandHandler handler, Scanner lineScanner) throws Warning
	  {
	    if ( ! lineScanner.hasNext() ) throw new Warning( "missing id for -" );
	    
	    int id;
	    String idString = "";
	    try {
	      idString = lineScanner.next();
	      id = Integer.parseInt( idString );
	    }
	    catch ( NumberFormatException nfe ) {
	      throw new Warning("id " + idString + " is not an integer");
	    }
	    
	    handler.remove( id );
	  }

	  private static void handleQuery(CommandHandler handler, Scanner lineScanner) throws Warning
	  {
	    if ( ! lineScanner.hasNext() ) throw new Warning( "missing id for ?" );
	    
	    int id;
	    String idString = "";
	    
	    try {
	      idString = lineScanner.next();
	      id = Integer.parseInt( idString );
	    }
	    catch ( NumberFormatException nfe ) {
	      throw new Warning("id " + idString + " is not an integer");
	    }
	    
	    handler.query(id);
	  }

	  private static void handleRemoveHighest(CommandHandler handler) throws Warning
	  {
	    handler.removeHighest();
	  }
}
