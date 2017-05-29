import java.util.Objects;

/**
 * Created by Burak Kağan Korkmaz on 01.05.2017.
 */
public class BinarySearchTree<E extends Comparable<E>>  {

    private BinaryTree<E> tree;

    private int compare(BinarySearchTree<E> other){

        return 0;
    }
    public BinarySearchTree(){
        tree = new BinaryTree<>();
    }

    public BinarySearchTree(E element){
        tree = new BinaryTree<>(element,null,null);
    }

    public E add(E element){
        add(tree,element);
        return element;
    }

    private void add(BinaryTree<E> other, E element){
        BinaryTree<E> temp;
        if(Objects.equals(other.getRoot(), null)){
            other.getRoot().data = element;
        }else if (other.getData().compareTo(element) == 0){
            return;
        }else if(other.getData().compareTo(element) < 0){
            if(other.getLeftSubtree() != null){
                add(other.getLeftSubtree(),element);
            }
            else {
                other.setLeftSubtree(element);
            }
        }else if (other.getData().compareTo(element) > 0){
            if(other.getRightSubtree() != null){
                add(other.getRightSubtree(),element);
            }
            else {
                other.setRightSubtree(element);
            }
        }
    }
}
