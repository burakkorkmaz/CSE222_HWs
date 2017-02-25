/**
 * Created by eksor on 23.02.2017.
 */
public class User extends Person{

    public User() {super();}

    public User(String ID, String name, String surname, String username, String password) {
        super(ID, name, surname, username, password);
    }


    public  void borrowBook(String bookName, String userID) {
        int bookIndex = getDb().getBooks().indexOf(bookName);
        int userIndex;
        if (bookIndex != -1) {
            userIndex = getDb().getUsers().indexOf(userID);
            System.out.println(userIndex);
//            if (userIndex != -1) {
//                System.out.println(getDb().getBooks().get(userIndex));
//            }
        }
    }


    public void returnBook(String bookName){
        return;
    }
}
