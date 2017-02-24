/**
 * Created by eksor on 24.02.2017.
 */
public interface ManagementSystem {

    void readFile(String filename);

    void writeFile(String filename);

    String login(String name, String pass);


}
