package tr.edu.gtu.bkorkmaz.part2;

/**
 * Created by Burak Kağan Korkmaz on 20.04.2017.
 */

import tr.edu.gtu.bkorkmaz.part1.BinaryTree;

import java.util.*;
import java.io.*;

/**
 * Class to represent and build a Huffman tree.
 *
 * @author Koffman and Wolfgang
 */

public class HuffmanTree
        implements Serializable {

    // Nested Classes

    /**
     * A datum in the Huffman tree.
     */
    public static class HuffData
            implements Serializable {
        // Data Fields
        /**
         * The weight or probability assigned to this HuffData.
         */
        private double weight;

        /**
         * The alphabet symbol if this is a leaf.
         */
        private Character symbol;

        public HuffData(double weight, Character symbol) {
            this.weight = weight;
            this.symbol = symbol;
        }

        public Character getSymbol() {
            return symbol;
        }
    }

    // Data Fields
    /**
     * A reference to the completed Huffman tree.
     */
    public BinaryTree<HuffData> huffTree;

    /**
     * A Comparator for Huffman trees; nested class.
     */
    private static class CompareHuffmanTrees
            implements Comparator<BinaryTree<HuffData>> {
        /**
         * Compare two objects.
         *
         * @param treeLeft  The left-hand object
         * @param treeRight The right-hand object
         * @return -1 if left less than right,
         * 0 if left equals right,
         * and +1 if left greater than right
         */
        public int compare(BinaryTree<HuffData> treeLeft,
                           BinaryTree<HuffData> treeRight) {
            double wLeft = treeLeft.getData().weight;
            double wRight = treeRight.getData().weight;
            return Double.compare(wLeft, wRight);
        }
    }

    /**
     * Builds the Huffman tree using the given alphabet and weights.
     * post:  huffTree contains a reference to the Huffman tree.
     *
     * @param symbols An array list of HuffData objects
     */
    public void buildTree(ArrayList<HuffData> symbols) {
        Queue<BinaryTree<HuffData>> theQueue
                = new PriorityQueue<BinaryTree<HuffData>>
                (symbols.size(), new CompareHuffmanTrees());
        // Load the queue with the leaves.
        for (HuffData nextSymbol : symbols) {
            BinaryTree<HuffData> aBinaryTree =
                    new BinaryTree<HuffData>(nextSymbol, null, null);
            theQueue.offer(aBinaryTree);
        }

        // Build the tree.
        while (theQueue.size() > 1) {
            BinaryTree<HuffData> left = theQueue.poll();
            BinaryTree<HuffData> right = theQueue.poll();
            double wl = left.getData().weight;
            double wr = right.getData().weight;
            HuffData sum = new HuffData(wl + wr, null);
            BinaryTree<HuffData> newTree =
                    new BinaryTree<HuffData>(sum, left, right);
            theQueue.offer(newTree);
        }

        // The queue should now contain only one item.
        huffTree = theQueue.poll();
    }

    /**
     * Outputs the resulting code.
     *
     * @param out  A PrintStream to write the output to
     * @param code The code up to this node
     * @param tree The current node in the tree
     */
    private void printCode(PrintStream out, String code,
                           BinaryTree<HuffData> tree) {
        HuffData theData = tree.getData();
        if (theData.symbol != null) {
            if (theData.symbol.equals(" ")) {
                out.println("space: " + code);
            } else {
                out.println(theData.symbol + ": " + code);
            }
        } else {
            printCode(out, code + "0", tree.getLeftSubtree());
            printCode(out, code + "1", tree.getRightSubtree());
        }
    }

    /**
     * Outputs the resulting code.
     *
     * @param out A PrintStream to write the output to
     */
    public void printCode(PrintStream out) {
        printCode(out, "", huffTree);
    }

    /**
     * Method to decode a message that is input as a string of
     * digit characters '0' and '1'.
     *
     * @param codedMessage The input message as a String of
     *                     zeros and ones.
     * @return The decoded message as a String
     */
    public String decode(String codedMessage) {
        StringBuilder result = new StringBuilder();
        BinaryTree<HuffData> currentTree = huffTree;

        for (int i = 0; i < codedMessage.length(); i++) {
            if (codedMessage.charAt(i) == '1') {
                currentTree = currentTree.getRightSubtree();
            } else {
                currentTree = currentTree.getLeftSubtree();
            }
            if (currentTree.isLeaf()) {
                HuffData theData = currentTree.getData();
                result.append(theData.symbol);
                currentTree = huffTree;
            }
        }
        return result.toString();
    }

    public String encode(String message) {
        StringBuilder result = new StringBuilder();
        BinaryTree<HuffData> currentTree = huffTree;
        if (currentTree == null) {
            System.out.println("tree null");
            return null;
        }
        int size = message.length();
        for (int i = 0; i < size; i++) {
            result.append(findCode(message.charAt(i), currentTree));
        }
        return result.toString();
    }

    private String findCode(Character symbol, BinaryTree<HuffData> hTree) {

        String codedMessage;
        StringBuilder result = new StringBuilder();

        if (hTree == null || hTree.getRoot() == null) {
            // put a sign showed ambiguity  if null or end of tree
            return "*";
        }
        if (hTree.getData() != null) {
            if (symbol.equals(hTree.getData().getSymbol())) {
                return "";
            }
        }

        // checks left tree
        codedMessage = findCode(symbol, hTree.getLeftSubtree());
        // if not flagged , append zero to the string
        if ((!Objects.equals(codedMessage, "*"))) {
            result.append("0").append(codedMessage);
            return result.toString();
        }

        // checks right tree
        codedMessage = findCode(symbol, hTree.getRightSubtree());
        // if not flagged , append one to the string
        if (!Objects.equals(codedMessage, "*")) {
            result.append("1").append(codedMessage);
            return result.toString();
        }

        //if Not found, put a flag
        return "*";
    }

}
