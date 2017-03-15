package tr.edu.gtu.bkorkmaz.abstractCollection;

import java.util.AbstractCollection;

/**
 * My Abstract Collection
 *
 * Created by Burak Kağan Korkmaz on 15.03.2017.
 */
public abstract class myAbstractCollection<E> extends AbstractCollection {

    public myAbstractCollection(){
        super();
    }

    public void appendAnything(myAbstractCollection obj){
        addAll(obj);

    }


}
