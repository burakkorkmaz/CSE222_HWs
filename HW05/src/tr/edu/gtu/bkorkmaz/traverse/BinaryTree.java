package tr.edu.gtu.bkorkmaz.traverse;

/**
 * CLASS BinaryTree DERS KITABINDAN ALINMISTIR!
 * Created by Burak Kağan Korkmaz on 04.04.2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Class for a binary tree that stores type E objects.
 *
 * @author Koffman and Wolfgang
 */

public class BinaryTree <E>
        implements Serializable, Iterable {
    /**
     * Class to encapsulate a tree node.
     */
    protected static class Node<E>
            implements Serializable {
        // Data Fields
        /**
         * The information stored in this node.
         */
        protected E data;

        /**
         * Reference to the left child.
         */
        protected Node<E> left;

        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        /**
         * Reference to the parent.
         */
        protected Node<E> parent;

        /**
         * Reference to the flag.
         */
        protected int flag;


        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
            parent = null;
            flag = 0;
        }

        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        private Node(E data, Node<E> newParent) {
            this.data = data;
            left = null;
            right = null;
            parent = newParent;
            flag = 0;
        }

        /**
         * Construct a node with given Node
         *
         * @param node
         */
        public Node(Node<E> node) {
            this.data = node.data;
            left = node.left;
            right = node.right;
            parent = null;
            flag = 0;
        }

        public Node() {
            this.data = null;
            left = null;
            right = null;
            parent = null;
            flag = 0;
        }

        // Methods

        /**
         * Return a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }

        public E getData() {
            return data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag){
            this.flag = flag;
        }
    }

    // Data Field
    /**
     * The root of the binary tree
     */
    protected Node<E> root;

    protected int sizeOfTree = 0;

    private Queue<Node<E>> levelOrder;

    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
                      BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or
     * null if either the root or the
     * right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data field of the root
     *
     * @return the data field of the root
     * or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }



    protected void setNodeData(Node<E> node, Node<E> left, Node<E> right,
                        Node<E> parent) {
        node.left = left;
        node.right = right;
        node.parent = parent;
        node.flag = 0;
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /**
     * Count number of the nodes at the Binary tree
     *
     * @return Number of nodes
     */
    public int getSizeOfTree() {

        sizeOfTree = getSize(root);
        return sizeOfTree;
    }

    private int getSize(Node<E> root){
        if(root == null){
            return 0;
        }
        else {
            return 1 + getSize(root.left) + getSize(root.right);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     *
     * @param node  The local root
     * @param depth The depth
     * @param sb    The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
                                  StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /**
     * Creates level Order traversal tree and insert a queue
     *
     * @param root
     */
    private void levelOrderTraverse(Node<E> root){
        Queue<Node<E>> queue = new LinkedList<>();
        levelOrder= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> temp = queue.poll();
            levelOrder.offer(temp);
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    /**
     * Method to read a binary tree.
     * pre: The input consists of a preorder traversal
     * of the binary tree. The line "null" indicates a null tree.
     *
     * @param bR The input file
     * @return The binary tree
     * @throws IOException If there is an input error
     */
    public static BinaryTree<String>
    readBinaryTree(BufferedReader bR) throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(bR);
            BinaryTree<String> rightTree = readBinaryTree(bR);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

    /**
     * adds integer value to the tree
     * @param value
     */
    public void insert(Integer value) {
        if (root == null) {
            ++sizeOfTree;
            root = new Node<>((E)value);
        } else
            insert(root, value);
    }

    private void insert(Node node, Integer value) {

        if (value < (Integer) node.data) {
            if (node.left == null) {
                node.left = new Node<>(value, node);
                ++sizeOfTree;
            } else
                insert(node.left, value);
        }else if (value == node.data){

            /* intentionally left blank */
        }
        else {
            if (node.right == null) {
                node.right = new Node<>(value, node);
                ++sizeOfTree;
            } else
                insert(node.right, value);
        }
    }


    public Iterator<E> iterator() {
        return new TreeIterator<>();
    }

    public Iterator<E> levelOrderIter(){
        return new levelOrderIterator<>();
    }

    /**
     * Iterator class to traverse pre-order at the binary tree
     *
     * @param <E> Generic type of a node data
     */
    private class TreeIterator<E> implements Iterator<E> {

        private Queue<Node<E>> nodeQueue;
        private Node<E> nextNode;
        private int countNext = 0;

        @SuppressWarnings("unchecked")
        private TreeIterator() {
            if(root != null) {
                nodeQueue = new LinkedList<>();
                Node<E> temp = new Node<E>((Node<E>) root);
                Node<E> temp2 = new Node<E>();
                temp2.left = (Node<E>)root;
                nextNode = temp2;

                while (temp != null) {
                    nodeQueue.offer(temp);
                    temp = temp.left;
                }
            }


        }

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext() {
            return countNext != sizeOfTree;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public E next() {

            if (!hasNext()) {
                return null;
                //throw new NoSuchElementException();
            }

            if (nextNode == null) {
                return null;
                // throw new NoSuchElementException();
            }

            nextNode.flag = 1;

            if (nextNode.left != null && nextNode.left.flag == 0) {
                nextNode = nextNode.left;
            } else if (nextNode.right != null && nextNode.right.flag == 0) {
                nextNode = nextNode.right;
            } else {
                nextNode = nextNode.parent;
                return next();
            }

            ++countNext;
            return nextNode.data;

        }


    }

    /**
     * Iterator class to traverse level-order at the binary tree
     *
     * @param <E> Generic type of a node data
     */
    private class levelOrderIterator<E> implements Iterator<E> {

        public levelOrderIterator(){
            levelOrderTraverse(root);
        }

        @Override
        public boolean hasNext() {
            return !levelOrder.isEmpty();
        }

        @Override
        public E next() {
            if(hasNext()) {
                Node<E> temp = (Node<E>) levelOrder.poll();
                return temp.data;
            }
            return null;
        }
    }

}