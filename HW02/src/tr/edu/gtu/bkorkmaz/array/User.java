package tr.edu.gtu.bkorkmaz.array;

import java.util.ArrayList;

/**
 * This class derived from Person class.  The class has borrowBook, returnBook methods
 * <br>Provides borrowing a book from library or return a book to library for users
 * <p>Created by Burak Kağan Korkmaz on 23.02.2017.</p>
 */
public class User extends Person {

    /**
     * CONSTRUCTOR
     * @param ID User id
     * @param name User First Name
     * @param surname User Last Name
     * @param username Username
     * @param password User Password
     */
    public User(String ID, String name, String surname, String username, String password) {
        super(ID, name, surname, username, password);
    }

    /**
     * Gets the book user wanted from library.
     * @param bookName Name of the Book in library
     * @return True if succeed<br> False,  otherwise
     */
    public boolean borrowBook(String bookName) {

        int bookIndex = -1;
        int userIndex = -1;
        Person [] pr = getDb().getUsers();
        Book [] bk = getDb().getBooks();

        System.out.println("Borrowing the Book in progress...\n");
        for (int i = 0; i < bk.length; ++i) {
            if (bk[i].getName().equals(bookName)) {
                bookIndex = i;
            }
        }
        if (bookIndex == -1){
            System.err.println("The book could not found in database");
            return false;
        }
        else {
            boolean found = false;
            for (int i = 0; i < pr.length && !found; ++i) {
                if (pr[i].getID().equals(this.getID())) {
                    userIndex = i;
                    found = true;
                }
            }
            if (userIndex == -1){
                System.err.println("User could not Found in database");
                return false;
            }
            else{
                if(bk[bookIndex].getBorrower().equals("-"))
                    bk[bookIndex].setBorrower(pr[userIndex].getUsername());

                else if(bk[bookIndex].getBorrower().equals(this.getUsername())) {
                    System.err.println("You have already borrowed the book.");
                    return false;
                }
                else{
                    System.err.println("The book has been borrowed earlier by another user.");
                    return false;
                }

            }

        }
        System.out.println("The book has been borrowed successfully.\n");
        return true;
    }

    /**
     * Gives the book to the library.
     * @param bookName Name of the Book in library
     * @return True if succeed<br> False,  otherwise
     */
    public boolean returnBook(String bookName) {

        int bookIndex = -1;
        int userIndex = -1;
        Person [] pr = getDb().getUsers();
        Book [] bk = getDb().getBooks();

        System.out.println("Returning the Book in progress...");
        for (int i = 0; i < bk.length; ++i) {
            if (bk[i].getName().equals(bookName)) {
                bookIndex = i;
            }
        }
        if (bookIndex == -1){
            System.err.println("The book could not found in database");
            return false;
        }
        else {

            boolean found = false;
            for (int i = 0; i < pr.length && !found; ++i) {
                if (pr[i].getID().equals(this.getID())) {
                    userIndex = i;
                    found = true;
                }
            }
            if (userIndex == -1){
                System.err.println("User could not Found in database");
                return false;
            }
            else{
                if(bk[bookIndex].getBorrower().equals(this.getUsername()))
                    bk[bookIndex].setBorrower("-");
                else if (bk[bookIndex].getBorrower().equals("-")){
                    System.err.println("The book has already been returned to the library.");
                    return false;
                }
                else{
                    System.err.println("The book has borrowed by another user.");
                    return false;
                }
            }

        }
        System.out.println("The book has returned to library successfully");
        return true;
    }
}
