package tr.edu.gtu.bkorkmaz.traverse;

import java.util.Iterator;

/**
 * Created by Burak Kağan Korkmaz on 04.04.2017.
 */
public class BinarySearchTree<E> extends BinaryTree<E> implements Iterable{

    @Override
    public int getSizeOfTree() {
        return super.getSizeOfTree();
    }

    @Override
    public void insert(Integer value) {
        super.insert(value);
    }

    public Iterator<E> levelOrderIterator(){
        return levelOrderIter();
    }


}
