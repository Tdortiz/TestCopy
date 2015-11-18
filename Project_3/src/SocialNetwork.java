import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class SocialNetwork {

	public static void main(String[] args) {	
		Scanner scanFile = getInput( args[0] ); // File input
		Scanner scanInput = new Scanner(System.in);
		CommandHandler handler = new CommandHandler();
		createGraph(scanFile);
	
		while(scanInput.hasNextLine()){
			try{
				nextCommand(handler, scanInput.nextLine() );
			} catch (Warning e){
				System.out.println(e);
			}
		}
		
		scanFile.close();
		scanInput.close();
	}

	public static Scanner getInput(String filename){
		Scanner in = null;
		try{
			in = new Scanner(new File(filename));
		} catch(FileNotFoundException fnfe){
			fnfe.getMessage();
		}
		return in;
	}

	public static void createGraph(Scanner scanFile){
	    String name = null;
	    Node person = null;
		// Part where we create the nodes
	    while ( scanFile.hasNext() ){
	    	name = scanFile.next();
	    	System.out.println(name);
	    	
	    	if(name.equals("$")){
	    		scanFile.nextLine(); // gets rid of all of space after names
	    		break;
	    	}
	    	
	        person = new Node(name);
	    }
	    
		// Part where we create the edges
	    while( scanFile.hasNextLine() ){
	    	System.out.println(scanFile.nextLine());
	    	// TODO this part for creating edges
	    }
	    
	}
	
	/**
	 * Determines the next command to handle
	 * @param handler the CommandHandler object for the program
	 * @param input the input from the user
	 * @return true if the command was successful, false otherwise
	 */
	public static void nextCommand(CommandHandler handler, String line){
		Scanner scanLine = new Scanner(line);
		String command = null;
		try {
			command = scanLine.next().toLowerCase();
		} catch (NoSuchElementException e){
			throw new Warning("Invalid Input");
		}
		
		if( command.equals("quit") ){
			System.exit(0);
		} else if( command.equals("isfriend") ){
			handleIsFriend(handler, scanLine);
		} else if( command.equals("mutual") ){
			handleMutual(handler, scanLine);
		} else if( command.equals("relation") ){
			handleRelation(handler, scanLine);
		} else if( command.equals("notconnected") ){
			handleNotConnected(handler, scanLine);
		} else if( command.equals("popular") ){
			handlePopular(handler, scanLine);
		} else {
			scanLine.close();
			throw new Warning("Invalid Command");
		}
	
		if ( scanLine.hasNext() )
		      throw new Warning("Extra stuff on command line, starting with " + scanLine.next());
		
		scanLine.close();
		System.out.println("$"); // Prints a $ after every command is done
	}
	
	public static void handleIsFriend(CommandHandler handler, Scanner scanLine){
		try{
			String name1 = scanLine.next();
			String name2 = scanLine.next();
			System.out.println("isFriend " + name1 + " " + name2);
			handler.isFriend(name1, name2);
		} catch(NoSuchElementException e){
			throw new Warning("command name1 name2");
		}
	}
	
	public static void handleMutual(CommandHandler handler, Scanner scanLine){
		try{
			String name1 = scanLine.next();
			String name2 = scanLine.next();
			System.out.println("mutual " + name1 + " " + name2);
			handler.mutual(name1, name2);
		} catch(NoSuchElementException e){
			throw new Warning("command name1 name2");
		}
	}
	
	public static void handleRelation(CommandHandler handler, Scanner scanLine){
		try{
			String name1 = scanLine.next();
			String name2 = scanLine.next();
			System.out.println("relation " + name1 + " " + name2);
			handler.relation(name1, name2);
		} catch(NoSuchElementException e){
			throw new Warning("command name1 name2");
		}
	}
	
	public static void handleNotConnected(CommandHandler handler, Scanner scanLine){
		System.out.println("notconnected");
		handler.notConnected();
	}
	
	public static void handlePopular(CommandHandler handler, Scanner scanLine){
		System.out.println("popular");
		handler.popular();
	}

}
