/**
 * Iterator interface for GenericList.java
 * 
 * @param <E> element 
 * 
 * @author Thomas Ortiz
 * @author Michael Mackrell
 * @author Jacob Stone
 * @author Curtis Moore
 */
public interface GenericIterator<E> {
	
	/**
	 * Checks if the list has another element E 
	 * @return true if there is another element false otherwise
	 */
	public boolean hasNext();
	
	/**
	 * Returns the next element E in the list
	 * @return the next element E
	 */
	public E next();
	
	/**
	 * Removes an element E from the list
	 */
	public void remove();
	
	
	
	
}
