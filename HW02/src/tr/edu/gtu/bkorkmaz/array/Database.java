package tr.edu.gtu.bkorkmaz.array;

import java.io.*;

/**
 *  The Database Class holds all Library information. Reads and Writes CSV files and use Array List to manage datas.
 *  This class has readUserFile, readBookFile, writeUserFile, writeBookFile, login and getBook, getUsers methods.
 * <p>_Created by Burak Kağan Korkmaz on 24.02.2017.</p>
 */
public class Database implements ManagementSystem {

    /**
     * Comma/Semicolon Delimiter for CSV files
     */
    private static final String DELIMITER = ";";
    /**
     * New line Separator for CSV files
     */
    private static final String SEPARATOR = "\n";

    /**
     * The Number of Person Class Attributes ->
     * ID, Name, Surname, Username, Password
     */
    private static final int PERSON_ATTRIBUTES = 5;
    /**
     * The number of Book class attributes ->
     * ID, Name, Year, Author, Borrower
     */
    private static final int BOOK_ATTRIBUTES = 5;

    private static final int ATT_FIRST_IDX = 0;
    private static final int ATT_SECOND_IDX = 1;
    private static final int ATT_THIRD_IDX = 2;
    private static final int ATT_FOURTH_IDX = 3;
    private static final int ATT_FIFTH_IDX = 4;

    /**
     * Users Array
     */
    private Person [] users;
    /**
     * Books Array
     */
    private Book [] books;

    private int userSize;
    private int bookSize;

    /**
     * Constructor
     * Reads CSV files
     */
    public Database(){
        readUserFile("users.csv");
        readBookFile("books.csv");

    }



    /**
     * Gets books array.
     * @return Book array
     */
    public Book [] getBooks() {
        return books;
    }

    /**
     * Gets users array.
     * @return Person array
     */
    public Person [] getUsers() {
        return users;
    }

    public void add(){

    }

    public void showUsers(){
        System.out.println("USERS DATABASE");
        for (Person p : users)
            System.out.println(p.toString());
    }

    public void showBooks(){
        System.out.println("BOOKS DATABASE");
        for (Book b : books)
            System.out.println(b.toString());
    }

    public void showBookIDs(){

        for (Book b : books){
            System.out.println("Book id: "+ b.getID()+ " Name: " + b.getName());
        }
    }

    /**
     * Reads from user file and adds read records to Array List .
     * @param filename The name of csv file to read
     */
    public void readUserFile(String filename) {
        String line;
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new FileReader(filename));
            while(stream.readLine() != null){
                ++userSize;
            }
            stream.close();
            stream = new BufferedReader(new FileReader(filename));
            users = new Person[userSize];
            int arrayIndex = 0;
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(DELIMITER, PERSON_ATTRIBUTES);
                for (int i = 0; i < PERSON_ATTRIBUTES; ++i) {
                    if (token[i].contains(";"))
                        throw new Error("Wrong Entry detected! Please do not use semicolon in the entries.");
                }


                if(token[ATT_FIRST_IDX].startsWith("s"))
                    users[arrayIndex] = new Staff(token[ATT_FIRST_IDX], token[ATT_SECOND_IDX], token[ATT_THIRD_IDX],
                            token[ATT_FOURTH_IDX], token[ATT_FIFTH_IDX]);
                else users[arrayIndex] = new User(token[ATT_FIRST_IDX], token[ATT_SECOND_IDX], token[ATT_THIRD_IDX],
                        token[ATT_FOURTH_IDX], token[ATT_FIFTH_IDX]);


//
//                users[arrayIndex]..setID(token[ATT_FIRST_IDX]);
//                users[arrayIndex].setName(token[ATT_SECOND_IDX]);
//                users[arrayIndex].setSurname(token[ATT_THIRD_IDX]);
//                users[arrayIndex].setUsername(token[ATT_FOURTH_IDX]);
//                users[arrayIndex].setPassword(token[ATT_FIFTH_IDX]);
//
                ++arrayIndex;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            }catch (Exception e){
                System.err.println("readUserFile Close error!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Reads from books file and adds read records to Array.
     * @param filename The name of csv file to read
     */
    public void readBookFile(String filename) {
        String line;
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new FileReader(filename));
            while(stream.readLine() != null){
                ++bookSize;
            }
            stream.close();
            stream = new BufferedReader(new FileReader(filename));
            books = new Book[bookSize];
            int bookIndex = 0;
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(DELIMITER, BOOK_ATTRIBUTES);
                for (int i = 0; i < BOOK_ATTRIBUTES; ++i) {
                    if (token[i].contains(";"))
                        throw new Error("Wrong Entry detected! Please do not use semicolon in the entries.");
                }
                books[bookIndex] = new Book(token[ATT_FIRST_IDX], token[ATT_SECOND_IDX], token[ATT_THIRD_IDX],
                        token[ATT_FOURTH_IDX], token[ATT_FIFTH_IDX]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            }catch (Exception e){
                System.err.println("readBookFile Close error");
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes to users file from Array
     *
     * @param filename The name of csv file
     */
    public void writeUserFile(String filename) {
        FileWriter stream = null;
        try {

            stream = new FileWriter(filename);
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
                stream.append(SEPARATOR);
            }
            System.out.println("User Records added to CSV file Successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }catch (Exception e){
                System.err.println("writeUserFile Close error");
                e.printStackTrace();
            }

        }
    }

    /**
     * Writes to books file from Array
     * @param filename The name of csv file
     */
    public void writeBookFile(String filename) {
        FileWriter stream = null;
        try {

            stream = new FileWriter(filename);
            for (Book b : books) {
                stream.append(b.getID());
                stream.append(DELIMITER);
                stream.append(b.getName());
                stream.append(DELIMITER);
                stream.append(b.getYear());
                stream.append(DELIMITER);
                stream.append(b.getAuthor());
                stream.append(DELIMITER);
                stream.append(b.getBorrower());
                stream.append(SEPARATOR);

            }
            System.out.println("\nBook Records added to CSV file Successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }catch (Exception e){
                System.err.println("writeBookFile Close error");
                e.printStackTrace();
            }

        }
    }

    /**
     * @param name Username
     * @param pass Password
     * @return True if logins<br> False, otherwise
     */
    public Person login(String name, String pass) {
        for(Person p : users){
            if(p.getUsername().equals(name) && p.getPassword().equals(pass)){
                return p;
            }
        }
        return null;
    }
}
