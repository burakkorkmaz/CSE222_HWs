/**
 * Created by eksor on 24.02.2017.
 */

import java.io.*;
import java.util.ArrayList;

public class Database implements ManagementSystem{

    //Delimiter for CSV files
    private static final String DELIMITER = ",";
    //Seperator for CSV files
    private static final String SEPERATOR = "\n";

    private static final int PERSON_ATTRIBUTES = 5;
    private static final int BOOK_ATTRIBUTES = 6;

    private ArrayList<Person> arrayList;

    /**
     * @param filename
     */
    public void readFile(String filename) {
        String line;
        BufferedReader stream;
        try {
            stream = new BufferedReader(new FileReader(filename));
        while ((line = stream.readLine()) != ""){
            String token[] = line.split(DELIMITER,PERSON_ATTRIBUTES);
            for(int i = 0; i < PERSON_ATTRIBUTES; ++i){
                if(token[i].contains(","))
                    throw new Error("Wrong Entry detected! Please do not use comma in the entries.");
            }
            Person person = new Person(token[0],token[1],token[2],token[3],token[4]);
            arrayList.add(person);
        }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param filename
     */
    public void writeFile(String filename) {
        FileWriter stream;
        ;
    }

    /**
     *
     * @param name
     * @param pass
     * @return
     */
    public String login(String name, String pass) {
        return null;
    }
}
