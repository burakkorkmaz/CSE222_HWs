import java.util.ArrayList;

/**
 * Created by eksor on 23.02.2017.
 */
public class User extends Person {
    public User(String ID, String name, String surname, String username, String password) {
        super(ID, name, surname, username, password);
    }

    public boolean borrowBook(String bookName) {

        int bookIndex = -1;
        int userIndex = -1;
        ArrayList<Person> pr = getDb().getUsers();
        ArrayList<Book> bk = getDb().getBooks();

        System.out.println("\nBorrowing the Book in progress...");
        for (int i = 0; i < bk.size(); ++i) {
            if (bk.get(i).getName().equals(bookName)) {
                bookIndex = i;
            }
        }
        if (bookIndex == -1){
            System.err.println("The book could not found in database");
            return false;
        }
        else {
            boolean found = false;
            for (int i = 0; i < pr.size() && !found; ++i) {
                if (pr.get(i).getID().equals(this.getID()))
                    userIndex = i;
            }
            if (userIndex == -1){
                System.err.println("User could not Found in database");
                return false;
            }
            else{
                if(bk.get(bookIndex).getBorrower().equals("-"))
                    bk.get(bookIndex).setBorrower(pr.get(userIndex).getUsername());

                else if(bk.get(bookIndex).getBorrower().equals(this.getUsername())) {
                    System.err.println("You have already borrowed the book.");
                    return false;
                }
                else{
                    System.err.println("The book has been borrowed earlier by another user.");
                    return false;
                }

            }

        }
        System.out.println("\nThe book has been borrowed successfully.");
        return true;
    }


    public boolean returnBook(String bookName) {

        int bookIndex = -1;
        int userIndex = -1;
        ArrayList<Person> pr = getDb().getUsers();
        ArrayList<Book> bk = getDb().getBooks();

        System.out.println("Returning the Book in progress...");
        for (int i = 0; i < bk.size(); ++i) {
            if (bk.get(i).getName().equals(bookName)) {
                bookIndex = i;
            }
        }
        if (bookIndex == -1){
            System.err.println("The book could not found in database");
            return false;
        }
        else {

            boolean found = false;
            for (int i = 0; i < pr.size() && !found; ++i) {
                if (pr.get(i).getID().equals(this.getID()))
                    userIndex = i;
            }
            if (userIndex == -1){
                System.err.println("User could not Found in database");
                return false;
            }
            else{
                if(bk.get(bookIndex).getBorrower().equals(this.getUsername()))
                    bk.get(bookIndex).setBorrower("-");
                else if (bk.get(bookIndex).getBorrower().equals("-")){
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
