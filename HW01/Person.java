/**
 * Created by eksor on 23.02.2017.
 */
public class Person {

    private String ID;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Database  db;

    public Person(){
    }

    public Person(String ID, String name, String surname, String username, String password) {
        setID(ID);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    public void initializeDB(Database db){
        this.db=db;
    }

    public Database getDb() {
        return db;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "| ID: " + getID() + " | Name: " + getName() + " | Surname: " + getSurname() + " | Username: " +
                getUsername() + " | Password: " + getPassword() + " |\n";
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Person){
            Person pr = (Person)obj;
            return this.ID == pr.ID;
        }
        return false;
    }
}

