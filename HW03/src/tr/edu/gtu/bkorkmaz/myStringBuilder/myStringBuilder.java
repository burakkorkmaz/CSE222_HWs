package tr.edu.gtu.bkorkmaz.myStringBuilder;

import tr.edu.gtu.bkorkmaz.singleLinkedList.SingleLinkedList;


/**
 * Build string from anything and can be written the string to file.
 *
 * Created by Burak Kağan Korkmaz on 14.03.2017.
 */
public class myStringBuilder<E> extends SingleLinkedList{

    E [] array;

    private SingleLinkedList<E> str = new SingleLinkedList<>();


    public myStringBuilder(E anything){

        append(anything);
    }

    public void append(E anything){
        str.addLast(anything);
    }

    public String toStringIndex(){

        return null;
    }

    public String toStringIter(){

        return null;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
