package tr.edu.gtu.bkorkmaz.arraylist;

import java.io.*;
import java.util.ArrayList;

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

    /**
     * Users Array List
     */
    private ArrayList<Person> users = new ArrayList<>();
    /**
     * Books Array List
     */
    private ArrayList<Book> books = new ArrayList<>();

    /**
     * Constructor
     * Reads CSV files
     */
    public Database(){
        readUserFile("users.csv");
        readBookFile("books.csv");

    }

    /**
     * gets books array list.
     * @return array list
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * gets users array list.
     * @return array list
     */
    public ArrayList<Person> getUsers() {
        return users;
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

        for (int i= 0; i < getBooks().size();++i){
            System.out.println("Book id: "+ getBooks().get(i).getID()+ " Name: " + getBooks().get(i).getName());
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
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(DELIMITER, PERSON_ATTRIBUTES);
                for (int i = 0; i < PERSON_ATTRIBUTES; ++i) {
                    if (token[i].contains(";"))
                        throw new Error("Wrong Entry detected! Please do not use semicolon in the entries.");
                }

                Person person;
                if(token[0].startsWith("s"))
                    person = new Staff(token[0], token[1], token[2], token[3], token[4]);
                else person = new User(token[0], token[1], token[2], token[3], token[4]);

                users.add(person);
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
     * Reads from books file and adds read records to Array List .
     * @param filename The name of csv file to read
     */
    public void readBookFile(String filename) {
        String line;
        BufferedReader stream = null;
        try {
            stream = new BufferedReader(new FileReader(filename));
            while ((line = stream.readLine()) != null) {
                String token[] = line.split(DELIMITER, BOOK_ATTRIBUTES);
                for (int i = 0; i < BOOK_ATTRIBUTES; ++i) {
                    if (token[i].contains(";"))
                        throw new Error("Wrong Entry detected! Please do not use semicolon in the entries.");
                }
                Book book = new Book(token[0], token[1], token[2], token[3], token[4]);
                books.add(book);

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
     * Writes to users file from Array List
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
     * Writes to books file from Array List
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
