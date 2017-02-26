import java.util.ArrayList;

/**
 * Created by eksor on 24.02.2017.
 */
public class Staff extends Person {

    public Staff(String ID, String name, String surname, String username, String password) {
        super(ID, name, surname, username, password);
    }

    public boolean addBook(String ID, String name, String year, String author) {
        ArrayList<Book> bk = getDb().getBooks();

        System.out.println("\nAdding book in progress...");
        for (int i = 0; i < bk.size(); ++i) {
            if (bk.get(i).getID().equals(ID)) {
                System.err.println("Book ID can not be same during adding book!");
                return false;
            }
        }
        Book b = new Book(ID, name, year, author, "-");
        bk.add(b);
        System.out.println("The book has been added successfully.");
        return true;
    }

    public boolean removeBook(String ID) {
        ArrayList<Book> bk = getDb().getBooks();
        System.out.println("\nRemoving book in progress...");
        boolean found = false;
        int bookIndex = -1;
        for (int i = 0; i < bk.size() && !found; ++i) {
            if (bk.get(i).getID().equals(ID)) {
                bookIndex = i;
                found = true;
                if (!bk.get(i).getBorrower().equals("-")) {
                    System.err.println("The book can not remove if borrowed!");
                    return false;
                }
            }
        }
        bk.remove(bookIndex);
        return true;
    }

    public boolean registerUser(String userID, String name, String surName, String userName, String password) {

        final int MIN_CHAR = 3;

        ArrayList<Person> usr = getDb().getUsers();

        System.out.println("Registering User in progress...");

        // User ID can be "uX" for normal users or be "sX" for staff !
        if (userID.indexOf("u") != 0 || userID.indexOf("s") != 0) {
            System.err.println("Register ID is inappropriate for user of staff");
            return false;
        }

        if(userName.length() < MIN_CHAR || password.length() < MIN_CHAR){
            System.err.println("Username and password must be at least three digits!");
            return false;
        }

        System.out.println("\nRegistering User in progress...");
        for (int i = 0; i < usr.size(); ++i) {
            if (usr.get(i).getID().equals(userID) || usr.get(i).getUsername().equals(userName)) {
                System.err.println("User ID or username must be unique for a new user.");
                return false;
            }
        }

        Person pr = new Person(userID,name,surName,userName,password);
        usr.add(pr);
        return true;
    }

    public boolean removeUser(String username){

        int indexUser = -1;
        boolean found = false;
        ArrayList<Person> usr = getDb().getUsers();

        for (int i = 0; i < usr.size() && !found; ++i){
            if(usr.get(i).getUsername().equals(username)) {
                indexUser = i;
                found = true;
            }
        }

        usr.remove(indexUser);
        System.out.println("User was removed successfully.");
        return true;
    }
}
