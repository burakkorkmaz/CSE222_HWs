package tr.edu.gtu.bkorkmaz.stack_interface;

import java.io.*;

/**
 * Test four different stack by reading from test.csv and writing to
 * testResult_1.csv.
 * <br>Created by Burak Kağan Korkmaz on 22.03.2017.
 */
public class TestStacks {

    public static void main(String[] args) {

        String readFile = "test.csv";
        String writeFile = "testResult_1.csv";

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
                    StackA <Integer> stA = new StackA<>();
                    StackB <Integer> stB = new StackB<>();
                    StackC <Integer> stC = new StackC<>();
                    StackD <Integer> stD = new StackD<>();

                    //Adds element to stack reversely
                    for (int i = size - 1; i >= 0 ; --i) {
                        stA.push(Integer.parseInt(strArr[i]));
                        stB.push(Integer.parseInt(strArr[i]));
                        stC.push(Integer.parseInt(strArr[i]));
                        stD.push(Integer.parseInt(strArr[i]));
                    }

                    stA.push(size);
                    stB.push(size);
                    stC.push(size);
                    stD.push(size);

                    writeToFile(bufferedWriter,stA,size);
                    writeToFile(bufferedWriter,stB,size);
                    writeToFile(bufferedWriter,stC,size);
                    writeToFile(bufferedWriter,stD,size);

                } else if (isFloat(strArr[0])) {
                    //System.out.println("Float");
                    StackA <Float> stA = new StackA<>();
                    StackB <Float> stB = new StackB<>();
                    StackC <Float> stC = new StackC<>();
                    StackD <Float> stD = new StackD<>();

                    //Adds element to stack reversely
                    for (int i = size - 1; i >= 0 ; --i) {
                        stA.push(Float.parseFloat(strArr[i]));
                        stB.push(Float.parseFloat(strArr[i]));
                        stC.push(Float.parseFloat(strArr[i]));
                        stD.push(Float.parseFloat(strArr[i]));
                    }

                    stA.push((float)size);
                    stB.push((float)size);
                    stC.push((float)size);
                    stD.push((float)size);

                    writeToFile(bufferedWriter,stA,size);
                    writeToFile(bufferedWriter,stB,size);
                    writeToFile(bufferedWriter,stC,size);
                    writeToFile(bufferedWriter,stD,size);

                } else if (strArr[0].length() == 1) {
                    //System.out.println("Character");
                    StackA <Character> stA = new StackA<>();
                    StackB <Character> stB = new StackB<>();
                    StackC <Character> stC = new StackC<>();
                    StackD <Character> stD = new StackD<>();

                    //Adds element to stack reversely
                    for (int i = size - 1; i >= 0 ; --i) {
                        stA.push(strArr[i].charAt(0));
                        stB.push(strArr[i].charAt(0));
                        stC.push(strArr[i].charAt(0));
                        stD.push(strArr[i].charAt(0));
                    }

                    stA.push(String.valueOf(size).charAt(0));
                    stB.push(String.valueOf(size).charAt(0));
                    stC.push(String.valueOf(size).charAt(0));
                    stD.push(String.valueOf(size).charAt(0));

                    writeToFile(bufferedWriter,stA,size);
                    writeToFile(bufferedWriter,stB,size);
                    writeToFile(bufferedWriter,stC,size);
                    writeToFile(bufferedWriter,stD,size);
                }else {
                    //System.out.println("String");
                    StackA <String> stA = new StackA<>();
                    StackB <String> stB = new StackB<>();
                    StackC <String> stC = new StackC<>();
                    StackD <String> stD = new StackD<>();

                    //Adds element to stack reversely
                    for (int i = size - 1; i >= 0 ; --i) {
                        stA.push(strArr[i]);
                        stB.push(strArr[i]);
                        stC.push(strArr[i]);
                        stD.push(strArr[i]);
                    }

                    stA.push(String.valueOf(size));
                    stB.push(String.valueOf(size));
                    stC.push(String.valueOf(size));
                    stD.push(String.valueOf(size));

                    writeToFile(bufferedWriter,stA,size);
                    writeToFile(bufferedWriter,stB,size);
                    writeToFile(bufferedWriter,stC,size);
                    writeToFile(bufferedWriter,stD,size);
                }

            }
            bufferedWriter.close();
            bufferedReader.close();
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

    private static void writeToFile(BufferedWriter bW, StackInterface obj,
                                    int size) throws IOException {
        for (int i = 0; i < size ; i++) {

            bW.write(String.valueOf(obj.pop()));
            bW.write(",");
        }

        bW.write(String.valueOf(obj.pop()));
        bW.write("\n");

    }

}
