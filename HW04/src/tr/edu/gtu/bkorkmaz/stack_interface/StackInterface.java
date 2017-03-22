package tr.edu.gtu.bkorkmaz.stack_interface;

/**
 * A stack is a data structure in which objects are inserted into and removed
 * from the same end (e.g. LIFO).
 * <br>Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public interface StackInterface <E>{

    /**
     * Pushes an item onto the top of the stack_interface and returns the item pushed.
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    E push(E obj);

    /**
     * Returns the object at the top of the stack_interface and removes it.
     * post: The stack_interface is one item smaller.
     * @return The object at the top of the stack_interface.
     */
    E pop();

    /**
     * Checks whether stack_interface is empty or not.
     * @return True if the stack_interface is empty, <br>False otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the stack_interface.
     * @return The number of item.
     */
    int size();

}
