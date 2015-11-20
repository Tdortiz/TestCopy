/**
 * 
 */


import java.util.NoSuchElementException;




/**
 * Generic Queue class.  
 * Code used from textbook website http://www.buildingjavaprograms.com/code-files/3ed/
 * and from the 216 Slides.
 * @author Shoaib
 * @param <E> Generic Type of an Queue.
 *
 */
public class Queue<E> implements SimpleQueue<E> {
	
	private Node head;
	
	
	
	//--------------------Inner Class------------------------//
	
   /**
    * Node Class created to implement Queue as an
    * Linked List
    */
    private class Node {
		
		/** Create a node nest*/
		public Node next;
		
		/** Create a device d*/
		public E c;
		
		/**
		 * Constructor of Node Object
		 * @param d device that is in the node
		 * @param next the location of next device
		 */
		public Node(E c, Node next){
			this.c = c;
			this.next = next;
		}

	}

	//-------------------------------Inner Class---------------------//
    
    /**
	 * Constructing  Queue
	 */
	public Queue(){
		head = null;
		
		
	}

	/**
	 * Adding the Object in the Queue
	 * @param item Generic item that needed to be added
	 */
	public void add(E item) {
		Node current = head;
		if(head == null){
			head = new Node(item, null);
			
		}
		else{
			while(current.next != null){
				current = current.next;
			}
			current.next = new Node(item, current.next);
			
			
		}
	}

	/**
	 * Removing the Object from the Queue
	 * @return Object that get removed
	 * @throws NoSuchElementException  if object is not there.
	 */
	@Override
	public E remove() {
		Node current = head;
		
		if(head == null){
			throw new NoSuchElementException();
		}
		
		head = head.next;
		return current.c;
	}

	
	/**
	 * Retrieve, but does not remove the
	 * first object in the Queue
	 * @return Object that got retrieve
	 */
	public E peek() {
		if(head == null){
			throw new NoSuchElementException();
		}
		return head.c;
	}

	/**
	 * Check to see if the Queue is Empty or
	 * not
	 * @return true if the Queue is Empty, false if its not.
	 */
	@Override
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}

}
