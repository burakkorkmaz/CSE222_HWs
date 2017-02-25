public class Main {

    public static void main(String[] args) {
        try {
            Database db = new Database();
            db.readBookFile("books.csv");
//            db.writeUserFile("users.csv");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
