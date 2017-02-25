public class Main {

    public static void main(String[] args) {
        try {
            Database db = new Database("users.csv");
            db.readFile();
            db.writeFile();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
