public class Main {

    public static void main(String[] args) {
        try {
            Database db = new Database();
//            User u = new User("u1","User","One","user","pass");
//            u.initializeDB(db);
//            boolean rn = u.borrowBook("OOP Programming");
//            boolean bw = u.returnBook("Book");
//            if( rn || bw)
//                db.writeBookFile("books.csv");
            Staff s = new Staff("s1","John","Clerk","staff","pwd");
            s.addBook("3","Eylul","2005","Mehmet Rauf");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
