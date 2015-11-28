public class Graph {

	private GenericList<Vertex> vertices;
	private String popular;
	private int notConnected;

	/**
	 * Constructs graph.
	 */
	public Graph() {
		vertices = new GenericList<Vertex>();
		popular = null;
		notConnected = -1;
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
	
	public String relation (Vertex start, Vertex goal) {
		if(start.isAttached(goal)){
			return "" + start.toString() + "\n" + goal.toString() + "\n";		
		}
		
		
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(start);
		start.setMarked(true);
		boolean pathFound = false;
		
		while ( !(q.isEmpty()) ) {
			Vertex current = q.remove();
			
			if ( current.getid().equals(goal.getid()) ) {
				//path is found
				pathFound = true;
				break;
			}
			
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while (e.hasNext()) {
				Vertex adj = e.next();
				
				if( !(adj.isMarked()) ){
					q.add(adj);
					adj.setMarked(true);
					adj.setBackPointer(current);
				}
				
			}
		}
		
		
		if ( pathFound ) {
			String shortestPath = "";
			boolean foundStart = false;
			Vertex current = goal;
			Stack<Vertex> s = new Stack<Vertex>();
			while ( !foundStart ) {
				
				if ( current.getid().equals(start.getid()) ) {
					foundStart = true;
					s.push(current);
				} else {
					s.push(current);
					current = current.getBackPointer();
				}
				
			}
			
			while ( !(s.isEmpty()) ) {
				shortestPath += s.peek().getid() + "\n";
				s.pop();
			}
			return shortestPath;
		}
		
		
		return "";
	}
	
	public String relationBroke (Vertex person1, Vertex person2 ) {
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
			//current.setMarked(true);
			
			
			//int AdjNum = current.getEdges().size();
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			// JACOB JUST ADDED THIS. IF THE CURRENT NODE HAS NO UNMARK FRIENDS, DO NOT ADD HIM TO THE LIST
			boolean add = false;
			
			while ( e.hasNext() ) {
				Vertex adj = e.next();
				
				if( !(adj.isMarked()) ){
					q.add(adj);
					adj.setMarked(true);
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
	
	public String getPopular(){
		if(this.popular == null){
			return Tpopular();
		} else {
			return this.popular;
		}
	}
	
	private String Tpopular(){
		String popular = "";
		GraphIterator<Vertex> e = vertices.iterator();
		double max = 0;
		
		while( e.hasNext() ){
			Vertex person  = e.next();
			
			//System.out.println("BFS of " + person + " : " + BFSofVertex(person) );
			double bfs = BFSofVertex(person);
			if(bfs == 0){
				person.setPopularity(0);
				continue;
			}
			unmark();
			double pow = getPow(person, 1);
			if(pow == 0){
				person.setPopularity(0);
				System.out.println(person + ": " + person.getPopularity());
				continue;
			}
			//System.out.println("getPow(" + person + ") = " + getPow(person,1));
			System.out.println(person + ": " + bfs + " / " + pow);
			person.setPopularity( bfs / pow );
			
			if(person.getPopularity() >= max){
				max = person.getPopularity();
			}
			
			unmark();
		}

		GraphIterator<Vertex> f2 = vertices.iterator();
		while( f2.hasNext() ){
			Vertex temp = f2.next();
			if(temp.getPopularity() == max){
				popular += temp + "\n";
			}
			//System.out.println(temp + ".popularity = " + temp.getPopularity());
		}
		this.popular = popular;
		return popular;
	}
	
	/**
	 * This method gets the BFS of a specific node which equates to 
	 * the number of nodes the vertex is connected to.
	 * (The top part of fraction for popularity)
	 * @param person vertex to run BFS on
	 * @return numbers of nodes person is connected to.
	 */
	private int BFSofVertex(Vertex person){
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
		if(counter == 0){
			return 1;
		}
		return counter;
	}
	
	/**
	 * Returns the total power of a vertex 
	 * (the lower part of fraction for popularity)
	 * @param person to analyze 
	 * @param depth of a node from the original vertex
	 * @return the cumulative power of a vertex
	 */
	private int getPow(Vertex person, int depth){
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

	public int getNotConnected(){
		if(this.notConnected == -1){ // if we haven't done not connected yet.
			return notConnected();
		} else {
			return this.notConnected;
		}
	}
	
	private int notConnected() {
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
		
		
		
		
		int remaining = vertices.size();
		int notConLoners = 0;
		
		for ( int i = 0; i < loners; i++ ) {
			notConLoners += (remaining - 1 );
			remaining--;
		}
		
		notCon += notConLoners;
		
		if ( comCount == 1) {
			this.notConnected = 0;
			return 0;
		} else {
			this.notConnected = notCon;
			return notCon;
		}
		
	}
	
	private int findComponentNodes( Vertex person ) {
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

	public String toString(){
		return this.vertices.toString();
	}
	
	
	
	
	
	
	
	//////////////////////////////////////////////////
	/// JACOB'S POPULAR ALGORITHM
	public void popular() {
		double max = 0;
		GraphIterator<Vertex> e = vertices.iterator();
		
		//For each vertex in the graph, calculate the popularity
		while ( e.hasNext() ) {
			Vertex current = e.next();
			//find all the people this vertex is connected to
			int top = findComponentNodes( current );
			
			// A special case, if the person has no friends their popularity is 0
			if ( top == 1 ) {
				current.setPopularity( 0.0 );
				unmark();
			} else {
				unmark();
				// calculate the sum of length(current, B) for all persons B.
				int bottom = power( current );
				// calculate the popularity for the current person and
				//set it as their field
				double pop = (double) top / bottom;
				current.setPopularity( pop );
				// if the popularity of the current person is greater
				// than the max popularity thus far, set it to the max
				if ( pop > max )
					max = pop;
				unmark();
			}
		}
		
		//build the popular String to use in the program
		String popularString = "";
		e = vertices.iterator();
		while ( e.hasNext() ) {
			Vertex current = e.next();
			// If the current person's popularity is one of the 
			// most popular people, add them to the string
			if ( current.getPopularity() == max )
				popularString += current.getid() + "\n";
		}
		this.popular = popularString;
	}
	
	private int power ( Vertex a ) {
		int sum = 0;
		GraphIterator<Vertex> e = vertices.iterator();
		
		// for every pair in the graph, sum their length
		while ( e.hasNext() ) {
			Vertex b = e.next();
			
			if ( a.getid() == b.getid() ) {
				//Do nothing, this pair does not count
			} else {
				// calculate the number of edges in the shortest path from
				// a to b, if it exits, zero otherwise
				sum += shortestPathEdgesBFS( a, b );
			}
			unmark();
		}
		return sum;
	}
	
	private int shortestPathEdgesBFS( Vertex start, Vertex goal ) {
		// if start and goal have a direct friend relationship,
		//length( start, goal ) == 1
		if ( start.isAttached(goal) ) {
			return 1;
		}
		
		// otherwise, it is the number of edges in the shortest path
		//from start to goal
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(start);
		start.setMarked(true);
		boolean pathFound = false;
		
		while ( !(q.isEmpty()) ) {
			Vertex current = q.remove();
			
			if ( current.getid().equals(goal.getid()) ) {
				//path is found
				pathFound = true;
				break;
			}
			
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while (e.hasNext()) {
				Vertex adj = e.next();
				
				if( !(adj.isMarked()) ){
					q.add(adj);
					adj.setMarked(true);
					adj.setBackPointer(current);
				}
				
			}
		}
		
		if ( pathFound ) {
			int pathCount = 0;
			boolean foundStart = false;
			Vertex current = goal;
			while ( !foundStart ) {
				
				if ( current.getid().equals(start.getid()) ) {
					foundStart = true;
					pathCount++;
				} else {
					pathCount++;
					current = current.getBackPointer();
				}
				
			}
			//return the number of edges in the shortest path,
			//which is the number of vertices in the path minus 1
			return pathCount - 1;
		}
		
		// return 0 if there was no path between start and goal
		return 0;
	}
	
	
	
	
	
	
	
	/**public String relation (Vertex start, Vertex goal) {
		if(start.isAttached(goal)){
			return "" + start.toString() + "\n" + goal.toString() + "\n";		
		}
		
		
		Queue<Vertex> q = new Queue<Vertex>();
		q.add(start);
		start.setMarked(true);
		boolean pathFound = false;
		
		while ( !(q.isEmpty()) ) {
			Vertex current = q.remove();
			
			if ( current.getid().equals(goal.getid()) ) {
				//path is found
				pathFound = true;
				break;
			}
			
			GraphIterator<Vertex> e = current.getAdjVertices().iterator();
			
			while (e.hasNext()) {
				Vertex adj = e.next();
				
				if( !(adj.isMarked()) ){
					q.add(adj);
					adj.setMarked(true);
					adj.setBackPointer(current);
				}
				
			}
		}
		
		
		if ( pathFound ) {
			String shortestPath = "";
			boolean foundStart = false;
			Vertex current = goal;
			Stack<Vertex> s = new Stack<Vertex>();
			while ( !foundStart ) {
				
				if ( current.getid().equals(start.getid()) ) {
					foundStart = true;
					s.push(current);
				} else {
					s.push(current);
					current = current.getBackPointer();
				}
				
			}
			
			while ( !(s.isEmpty()) ) {
				shortestPath += s.peek().getid() + "\n";
				s.pop();
			}
			return shortestPath;
		}
		
		
		return "";
	} */
	
	
	
	
	
}
