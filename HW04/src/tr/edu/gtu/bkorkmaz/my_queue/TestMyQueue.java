package tr.edu.gtu.bkorkmaz.my_queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Burak Kağan Korkmaz on 24.03.2017.
 */
public class TestMyQueue {

    public static void main(String [] args){

        String readFile = "test.csv";
        String writeFile = "testResult_2.csv";

        try {
            FileReader fileReader = new FileReader(readFile);
            FileWriter fileWriter = new FileWriter(writeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] strArr = line.split(",");
                int size = strArr.length;

                //check Type of elements at line
                if (isInteger(strArr[0])) {
                    //System.out.println("Integer");
                    MyQueue<Integer> myQ = new MyQueue<>();
                    Queue<Integer> theQ = new LinkedList<>();


                    //Adds element to stack reversely
                    for (int i = 0; i < size ; ++i) {
                        myQ.add(Integer.parseInt(strArr[i]));
                        theQ.offer(Integer.parseInt(strArr[i]));
                    }

                    myQ.reverse();
                    myQ.reverseQueue(theQ);

                    writeMyQueueToFile(bufferedWriter, myQ, size);
                    writeQueueToFile(bufferedWriter, theQ, size);
                }
                else if (isFloat(strArr[0])) {
                    //System.out.println("Float");
                    MyQueue<Float> myQ = new MyQueue<>();
                    Queue<Float> theQ = new LinkedList<>();

                    //Adds element to stack reversely
                    for (int i = 0; i < size ; ++i) {
                        myQ.add(Float.parseFloat(strArr[i]));
                        theQ.offer(Float.parseFloat(strArr[i]));
                    }

                    myQ.reverse();
                    myQ.reverseQueue(theQ);

                    writeMyQueueToFile(bufferedWriter, myQ, size);
                    writeQueueToFile(bufferedWriter, theQ, size);
                } else if (strArr[0].length() == 1) {
                    //System.out.println("Character");
                    MyQueue<Character> myQ = new MyQueue<>();
                    Queue<Character> theQ = new LinkedList<>();

                    //Adds element to stack reversely
                    for (int i = 0; i < size ; ++i) {
                        myQ.add(strArr[i].charAt(0));
                        theQ.offer(strArr[i].charAt(0));
                    }

                    myQ.reverse();
                    myQ.reverseQueue(theQ);

                    writeMyQueueToFile(bufferedWriter, myQ, size);
                    writeQueueToFile(bufferedWriter, theQ, size);
                }
                else {
                    MyQueue<String> myQ = new MyQueue<>();
                    Queue<String> theQ = new LinkedList<>();


                    //Adds element to stack reversely
                    for (int i = 0; i < size ; ++i) {
                        myQ.add(strArr[i]);
                        theQ.offer(strArr[i]);
                    }

                    myQ.reverse();
                    myQ.reverseQueue(theQ);

                    writeMyQueueToFile(bufferedWriter, myQ, size);
                    writeQueueToFile(bufferedWriter, theQ, size);

                }
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void writeMyQueueToFile(BufferedWriter bW, MyQueue obj,
    int size) throws IOException {

        int counter = 1;
        while (!obj.isEmpty()) {

            if (counter == size) {
                bW.write(String.valueOf(obj.remove(0)));
                bW.write("\n");
            }
            else {
                bW.write(String.valueOf(obj.remove(0)));
                bW.write(",");
            }
            ++counter;
        }
    }

    private static void writeQueueToFile(BufferedWriter bW, Queue obj,
                                           int size) throws IOException {
        int counter = 1;
        while (!obj.isEmpty()) {

            if (counter == size) {
                bW.write(String.valueOf(obj.poll()));
                bW.write("\n");
            }
            else {
                bW.write(String.valueOf(obj.poll()));
                bW.write(",");
            }
            ++counter;
        }

    }
}
