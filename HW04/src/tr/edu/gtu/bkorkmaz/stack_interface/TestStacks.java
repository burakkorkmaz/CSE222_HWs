package tr.edu.gtu.bkorkmaz.stack_interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Burak Kağan Korkmaz on 22.03.2017.
 */
public class TestStacks {

    public static void main(String [] args) {

        String fileName = "test.csv";


        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.exit(1);
            String line = bufferedReader.readLine();
            String [] strArr = line.split(",");

            System.out.println(strArr.length);


            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
