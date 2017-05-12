package tr.edu.gtu.bkorkmaz.part1;

import java.util.*;

/**
 * Created by Burak Kağan Korkmaz on 20.04.2017.
 */
public class BinaryHeap <E> extends BinaryTree<E> implements Queue<E> {

    // Data Fields
    /** Root node of Binary Heap Tree */
    private Node <E> root;

    /** The ArrayList to hold the data. */
    public ArrayList<E> theData;

    /** An optional reference to a Comparator object. */
    private Comparator<E> comparator = null;


    //Methods
    private int compare(E left, E right) {
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else { // Use left's compareTo method.
            return ( (Comparable <E> ) left).compareTo(right);
        }
    }

    private void swap(int parent, int child) {
        E temp = theData.get(parent);
        theData.set(parent,theData.get(child));
        theData.set(child, temp);
    }

    public  BinaryHeap(){
        root = null;
        theData = new ArrayList<E>();
    }

    public BinaryHeap(int capacity, Comparator<E> comp){
        if (capacity < 1)
            throw new IllegalArgumentException();
        theData = new ArrayList <> (capacity + 1);
        comparator = comp;
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    @Override
    public int size() {
        return theData.size();
    }

    @Override
    public boolean isEmpty() {
        return theData.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return levelOrderIter();
    }

    @Override
    public boolean offer(E item) {
        // Add the item to the heap.
        theData.add(item);
        // child is newly inserted item.
        int child = theData.size() - 1;
        int parent = (child - 1) / 2; // Find child's parent.
        // Reheap
        while (parent >= 0 && compare(theData.get(parent),
                theData.get(child)) > 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // Save the top of the heap.
        E result = theData.get(0);
        // If only one item then remove it.
        if (theData.size() == 1) {
            theData.remove(0);
            return result;
        }
    /* Remove the last item from the ArrayList and place it into
       the first position. */
        theData.set(0, theData.remove(theData.size() - 1));
        // The parent starts at the top.
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= theData.size()) {
                break; // Out of heap.
            }
            int rightChild = leftChild + 1;
            int minChild = leftChild; // Assume leftChild is smaller.
            // See whether rightChild is smaller.
            if (rightChild < theData.size()
                    && compare(theData.get(leftChild),
                    theData.get(rightChild)) > 0) {
                minChild = rightChild;
            }
            // assert: minChild is the index of the smaller child.
            // Move smaller child up heap if necessary.
            if (compare(theData.get(parent),
                    theData.get(minChild)) > 0) {
                swap(parent, minChild);
                parent = minChild;
            }
            else { // Heap property is restored.
                break;
            }
        }
        return result;
    }

    @Override
    public boolean add(E o) {
        return offer(o);
    }

    @Override
    public E remove() {

        if(isEmpty())
            throw new NoSuchElementException();
        else
            return poll();
    }

    @Override
    public E element() {
        if(!isEmpty())
            return theData.get(0);
        else
            throw new NoSuchElementException();
    }

    @Override
    public E peek() {
        if(!isEmpty())
            return theData.get(0);
        else
            return null;
    }

    // Other methods not have implementation

    @Override
    public boolean contains(Object o) {
        if(isEmpty())
            return false;
        int size = size();
        for (int i = 0; i < size; i++) {
            if( theData.get(i).equals((E)o))
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }
}
