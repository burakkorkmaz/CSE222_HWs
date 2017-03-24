package tr.edu.gtu.bkorkmaz.stack_interface;


import java.util.EmptyStackException;

/**
 * A stack composed with Node class
 * Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public class StackC <E> implements StackInterface<E> {


    /** A Node is the building block for a single-linked list. */
    private static class Node < E > {
        // Data Fields
        /** The reference to the data. */
        private E data;

        /** The reference to the next node. */
        private Node next;

        // Constructors
        /** Creates a new node with a null next field.
         @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /** Creates a new node that references another node.
         @param dataItem The data stored
         @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node < E > nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    } //end class Node

    // Data Fields
    /** The reference to the first stack node. */
    private Node < E > topOfStackRef;
    private int size = 0;

    /**
     * Constructor of StackC
     */
    public StackC() {
        topOfStackRef = null;
        size = 0;
    }

    /**
     * Pushes an item onto the top of the stack and returns the
     * item pushed.
     *
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    public E push(E obj) {
        topOfStackRef = new Node<E>(obj, topOfStackRef);
        ++size;
        return obj;
    }

    /**
     * Returns the object at the top of the stack and removes it.
     * post: The stack is one item smaller.
     *
     * @return The object at the top of the stack.
     */
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            E temp = topOfStackRef.data;
            topOfStackRef = topOfStackRef.next;
            --size;
            return temp;
        }
    }

    /**
     * Checks whether stack is empty or not.
     *
     * @return True if the stack is empty, <br>False otherwise.
     */
    public boolean isEmpty() {

        return topOfStackRef == null;
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return The number of item.
     */
    public int size() {
        return size;
    }



}