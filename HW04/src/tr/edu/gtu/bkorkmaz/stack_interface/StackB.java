package tr.edu.gtu.bkorkmaz.stack_interface;

import java.util.ArrayList;

/**
 * A stack composed with ArrayList
 * <br>Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public class StackB <E> implements StackInterface<E> {

    private ArrayList<E> myStackB;

    public StackB() {
        myStackB = new ArrayList<>();
    }


    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    public E push(E obj) {
        myStackB.add(obj);
        return obj;
    }

    /**
     * Returns the object at the top of the stack and removes it.
     * post: The stack is one item smaller.
     *
     * @return The object at the top of the stack.
     */
    public E pop() {
        return myStackB.remove( size() - 1);
    }

    /**
     * Checks whether stack is empty or not.
     *
     * @return True if the stack is empty, <br>False otherwise.
     */
    public boolean isEmpty() {
        return myStackB.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return The number of item.
     */
    public int size() {
        return myStackB.size();
    }

}
