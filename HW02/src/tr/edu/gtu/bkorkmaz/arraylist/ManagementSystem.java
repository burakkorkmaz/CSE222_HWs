package tr.edu.gtu.bkorkmaz.arraylist;

/**
 * The Library Management System Interface
 * <p>Created by Burak Kağan Korkmaz on 24.02.2017.</p>
 */
public interface ManagementSystem {

    void readUserFile(String filename);

    void readBookFile(String filename);

    void writeUserFile(String filename);

    void writeBookFile(String filename);

    Person login(String name, String pass);


}
