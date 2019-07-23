import java.util.Comparator;
import java.lang.Math;

public class MaxHeap<E extends Comparable> {
    private E[] myArray;
    private int maxSize;
    private int length;

    public MaxHeap(int s){
    	// Build the constructor
        setMaxSize(s);
        setLength(0);
        myArray = (E[]) new Comparable[maxSize];
    }

	// helper functions
    public E[] getArray(){
        return myArray;
    }

    public void setArray(E[] newArray){
    	if (newArray.length > maxSize){
    		return;
    	}
        myArray = newArray;
        length = newArray.length-1;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public void setMaxSize(int ms){
        maxSize = ms;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int l){
        length = l;
    }

    // Other Methods
    public void insert(E data){
    
    	// Insert an element into your heap.
    	// When adding a node to your heap, remember that for every node n, 
    	// the value in n is greater than or equal to the values of its children, 
    	// but your heap must also maintain the correct shape.
		// (ie there is at most one node with one child, and that child is the left child.)
		// (Additionally, that child is farthest left possible.)
        length += 1;
        int len = getLength();
        int parent = length / 2;
        myArray[length] = data;
        while((len > 1) && (myArray[parent].compareTo(myArray[len]) == -1)){
            myArray[len] = myArray[parent];
            myArray[parent] = data;
            len = parent;
            parent = len / 2;
        }
    }

    public Comparable<E> maximum(){
        // return the maximum value in the heap
        if (myArray.length != 0){
            return myArray[1];
        }
        else{
            return null;
        }
    }

    public Comparable<E> extractMax(){
        // remove and return the maximum value in the heap
        //If array is empty, return null
        if (myArray.length == 0){
            return null;
        }
        //else...
        //store the max value, decrement heap size, restructure max heap
        E max = myArray[0];
        myArray[0] = myArray[getLength()];
        setLength(getLength() - 1);
        heapify(0);
        return max;
    }
    
    public void heapify(int i){
    	// helper function for reshaping the array
        int lc = leftChild(i);
        int rc = rightChild(i);
        int largest = i;
        if ((lc <= length) && (myArray[lc].compareTo(myArray[i]) == 1)){
            largest = lc;
        }
        else{
            largest = i;
        }

        if ((rc <= length) && (myArray[rc].compareTo(myArray[largest]) == 1)){
            largest = rc;
        }
        
        if (largest != i){
            E current = myArray[i];
            myArray[i] = myArray[largest];
            myArray[largest] = current;
            heapify(largest);
        }
    }
    
    public void buildHeap(E[] newArr){
		// used for the extra credit
        setArray(newArr);
        for (int i = 0; i < newArr.length; i++){
            insert(newArr[i]);
        }
	}

    private int leftChild(int i){
        //Helper function to return left child
        return (2 * i);
    }

    private int rightChild(int i){
        //Helper function to return right child
        return ((2 * i) + 1);
    }
}
