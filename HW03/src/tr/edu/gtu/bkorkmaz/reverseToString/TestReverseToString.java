package tr.edu.gtu.bkorkmaz.reverseToString;

import tr.edu.gtu.bkorkmaz.singleLinkedList.SingleLinkedList;

/**
 * Testing reverseToString
 *
 * Created by Burak Kağan Korkmaz on 15.03.2017.
 */
public class TestReverseToString {

    public static void main(String [] args){

        SingleLinkedList <String> str = new SingleLinkedList<String>("Hello");

        str.addLast("World");
        str.addLast("!");

        System.out.println(str.reverseToString());
    }
}