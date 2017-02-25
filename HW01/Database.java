/**
 * Created by eksor on 24.02.2017.
 */

import java.io.*;
import java.util.ArrayList;

public class Database implements ManagementSystem {

    //Delimiter for CSV files
    private static final String DELIMITER = ";";
    //Seperator for CSV files
    private static final String SEPERATOR = "\n";

    private static final int PERSON_ATTRIBUTES = 5;
    private static final int BOOK_ATTRIBUTES = 6;

    private ArrayList<Person> users = new ArrayList<>();

    private String fileName;

    Database(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads from CSV file and adds read records to Array List .
     */
    public void readFile() {
        String line;
        BufferedReader stream;
        try {
            stream = new BufferedReader(new FileReader(fileName));
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(DELIMITER, PERSON_ATTRIBUTES);
                for (int i = 0; i < PERSON_ATTRIBUTES; ++i) {
                    if (token[i].contains(","))
                        throw new Error("Wrong Entry detected! Please do not use comma in the entries.");
                }
                Person person = new Person(token[0], token[1], token[2], token[3], token[4]);
                users.add(person);

            }
            for (Person p : users)
                System.out.println(p.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *
     */
    public void writeFile() {
        FileWriter stream = null;
        try {

            stream = new FileWriter(fileName);
            for (Person p : users) {
                stream.append(p.getID());
                stream.append(DELIMITER);
                stream.append(p.getName());
                stream.append(DELIMITER);
                stream.append(p.getSurname());
                stream.append(DELIMITER);


                stream.append(p.getUsername());
                stream.append(DELIMITER);
                stream.append(p.getPassword());
                stream.append(SEPERATOR);



            }
            System.out.println("Records added to CSV file.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }catch (Exception e){
                System.err.println("File Close error");
                e.printStackTrace();
            }

        }
    }

    /**
     * @param name
     * @param pass
     * @return
     */
    public String login(String name, String pass) {
        return null;
    }
}
