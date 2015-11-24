public class Graph {

	private GenericList<Vertex> vertices;

	/**
	 * Constructs graph.
	 */
	public Graph() {
		vertices = new GenericList<Vertex>();
	}

	/**
	 * True if the graph is empty.
	 * 
	 * @return true if the graph is empty.
	 */
	public boolean isEmpty() {

		return vertices.isEmpty();

	}

	/**
	 * Returns true if the graph has this node. 
	 * Runs in O(n) time.
	 * 
	 * @param node
	 *            to search for
	 * @return true if node is in graph.
	 */
	public boolean VertexExists(Vertex vtr) {

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).equals(vtr)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the node with the given ID.
	 *
	 * @return node with given ID or null if absent.
	 */
	public Vertex getVertex(String nodeID) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getid().equals(nodeID) ) {
				return vertices.get(i);
			}
		}
		return null;
	}

	/**
	 * returns the array of nodes. Used in printing.
	 * 
	 * @return arrayList of nodes.
	 */
	public GenericList<Vertex> getVertexArray() {
		return vertices;
	}
	
	/**
	 * Determines if person1 is a friend of person2
	 * @param person1
	 * @param person2
	 * @return
	 */
	public boolean isFriend( Vertex person1, Vertex person2 ) {
		return person1.isAttached(person2);
	}
	
	public String relation (Vertex person1, Vertex person2 ) {
		if(person1.isAttached(person2)){
			return "" + person1.toString() + "\n" + person2.toString() + "\n";		
		}
		
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(person1);
		person1.setMarked(true);
		
		boolean sameCom = false;
		String shortestPath = "";
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			current.setMarked(true);
			
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			// JACOB JUST ADDED THIS. IF THE CURRENT NODE HAS NO UNMARK FRIENDS, DO NOT ADD HIM TO THE LIST
			boolean add = false;
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				
				if(adj.isMarked() ){
					continue;
				} else if( !(adj.isMarked()) ){
					q.add(adj);
					add = true;
				}
				
			}
			
			//System.out.println("current: " + current +  " " +  current.isMarked() + " " + current.getAdjVertices());
			if ( add ) {
				shortestPath += current.getid() + "\n";
			}
			
			if( current.isAttached(person2) ){
				sameCom = true;
				shortestPath += person2.toString() + "\n";
				break;
			}
			
			if ( current.getid().equals(person2.getid()) ) {
				sameCom = true;
				break;
			}
			
		}
		
		if (sameCom) {
			return shortestPath;
		} else {
			return "";
		}
		
	}
	
	public String mutual (Vertex person1, Vertex person2 ) {
		/**Queue<Vertex> q = new Queue<Vertex>();
		q.add(person1);
		person1.setMarked(true);
		
		boolean sameCom = false;
		String shortestPath = "";
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			
			if ( current.getid().equals(person2.getid()) ) {
				sameCom = true;
				break;
			}
			
			if ( !( current.getid().equals(person1.getid()) ) ) {
				shortestPath += current.getid() + "\n";
			}
			
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
				}
			}
		}
		
		if (sameCom) {
			return shortestPath;
		} else {
			return "";
		}*/
		String s = "";
		GraphIterator<Vertex> e = person1.getAdjVertices().iterator();
		while( e.hasNext() ){
			Vertex next = e.next();
			if( person2.getAdjVertices().contains( next )) {
				s += next + "\n";
			}
		}
		
		return s;
	}
	
	public String popular(){
		String popular = "";
		GraphIterator<Vertex> e = vertices.iterator();
		
		while( e.hasNext() ){
			Vertex person  = e.next();
			
			//System.out.println("BFS of " + person + " : " + BFSofVertex(person) );
			double bfs = BFSofVertex(person);
			unmark();
			//System.out.println("getPow(" + person + ") = " + getPow(person,1));
			person.setPopularity( bfs / getPow(person, 1) );
			unmark();
		}
			
		// Prints the popularities for testing purposes 
		GraphIterator<Vertex> f = vertices.iterator();
		double max = Double.MIN_VALUE;
		while( f.hasNext() ){
			Vertex temp = f.next();
			if(temp.getPopularity() >= max){
				max = temp.getPopularity();
			}
			//System.out.println(temp + ".popularity = " + temp.getPopularity());
		}
		
		GraphIterator<Vertex> f2 = vertices.iterator();
		while( f2.hasNext() ){
			Vertex temp = f2.next();
			if(temp.getPopularity() == max){
				popular += temp + "\n";
			}
			//System.out.println(temp + ".popularity = " + temp.getPopularity());
		}
		
		
		return popular;
	}
	
	/**
	 * This method gets the BFS of a specific node which equates to 
	 * the number of nodes the vertex is connected to.
	 * (The top part of fraction for popularity)
	 * @param person vertex to run BFS on
	 * @return numbers of nodes person is connected to.
	 */
	public int BFSofVertex(Vertex person){
		int counter  = 0;
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(person);
		person.setMarked(true);
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			current.setMarked(true);
			//System.out.println("current: " + current +  " " +  current.isMarked() + " " + current.getAdjVertices());
			
			if(current.getid().equals(person.getid())){
				
			} else {
				counter++;
			}

			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				//System.out.println("adjacent is : " + adj);
				
				if(adj.isMarked() ){
					continue;
				} else if( !(adj.isMarked()) ){ 
					adj.setMarked(true);
					q.add(adj);
				}
				
			}
		}
		return counter ;
	}
	
	/**
	 * Returns the total power of a vertex 
	 * (the lower part of fraction for popularity)
	 * @param person to analyze 
	 * @param depth of a node from the original vertex
	 * @return the cumulative power of a vertex
	 */
	public int getPow(Vertex person, int depth){
		//System.out.println("getpow( " + person + ", " + depth + ")");
		boolean[] arr = new boolean[person.getAdjVertices().size()];
		int i = 0;

		person.setMarked(true);
		GraphIterator<Vertex> adjList = person.getAdjVertices().iterator();
		int power = 0;
		// Goes through each adjacent node and adds on to power if they haven't been marked yet.
		while(adjList.hasNext() ){
			Vertex temp = adjList.next();
			if( !temp.isMarked() ){
				power += depth;
			} else {
				arr[i] = true;
			}
			i++;
			temp.setMarked(true);
		}
		i = 0;
		//System.out.println("    POWER: " + power);
		GraphIterator<Vertex> adjList2 = person.getAdjVertices().iterator();
		while(adjList2.hasNext()){
			Vertex temp = adjList2.next();
			//if(temp.isMarked() == false){
			if(arr[i] == false){
				arr[i] = true;
				i++;
				power += getPow(temp,depth + 1);
				//return power += getPow(temp, depth + 1);
			} else {
				i++;
				continue;
			}
		}
		//System.out.println("    FINAL POWER: " + power);
		return power;
	}

	public int notConnected() {
		int loners = 0;
		int notCon = 1;
		int componetNodes = 0;
		int comCount = 0;
		
		GraphIterator<Vertex> vrtList = vertices.iterator();
		
		while (vrtList.hasNext()) {
			Vertex current = vrtList.next();
			if (!current.isMarked()) {
				comCount++;
				componetNodes = findComponentNodes(current);
				if ( componetNodes == 1 ) {
					loners++;
				} else {
					notCon *= componetNodes;
				}
			}
		}
		
		int notConLoners = loners * (vertices.size() - 1);
		notCon += notConLoners;
		
		if ( comCount == 1) {
			return 0;
		} else {
			return notCon;
		}
		
	}
	
	public int findComponentNodes( Vertex person ) {
		int count = 0;
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(person);
		person.setMarked(true);
		count++;
		
		while (!q.isEmpty()) {
			Vertex current = q.remove();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				if (!adj.isMarked()) {
					adj.setMarked(true);
					q.add(adj);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void unmark(){
		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).setMarked(false) ;
		}
	}
}
