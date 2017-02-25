/**
 * Created by eksor on 24.02.2017.
 */

import java.io.*;
import java.util.ArrayList;

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
     * The numver of Book class attributes ->
     * ISBN, Name, Year, Author, Borrower, Borrow Date
     */
    private static final int BOOK_ATTRIBUTES = 6;

    private ArrayList<Person> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public Database(){
        readUserFile("users.csv");
        readBookFile("books.csv");

    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Person> getUsers() {
        return users;
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
                Person person = new Person(token[0], token[1], token[2], token[3], token[4]);
                users.add(person);

            }
            for (Person p : users)
                System.out.println(p.toString());
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
     *
     * @param filename
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
                Book book = new Book(token[0], token[1], token[2], token[3], token[4], token[5]);
                books.add(book);

            }
            for (Book b : books)
                System.out.println(b.toString());
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
     *
     *
     * @param filename
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
            System.out.println("User Records added to CSV file.\n");
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


    public void writeBookFile(String filename) {
        FileWriter stream = null;
        try {

            stream = new FileWriter(filename);
            for (Book b : books) {
                stream.append(b.getISBN());
                stream.append(DELIMITER);
                stream.append(b.getName());
                stream.append(DELIMITER);
                stream.append(b.getYear());
                stream.append(DELIMITER);
                stream.append(b.getAuthor());
                stream.append(DELIMITER);
                stream.append(b.getBorrower());
                stream.append(DELIMITER);
                stream.append(b.getBorrowDate());
                stream.append(SEPARATOR);

            }
            System.out.println("Book Records added to CSV file.\n");
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
     * @param name
     * @param pass
     * @return
     */
    public String login(String name, String pass) {
        for(Person p : users){
            if(p.getName() == name && p.getPassword() == pass){
                return p.getID();
            }
        }
        return null;
    }
}
