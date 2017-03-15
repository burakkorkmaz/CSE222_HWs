package tr.edu.gtu.bkorkmaz.singleLinkedList;

/**
 * Class to represent a linked list with a link from each node to next node.
 *
 * <br>Created by Burak Kağan Korkmaz on 14.03.2017.
 */
public class SingleLinkedList<E> {

    /**
     * The list head
     */
    private Node<E> head;

    /**
     * Keeps deleted nodes at garbage.
     */
    private Node<E> garbage;
    /**
     * A block for Linked List
     * */
    private static class Node<E> {
        // Data Fields
        /**
         * The reference to the data.
         */
        private E data;
        /**
         * The reference to the next node.
         */
        private Node next;

        // CONSTRUCTORS

        /**
         * Creates a new node with a null next field.
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem The data stored
         * @param nodeRef  The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    /**
     * Finds the node at a  position.
     * @param index The position of the node
     * @return The node at index or null if it does not exist
     */
    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i = 0; i < index && node != null; ++i){
            node = node.next;
        }
        return node;
    }

    private Node<E> getGarbage(){
        Node<E> temp = garbage;
        if (size(garbage) <= 1 ){
            garbage = null;
        }
        else {
            garbage = garbage.next;
        }
        return temp;
    }

    private void collectGarbage(Node<E> head){

        head.next = garbage; //TODO: check this
        garbage = head;
    }
    /** Finds the size of a list.
     @param head The head of the current list
     @return The size of the current list
     */
    private int size(Node <E> head) {
        if (head == null)
            return 0;
        else
            return 1 + size(head.next);
    }

    /**
     * Add item to the front of the list
     * @param item The item to be added
     */
    private void addFirst(E item){
        if(size(garbage) > 0){
            Node <E> temp = head;
            head = getGarbage();
            head.next = temp;//TODO: check this
        }
        else {
            head = new Node<>(item, head);
        }
    }

    /**
     * Add a node after given node
     * @param node The node preceding the new item
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item){
        if(node.next == null){
            addLast(node,item);
        }
        if(size(garbage) > 0) {
            Node <E> temp = head.next;
            head.next = getGarbage();
            head.next.next = temp;//TODO: check this
        }
        else {
            node.next = new Node<E>(item, node.next);
        }
    }

    /** Adds a new node to the end of a list.
     @param head The head of the current list
     @param item The data for the new node
     */
    private void addLast(Node <E> head, E item) {
        // If the list has just one element, add to it.
        if (head.next == null)
            if(size(garbage) > 0) {
                Node <E> temp = head.next;
                head.next = getGarbage();
                head.next.next = temp;//TODO: check this
            }
            else {
                head.next = new Node<>(item);
            }
        else
            addLast(head.next, item); // Add to rest of list.
    }

    /** Returns the string representation of a list.
     @param head The head of the current list
     @return The state of the current list
     */
    private String toString(Node <E> head) {
        if (head == null)
            return "";
        else
            return head.data + "\n" + toString(head.next);
    }

    /**
     * Get the data value at index.
     * @param index The position
     * @return The data at index
     */
    public E get(int index){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node <E> node = getNode(index);
        return node.data;
    }

    /**
     * Set the data value at index
     * @param index The position
     * @param item The new value
     */
    public void set(int index, E item){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node <E> node = getNode(index);
        node.data = item;
    }


    /** Wrapper method for finding the size of a list.
     @return The size of the list
     */
    public int size() {
        return size(head);
    }

    /** Wrapper method for returning the string representation of a list.
     @return The string representation of the list
     */
    public String toString() {
        return toString(head);
    }

    /** Wrapper method for adding a new node to the end of a list.
     @param item The data for the new node
     */
    public void addLast(E item) {
        if (head == null) {
            if (size(garbage) > 0) {
                Node<E> temp = head;
                head = getGarbage();
                head.next = temp;
            }
            else {
                head = new Node<>(item); // List has 1 node.
            }
        } else
            addLast(head, item);
    }

    /**
     *
     * @param index
     * @param item
     */
    public void add(int index, E item){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0){
            addFirst(item);
        }
        else {
            Node<E> node = getNode(index);
            addAfter(node,item);
        }
    }

    private void removeFirst(){
        Node<E> temp = head;
        if(head != null){
            head = head.next;
            collectGarbage(temp);
        }
    }

    private void remove(Node<E> head, Node<E> pred){
        if(head != null){
            collectGarbage(head);
            pred.next = head.next;
        }
    }

    /**
     * Wrapper
     * @param index
     */
    public void remove(int index){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if (index == 0){
            removeFirst();
        }
        else {
            remove(getNode(index),getNode(index - 1));
        }
    }


}
//    /** Removes a node from a list.
//     post: The first occurrence of outData is removed.
//     @param head The head of the current list
//     @param pred The predecessor of the list head
//     @param outData The data to be removed
//     @return true if the item is removed
//     and false otherwise
//     */
//    private boolean remove(Node <E> head, Node <E> pred, E outData) {
//        if (head == null) // Base case: empty list.
//            return false;
//        else if (head.data.equals(outData)) { // 2nd base case.
//            pred.next = head.next; // Remove head.
//            return true;
//        }
//        else
//            return remove(head.next, head, outData);
//    }


//    /** Wrapper method for removing a node (in LinkedListRec).
//     @param outData The data to be removed
//     @return true if the item is removed,
//     and false otherwise
//     */
//    public boolean remove(E outData) {
//        if (head == null)
//            return false;
//        else if (head.data.equals(outData)) {
//            head = head.next;
//            return true;
//        }
//        else
//            return remove(head.next, head, outData);
//    }
