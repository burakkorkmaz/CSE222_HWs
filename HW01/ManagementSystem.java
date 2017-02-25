/**
 * Created by eksor on 24.02.2017.
 */
public interface ManagementSystem {

    void readUserFile(String filename);

    void readBookFile(String filename);

    void writeUserFile(String filename);

    void writeBookFile(String filename);

    String login(String name, String pass);


}
