package tr.edu.gtu.bkorkmaz.my_queue;

import tr.edu.gtu.bkorkmaz.stack_interface.StackC;

import java.util.Queue;

/**
 *
 * Created by Burak Kağan Korkmaz on 23.03.2017.
 */
public class MyQueue<E> extends KWLinkedList{

    public MyQueue<E> reverse() {

        StackC<E> stack = new StackC<E>();
        int size = this.size();


       while (this.size() != 0) {

           stack.push((E) this.remove(0));
       }
        while (this.size() != size){
           this.add(stack.pop());
        }

        return  this;
    }

    public Queue<E> reverseQueue(Queue obj){
        E element;
        if(obj.isEmpty())
            return obj;
        else {
           element = (E) obj.remove();
           reverseQueue(obj);
            obj.add(element);
           return obj;
        }
    }

}
