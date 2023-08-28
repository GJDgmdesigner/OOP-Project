import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *  ArrayList-based Binary Heap
 */
public class ALBinHeap<T> implements ExpMinPQ<T> {

    private final ArrayList<Node> heap;     // store items at indices 1 to n
    private int size;                       // number of items on binary heap

    /**
     * Represents a value-explicit priority pair.
     */
    private class Node {
        T item;
        int priority;

        Node(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }
    }

    /*
     ********************
     Helper methods start
     ********************
     */

    // INCLUDE ALL YOUR HELPER METHODS
    // IN YOUR LEARNING MALL SUBMISSION !



    private void swap(int a, int b){     // swap 2 nodes chara in same heap
        Node na = heap.get(a);
        Node nb = heap.get(b);

        T middlea = na.item;
        int midpria = na.priority;
        T middleb = nb.item;
        int midprib = nb.priority;

        na.item = middleb;
        na.priority = midprib;
        nb.item = middlea;
        nb.priority = midpria;

    }

    private void sink(int k) {                        //swap parent with the smaller child, until heap property is restored

        while (k * 2 + 1<= size) {
            int ilefts = k * 2;
            int irights = k * 2 + 1;
            int current = heap.get(k).priority;
            int leftc = heap.get(ilefts).priority;
            int rightc = heap.get(irights).priority;

            int minpri = rightc;      //default min para
            int indexmin = irights;

            if (leftc < rightc) {
                minpri = leftc;
                indexmin = ilefts;     // else update
            }

            if (current > minpri) {
                swap(k, indexmin);
                k = indexmin;

            } else {
                break;
            }

        }
    }

    /*
     ******************
     Helper methods end
     ******************
     */


    // LAB 14 PART A.1 EMPTY CONSTRUCTOR

    /**
     * Initializes an empty binary heap.
     */
    @SuppressWarnings("unchecked")
    public ALBinHeap() {
        heap = new ArrayList<>();
        heap.add(new Node(null,-1));
        size = 0;

    }
	
	
	// LAB 14 PART A.2 GETMIN

    /**
     * Returns an item with a smallest priority on this binary heap.
     * @return an item with a smallest priority on this binary heap
     * @throws NoSuchElementException if this binary heap is empty
     */
    @Override
    public T getMin() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        T item0 = heap.get(1).item;
        return item0;
    }


    // LAB 14 PART A.3 ADD

    /**
     * Adds a new item with its priority to this binary heap.
     * @param  item the item to add to this binary heap
     * @param priority the priority of the item
     * @throws IllegalArgumentException if item is null
     */
    @Override
    public void add(T item, int priority) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        size ++;
        heap.add(size, new Node(item, priority));   // add new node at the size position
        int k = size;                               // son node index
        Node parent = heap.get(k/2);
        Node son = heap.get(k);

        while(k > 1 && parent.priority > son.priority){    //while loop to change wrong parent and current position
            swap(k/2,k);                                  // swap parent and current position
            k = k/2;
            parent = heap.get(k/2);                      // go to lower index parent and sons
            son = heap.get(k);                           // and return loop
        }


    }


    // LAB 14 PART A.4 DELMIN

    /**
     * Removes and returns an item with a smallest priority on this binary heap.
     * @return an item with a smallest priority on this binary heap
     * @throws NoSuchElementException if this binary heap is empty
     */
    @Override
    public T delMin() {
        if (size == 0){
               throw new NoSuchElementException();       // binary heap is empty, return exception
           };
        //T item0 = this.getMin();                   //  get the smallest priority item
        T item0 = heap.get(1).item;
        swap(1,size);                             // move min tem to the bottom of the branch
        //int size0 = size - 1;
        heap.remove(size--);
        sink(1);                                 // reorder the array

        return item0;
    }
	

    // DO NOT MODIFY CODE BELOW
    // for testing and visualization
	
	/**
     * Returns true if this binary heap is empty.
     * @return true if this binary heap is empty;
     *         false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items on this binary heap.
     * @return the number of items on this binary heap
     */
    @Override
    public int size() {
        return size;
    }
		
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[size() + 1];
        result[0] = null;
        for (int i = 1; i <= size(); i++) {
            result[i] = heap.get(i).item;;
        }
        return result;
    }

}
