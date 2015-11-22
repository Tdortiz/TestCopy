import java.util.HashMap;

/**
 * Wrapper class that handles the command input.
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public class CommandHandler {

	private Graph graph;
	private HashMap<String, Vertex> hashGraph;
	
	/**
	 * Constructor for the command handler class.
	 * @param tree the tree use as the data structure.
	 */
	public CommandHandler(Graph graph, HashMap<String, Vertex> hashGraph) {
		this.graph = graph;
		this.hashGraph = hashGraph;
	}
	
	public void isFriend(String name1, String name2){
		System.out.println( graph.isFriend(hashGraph.get(name1), hashGraph.get(name2)) );
		
	}
	
	public void mutual(String name1, String name2){
		System.out.print( graph.mutual(hashGraph.get(name1), hashGraph.get(name2)) );
	}
	
	public void relation(String name1, String name2){
		System.out.print( graph.relation(hashGraph.get(name1), hashGraph.get(name2)) );
	}
	
	public void notConnected(){
		System.out.println( graph.notConnected() );
	}
	
	public void popular(){
		System.out.println("HI POPULAR, I'M DAD");
		
	}
}
