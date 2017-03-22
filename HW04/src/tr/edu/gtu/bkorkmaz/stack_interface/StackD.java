package tr.edu.gtu.bkorkmaz.stack_interface;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Burak Kağan Korkmaz on 21.03.2017.
 */
public class StackD <E> implements StackInterface<E> {

    private Queue myStackD;

    public StackD() {
        myStackD = new LinkedList();
    }


    /**
     * Pushes an item onto the top of the stack and returns the
     * item pushed.
     *
     * @param obj The object to be inserted.
     * @return The object inserted.
     */
    public E push(E obj) {
        myStackD.offer(obj);
        return obj;
    }

    /**
     * Returns the object at the top of the stack and removes it.
     * post: The stack is one item smaller.
     *
     * @return The object at the top of the stack.
     */
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            int size = size();
            for (int i = 0; i < size - 1 ; i++) {
                myStackD.add(myStackD.remove());
            }
            return (E) myStackD.remove();
        }
    }

    /**
     * Checks whether stack is empty or not.
     *
     * @return True if the stack is empty, <br>False otherwise.
     */
    public boolean isEmpty() {
        return myStackD.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return The number of item.
     */
    public int size() {
        return myStackD.size();
    }

    @Override
    public String toString() {
        String s = "";
        E t;
        for (int i = 0; i < size(); i++) {
            t = (E) myStackD.remove();
            s += t.toString();
            myStackD.add(t);
        }
        return s;
    }
}