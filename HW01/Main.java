public class Main {

    public static void main(String[] args) {
        try {
            Database db = new Database();
            User u = new User("u1","User","One","user","pass");
            u.initializeDB(db);
            u.borrowBook("OOP Programming");
            db.writeBookFile("books.csv");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
