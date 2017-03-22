package tr.edu.gtu.bkorkmaz.stack_interface;

import java.util.ArrayList;

/**
 * A stack which is extended from the ArrayList class
 * Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public class StackA <E> extends ArrayList implements StackInterface<E>{

    /**
     * Pushes an item onto the top of the stack and returns the
     * item pushed.
     *
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    public E push(E obj) {
        this.add(obj);
        return obj;
    }

    @SuppressWarnings("unchecked")
    /**
     * Returns the object at the top of the stack and removes it.
     * post: The stack is one item smaller.
     *
     * @return The object at the top of the stack.
     */
    public E pop() {
        return (E) this.remove(size() - 1);
    }

    /**
     * Checks whether stack is empty or not.
     *
     * @return True if the stack is empty, <br>False otherwise.
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     * @return The number of item.
     */
    public int size(){
        return super.size();
    }


}
