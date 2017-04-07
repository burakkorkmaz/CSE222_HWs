package tr.edu.gtu.bkorkmaz.traverse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Reads integers from test.txt and adds tree to test the Binary tree
 * Created by Burak Kağan Korkmaz on 06.04.2017.
 */
public class TestBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();

        BufferedReader stream = null;
        String line;

        try {
            //reading all integers from test.txt file
            stream = new BufferedReader(new FileReader("test.txt"));
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(" ");
                for (int i = 0; i < token.length; i++) {
                    BST.insert(Integer.parseInt(token[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Tree Size: " + BST.getSizeOfTree());
        Iterator<Integer> it = BST.levelOrderIterator();
        System.out.println("-Level Order-");
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println("--end--");


    }
}
