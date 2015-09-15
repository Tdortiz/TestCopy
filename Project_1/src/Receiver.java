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
		}
		
		Scanner readLine = null;
		
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

		MessageNode currentMessage = messageList.getHead();
		while(currentMessage != null){
			out.println(currentMessage.data);
			out.println();
			currentMessage = currentMessage.next;
		}
		
		/**
		Message currentMessage = messageList.getHead();
		
		while(messageList.next() != null){ // While the data isn't null
			out.println("--- Message " + currentMessage.getMessageNum());
			
			PacketList packetList = currentMessage.getPacketList();
			Packet currentPacket = packetList.getHead();
			
			while( packetList.next() != null ){
				currentPacket = packetList.getPacket();
				out.println(currentPacket);
				currentPacket = packetList.next();
			}
			
			currentMessage = messageList.getNext();
			out.println("--- End Message " + currentMessage.getMessageNum() + "\n" );
		}
		*/
		
		out.close();
	}
}