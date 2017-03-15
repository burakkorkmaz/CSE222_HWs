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
        for(int i = 0; i < index && node != null; ++i) {
            if (node.next == null){
                return null;
            }
            node = node.next;
        }
        return node;
    }

    /**
     * Gets garbage node
     * @return node
     */
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

    /**
     * use Garbage
     * @param node
     * @param item
     * @return
     */
    private boolean useGarbage(Node <E> node, E item){
        if(size(garbage) > 0){
            Node <E> temp = node;
            node = getGarbage();
            node.data = item;
            node.next = temp;
            return true;
        }
        return false;
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
        if(!useGarbage(head, item)){
            head = new Node<>(item, head);
        }
    }

    /**
     * Add a node after given node
     * @param node The node preceding the new item
     * @param item The item to insert
     */
    private void addAfter(Node<E> node, E item){

        if(node != null && node.next == null){
            addLast(node,item);
        }
        else if(!useGarbage(node.next, item)) {
            if(node == null){
                node = new Node<E>(item);
            }
            else {
                node.next = new Node<E>(item, node.next);
            }
        }
    }

    /** Adds a new node to the end of a list.
     @param head The head of the current list
     @param item The data for the new node
     */
    private void addLast(Node <E> head, E item) {
        //empty list
        if(head == null){
            if(!useGarbage(head,item)){
                head = new Node<E>(item);
            }
        }
        // If the list has just one element, add to it.
        if (head.next == null) {
            if (!useGarbage(head.next, item)){
                head.next = new Node<>(item);
            }
        }
        else {
            addLast(head.next, item); // Add to rest of list.
        }
    }

    /**
     * Remove first element
     */
    private void removeFirst(){
        Node<E> temp = head;
        if(head != null){
            head = head.next;
            collectGarbage(temp);
        }
    }

    /**
     *
     * @param head List head
     * @param pred Predecessor node of given node
     */
    private void remove(Node<E> head, Node<E> pred){
        if(head != null){
            collectGarbage(head);
            pred.next = head.next;
        }
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


    public SingleLinkedList(){
        head = null;
        garbage = null;
    }


    public SingleLinkedList(E item){
        head = null;
        garbage = null;
        addFirst(item);
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

    /** Wrapper method for adding a new node to the end of a list.
     @param item The data for the new node
     */
    public void addLast(E item) {
        if (head == null) {
            if (!useGarbage(head,item)){
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
        int size = size();
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0){
            addFirst(item);
        }
        else if(index == size){
            addLast(item);
        }
        else {
            Node<E> node = getNode(index);
            addAfter(node,item);
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


    /**
     * Show data in reverse
     * @return reversed string
     */
    public String reverseToString(){
        String result = "";
        int index = size() - 1;
        return reverseToString(index);
    }

    /**
     * Wrapper method for reverseToString
     * @param index Position
     * @return Final reversed string
     */
    private String reverseToString(int index){
        if(index == 0){
            return  get(0).toString();
        }


        return get(index).toString() + " " + reverseToString(index - 1);

    }

    /** Wrapper method for returning the string representation of a list.
     @return The string representation of the list
     */
    public String toString() {
        return toString(head);
    }


}