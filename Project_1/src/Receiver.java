import java.util.Scanner;
import java.io.*;

/**
 * Receiver takes in an input file full of Messages and packets 
 * and reprints them in the correct sequential order.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class Receiver {
	
	/** 
	 * Initiates the program.
	 * @param args command line arguments.
	 */
	public static void main(String[] args){
		
		Scanner in = null;
		File input = new File(args[0]);
		File output = new File(args[1]);
		
		MessageList messageList = new MessageList();
		
		try{ 
			in = new Scanner(input);
		} catch(FileNotFoundException FNFE){
			FNFE.getMessage();
			System.out.println("You done goofed!");
		}
		
		Scanner readLine = null; // Read individual tokens in a line.
		
		while(in.hasNextLine()){
			String line = in.nextLine();
			readLine = new Scanner(line);
			
			int mssg_num = readLine.nextInt();
			int packet_num = readLine.nextInt();
			String mssg = readLine.next();
			 
			Message a = new Message(mssg_num, packet_num, mssg);
			messageList.add(a);  	
		}
		readLine.close();
		
		in.close();
		
		// At this point all message should be in the list and ordered
		
		printMessages(messageList, output);
	}

	/**
	 * Prints the messages.
	 * @param messageList list of messages.
	 * @param output the output file.
	 */
	private static void printMessages(MessageList messageList, File output) {
		PrintStream out = null;
		try {
			out = new PrintStream(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		out.println(messageList.toString());

		out.close();
	}
}