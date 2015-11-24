/**
 * 
 */


import java.util.Arrays;
import java.util.EmptyStackException;




/**
 * A class implementing simple LIFO Stack based on the SimpleStack interface.
 * Code used from textbook website http://www.buildingjavaprograms.com/code-files/3ed/
 * and from the 216 Slides.
 * @author Jacob Stone
 * @param <E> Generic type of an Stack
 */
public class Stack<E> implements SimpleStack<E> {

	/**
	 * The data for this stack.
	 */
	private E[] data;
	
	/**
	 * The size of this stack
	 */
	private int size;
	
	/**
	 * The initial capacity of the stack.
	 */
	private static final int INITIAL_CAPACITY = 50;
	
	/**
	 * Create an empty Stack
	 */
	@SuppressWarnings("unchecked")
	public Stack() {
		data = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items;
	 * false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Looks at the objects at top of this stack without removing it
	 * from the stack.
	 * @return the object at the top of the stack
	 * @throws EmptyStackException if this stack is empty
	 * 
	 */
	public E peek()  {
		if (!this.isEmpty()) {
			return data[size - 1];
		} else {
			throw new EmptyStackException();
		}
	}
	
	/**
	 * Removes the object at the top of this stack and returns that
	 * object as the value of this function
	 * @return the object at the top of this stack
	 * @throws EmptyStackException if this stack is empty.
	 */
	public E pop()  {
		E poppedData = null;
		if (!this.isEmpty()) {
			poppedData = data[size - 1];
			size--;
		} else {
			throw new EmptyStackException();
		}
		return poppedData;
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * @param item the item to be pushed onto this stack.
	 */
	public void push(E item) {
		ensureCapacity(size + 1);
		data[size] = item;
		size++;
	}
	
	/**
	 * Guarantees the stack has enough capacity for
	 * further operations.
	 * @param potentialCapacity
	 */
	private void ensureCapacity(int potentialCapacity) {
		if (potentialCapacity > data.length) {
			int newCapacity = data.length * 2 + 1;
			if (potentialCapacity > newCapacity) {
				newCapacity = potentialCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}
}
