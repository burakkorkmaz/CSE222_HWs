package tr.edu.gtu.bkorkmaz.stack_interface;

import java.util.ArrayList;

/**
 * A stack which is extended from the ArrayList class
 * Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public class StackA <E> extends ArrayList implements StackInterface{



    /**
     * Pushes an item onto the top of the stack_interface and returns the item pushed.
     *
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    public Object push(Object obj) {
        return null;
    }

    /**
     * Returns the object at the top of the stack_interface and removes it.
     * post: The stack_interface is one item smaller.
     *
     * @return The object at the top of the stack_interface.
     */
    public Object pop() {
        return null;
    }

    /**
     * Checks whether stack_interface is empty or not.
     *
     * @return True if the stack_interface is empty, <br>False otherwise.
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of items in the stack_interface.
     *
     * @return The number of item.
     */
    public int size() {
        return 0;
    }
}
