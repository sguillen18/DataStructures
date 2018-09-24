
public class LinkedBag <T> implements BagInterface <T> {
	private Node firstNode;
	private int numberOfElements;
	
	public LinkedBag() {
		firstNode = null;
		numberOfElements = 0;
	}
	
	private class Node {
		T data;
		Node next;
		
		public Node(T data, Node nextNode) {
			this.data = data;
			next = nextNode;
		}
		
		public Node(T newData) {
			this(newData, null);
		}
		
		/*public T getData() {
			return data;
		}
		
		public void setData(T newData) {
			data = newData;
		}
		
		public T getNext() {
			return next;
		}
		
		public void setNext(Node thing) {
			next = thing;
		}*/
	}
	
	//returns number of Nodes
	public int getCurrentSize() {
		return numberOfElements;
	}
	
	//returns true if there are no Nodes
	public boolean isEmpty() {
		return (numberOfElements == 0);
	}
	
	//adds a Node to the last Node
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfElements ++;
		return true;
	}
	
	//removes one of the elements given in the bag
	//returns true if was able to remove the item
	//otherwise false
	public boolean remove(T anEntry) {
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			if(anEntry.equals(curr.data)) {
				curr.data = firstNode.data;
				firstNode = firstNode.next;
				numberOfElements--;
				return true;
			}
		}
		return false;
	}
	
	//removes last object in bag
	//returns true if can remove an item
	public boolean remove() {
		if(firstNode != null) {
			firstNode = firstNode.next;
			numberOfElements--;
			return true;
		}
		else return false;
	}
	
	//empty bag
	public void clear() {
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			curr.data = null;
			numberOfElements--;
		}	
	}
	
	//returns true if the bag contains given element
	public boolean contains(T anEntry) {
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			if(anEntry.equals(curr.data)) {
				return true;
			}
		}
		return false;
	}
	
	//returns how many times an item appears in a bag
	public int getFrequencyOf (T anEntry) {
		int counter = 0;
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			if(anEntry.equals(curr.data)) {
				counter++;
			}
		}
		return counter;
	}
	
	//creates bag into an array
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfElements];
		int count = 0;
		for (Node currentNode = firstNode; currentNode != null; currentNode = currentNode.next, count++) {
			result[count] = currentNode.data;
		}
		return result;
	}

}
