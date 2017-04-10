package tr.edu.gtu.bkorkmaz.family_tree;

import tr.edu.gtu.bkorkmaz.traverse.BinaryTree;

import java.util.Iterator;

/**
 * Binary Family Tree Class
 *
 * Created by Burak Kağan Korkmaz on 04.04.2017.
 */
public class FamilyTree extends BinaryTree<String> {


    public FamilyTree(String parent) {
        Node<String> node;
        //setNodeData(root, null, null, null);

    }

    /**
     * Add person
     * @param person Person to be added
     * @param parent Parent of the person
     */
    public void insert(String person, String parent) {
        if (root != null) {
            Node temp = root;
            int size = getSizeOfTree();
            for (int i = 0; i < size; i++) {
                if (root.getData().equals(parent)) {
//                    if (root.getLeft() == null)
//                        setNodeData(root, new Node<>(person), root.getRight(),
//                                root.getParent();
//                    else if(root.getLeft() != null){
//                        setNodeData(root.getLeft(), root.getRight(),
//                                new Node<>(person), root.getParent();
//                }
            }

        }
    }

}

    @Override
    public Iterator<String> levelOrderIter() {
        return super.levelOrderIter();
    }

    @Override
    /**
     * Pre order
     */
    public Iterator<String> iterator() {
        return super.iterator();
    }
}
