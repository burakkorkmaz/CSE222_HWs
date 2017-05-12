package tr.edu.gtu.bkorkmaz.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestHuffmanTree {

    public static void main(String[] args) {
        FileReader fileReader;
        ArrayList<HuffmanTree.HuffData> hd = new ArrayList<>();


        try {
            String line;
            fileReader = new FileReader("freq.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] separated = line.split(" ");
                hd.add(new HuffmanTree.HuffData(Integer.parseInt(separated[1]),
                        separated[0].charAt(0)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (hd.size() == 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Content could not Found in freq.txt");
                e.printStackTrace();
            }
        }

        HuffmanTree ht = new HuffmanTree();

        ht.buildTree(hd);


        System.out.println("_Content of Huffman Tree_");
        ht.printCode(System.out);
        System.out.println("-----------");


        System.out.println("Testing...");
        //if it encounter a invalid value, prints '*' there
        String message = "abcde";
        String codedMessage;
        System.out.printf("Encoding %s -> %s\n", message,
                codedMessage = ht.encode(message));

        /* if it encounter a invalid value, prints the closest character
         * instead of invalid value (Default)
         */
        System.out.printf("Decoding %s -> %s\n", codedMessage,
                ht.decode(codedMessage));

        System.out.println("\nTesting with Invalid Entry:");
        message = "#%£$&";
        System.out.printf("Encoding %s -> %s\n", message,
                codedMessage = ht.encode(message));
        System.out.printf("Decoding %s -> %s\n", codedMessage,
                ht.decode(codedMessage));

    }
}
