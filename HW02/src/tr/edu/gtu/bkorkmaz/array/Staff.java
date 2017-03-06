package tr.edu.gtu.bkorkmaz.array;

/**
 * This class derived from Person class.  The class has addBook, removeBook, registerUser, removeUser methods
 * Provides doing personnel works like adding a new book to library, remove a book from library,
 * registering a new user or  removing a user from database.
 * <br>_Created by Burak Kağan Korkmaz on 24.02.2017.
 */
public class Staff extends Person {
    /**
     * CONSTRUCTOR
     * @param ID staff id
     * @param name Person First Name
     * @param surname Person Last Name
     * @param username Staff username
     * @param password Staff password
     */
    public Staff(String ID, String name, String surname, String username, String password) {
        super(ID, name, surname, username, password);
    }

    /**
     * Adds a new book to the library.
     * @param ID Book id
     * @param name Book Name
     * @param year Book Publish Year
     * @param author Book Author
     * @return True if succeed<br> False,  otherwise
     */
    public boolean addBook(String ID, String name, String year, String author) {

        Book [] bk = getDb().getBooks();

        System.out.println("Adding book in progress...\n");
        for (int i = 0; i < bk.length; ++i) {
            if (bk[i].getID().equals(ID)) {
                System.err.println("Book ID must be unique during adding book!\n");
                return false;
            }
        }
        Book b = new Book(ID, name, year, author, "-");
        Book [] temp = bk;
        bk = new Book[temp.length + 1];

        for (int i = 0; i < temp.length; ++i) {
            bk[i].setID(temp[i].getID());
            bk[i].setName(temp[i].getName());
            bk[i].setYear(temp[i].getYear());
            bk[i].setAuthor(temp[i].getAuthor());
            bk[i].setBorrower(temp[i].getBorrower());
        }
        bk[temp.length].setID(ID);
        bk[temp.length].setName(name);
        bk[temp.length].setYear(year);
        bk[temp.length].setAuthor(author);
        bk[temp.length].setBorrower("-");


        System.out.println("The book has been added successfully.\n");
        return true;
    }

    /**
     * Removes a book from the library
     * @param ID Book id
     * @return True if succeed<br> False,  otherwise
     */
    public boolean removeBook(String ID) {
        Book [] bk = getDb().getBooks();
        System.out.println("Removing book in progress...\n");
        boolean found = false;
        int bookIndex = -1;
        for (int i = 0; i < bk.length && !found; ++i) {
            if (bk[i].getID().equals(ID)) {
                bookIndex = i;
                found = true;
                if (!bk[i].getBorrower().equals("-")) {
                    System.err.println("The book can not remove if borrowed!");
                    return false;
                }
            }
        }
        //bk.remove(bookIndex);
        return true;
    }

    /**
     * Adds a new user to the database
     * @param userID New User id
     * @param name New User First Name
     * @param surName New User Last Name
     * @param userName New Username
     * @param password New User Password
     * @return True if succeed<br> False,  otherwise
     */
    public boolean registerUser(String userID, String name, String surName, String userName, String password) {

        final int MIN_CHAR = 3;

        Person [] usr = getDb().getUsers();

        System.out.println("Registering User in progress...\n");

        // User ID can be "uX" for normal users or be "sX" for staff !
        if ((userID.charAt(0) != 'u') || (userID.charAt(0) == 's')){
            System.err.println("Register ID is inappropriate for user of staff");
            return false;
        }

        if (userName.length() < MIN_CHAR || password.length() < MIN_CHAR) {
            System.err.println("Username and password must be at least three digits!");
            return false;
        }

        System.out.println("Registering User in progress...\n");
        for (int i = 0; i < usr.length; ++i) {
            if (usr[i].getID().equals(userID) || usr[i].getUsername().equals(userName)) {
                System.err.println("User ID or username must be unique for a new user.");
                return false;
            }
        }

        Person pr = new Person(userID, name, surName, userName, password);
        //usr.add(pr);
        System.out.println("The New User added to the Database.\n");
        return true;
    }

    /**
     * Deletes username from the database
     * @param username username
     * @return True if succeed<br> False,  otherwise
     */
    public boolean removeUser(String username) {

        int indexUser = -1;
        boolean found = false;
        Person [] usr = getDb().getUsers();

        for (int i = 0; i < usr.length && !found; ++i) {
            if (usr[i].getUsername().equals(username)) {
                indexUser = i;
                found = true;
            }
        }
        if(indexUser == -1){
            System.err.println("User not found to remove.");
            return false;
        }


        //usr.remove(indexUser);
        System.out.println("User was removed successfully.");
        return true;
    }
}
