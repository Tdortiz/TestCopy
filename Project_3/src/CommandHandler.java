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
		graph.unmark();
		if( graph.isFriend(hashGraph.get(name1), hashGraph.get(name2)) ){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		graph.unmark();
		
	}
	
	public void mutual(String name1, String name2){
		graph.unmark();
		System.out.print( graph.mutual(hashGraph.get(name1), hashGraph.get(name2)) );
		graph.unmark();
	}
	
	public void relation(String name1, String name2){
		graph.unmark();
		System.out.print( graph.relation(hashGraph.get(name1), hashGraph.get(name2)) );
		graph.unmark();
	}
	
	public void notConnected(){
		graph.unmark();
		System.out.println( graph.notConnected() );
		graph.unmark();
	}
	
	public void popular(){
		graph.unmark();
		System.out.print( graph.getPopular() );
		graph.unmark();
		
	}
}
