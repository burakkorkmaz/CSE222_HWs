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
        ArrayList<Book> bk = getDb().getBooks();
        ArrayList<Person> pr = getDb().getUsers();

        for (int i = 0; i < bk.size(); ++i) {
            if (bk.get(i).getName().equals(bookName)) {
                bookIndex = i;
                if (!bk.get(i).getBorrower().equals("-")){
                    System.err.println("The book has been borrowed earlier.");
                    ///
                }
            }
        }
        if (bookIndex == -1){
            System.err.println("The book could not found in database");
            return false;
        }
        else {
            System.out.println("Book Found at index:" + bookIndex);
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
                System.out.println("User found at index:" + userIndex);
                bk.get(bookIndex).setBorrower(pr.get(userIndex).getUsername());
            }

        }
        return true;
    }


    public void returnBook(String bookName) {
        return;
    }
}
