package tr.edu.gtu.bkorkmaz.family_tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        BufferedReader stream = null;
        String line;

        try {
            //reading all integers from test.txt file
            stream = new BufferedReader(new FileReader("test.txt"));
            line = stream.readLine();
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(", ");

                /// something



            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
