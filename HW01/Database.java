/**
 * Created by eksor on 24.02.2017.
 */

import java.util.ArrayList;

public class Database implements ManagementSystem{

    //Delimiter for CSV files
    private static final String DELIMITER = ";";
    //Seperator for CSV files
    private static final String SEPERATOR = "\n";

    private ArrayList<String> arrayList = new ArrayList<>();

//    protected String books[];
//    protected int booksISBN[];
//    protected int booksYear[];
//    protected String booksAuthor[];
//    protected String booksBorrower[];
//    protected String bookLoanDate[];
//
//    protected String userID[];
//    protected String userFullName[];
//    protected String userName[];
//    protected String userPassword[];


    @Override
    public void readFile(String filename) {

    }

    @Override
    public void writeFile(String filename) {

    }

    @Override
    public String login(String name, String pass) {
        return null;
    }
}
