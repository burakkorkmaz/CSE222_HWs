package tr.edu.gtu.bkorkmaz.stack_interface;

/**
 * A stack is a data structure in which objects are inserted into and removed
 * from the same end (e.g. LIFO).
 * <br>Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public interface StackInterface <E>{

    /**
     * Pushes an item onto the top of the stack and returns the
     * item pushed.
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    E push(E obj);

    /**
     * Returns the object at the top of the stack and removes it.
     * post: The stack is one item smaller.
     * @return The object at the top of the stack.
     */
    E pop();

    /**
     * Checks whether stack is empty or not.
     * @return True if the stack is empty, <br>False otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the stack.
     * @return The number of item.
     */
    int size();

}
