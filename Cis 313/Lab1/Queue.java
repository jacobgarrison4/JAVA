public class Queue<E> {
	private Node<E> head;
	private Node<E> tail;
	
	public Queue(){
		
		// We want to initialize our Queue to be empty
		// (ie) set head and tail to be null
		head = null;
		tail = null;
	}
	
	public void enqueue(E newData){
	
		// Create a new node whose data is newData and whose next node is null
		// Update head and tail
		// Hint: Think about what's different for the first node added to the Queue
		Node<E> x = new Node<E>(newData, null);
		if(isEmpty()){
			head = x;
			tail = x;
		}

		else {
			tail.setNext(x);
			tail = x;
		}
	}
	
	public Node<E> dequeue(){
	
		// Return the head of the Queue
		// Update head
		// Hint: The order you implement the above 2 tasks matters, so use a temporary node
	 	//	     to hold important information
		// Hint: Return null on a empty Queue
		Node<E> x = head;
		if (isEmpty()){
			return null;
		}

		else {
			head = head.getNext();
			return x;
		}
	}
	
	public boolean isEmpty(){
	
		// Check if the Queue is empty
		if (head == null){
			return true;
		}

		else {
			return false;
		}
	}
	
	public void printQueue(){

		// Loop through your queue and print each Node's data
		while (head != null){
			System.out.println(head.getData() + " ");
			head = head.getNext();
		}
	}
}
