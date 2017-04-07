package tr.edu.gtu.bkorkmaz.priority_queue;

import java.util.LinkedList;

/**
 * Created by Burak Kağan Korkmaz on 24.03.2017.
 */
public class PriorityQueueA<E> extends LinkedList{

    private E findMin(){
        int size = size();
        if(size == 0){
            return null;
        }
        else{
            E min = (E) peek();
            for (int i = 0; i < size; i++) {
                if(minremove(i))
            }
        }

    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public E deleteMin(){

        return null;
    }

    public void insert(){

    }
}
