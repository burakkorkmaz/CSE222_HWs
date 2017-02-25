public class Main {

    public static void main(String[] args) {
        try {
//            Database db = new Database();
            User u = new User();
            u.borrowBook("OOP Programming", "u1");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
