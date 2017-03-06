package tr.edu.gtu.bkorkmaz.linkedlist;

/**
 * This class keeps all person information.<br>Person Class has ID, Name, Surname, Username, Password items.
 *
 * <p>_Created by Burak Kağan Korkmaz on 23.02.2017.</p>
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

    /**
     * CONSTRUCTOR
     * @param ID Person unique id . Also Specifies User or Staff
     * @param name Person first name
     * @param surname Person last name
     * @param username Person username to login the system
     * @param password Person password to login the system
     */
    public Person(String ID, String name, String surname, String username, String password) {
        setID(ID);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    /**
     * Connects to the Database
     * @param db An object of database
     */
    public void initializeDB(Database db){
        this.db=db;
    }

    /**
     * Gets the Database
     * @return Database Class
     */
    public Database getDb() {
        return db;
    }

    /**
     * Gets user id
     * @return String User id of person
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets user id
     * @param ID User id of person
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets First Name
     * @return First name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets first name
     * @param name Last name of person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Last name of person
     * @return Last name of person
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets Last name of person
     * @param surname Last name
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets User name of person
     * @return User name
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets User name of person
     * @param username User name of person
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password of person
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets password of person
     * @param password Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Override toSting method of Person Class
     *
     * @return Shows all information about Person
     */
    @Override
    public String toString() {
        return "| ID: " + getID() + " | Name: " + getName() + " | Surname: " + getSurname() + " | Username: " +
                getUsername() + " | Password: " + getPassword() + " |\n";
    }

    /**
     * Override equals method of Person Class
     * @param obj Object class which checks the equality
     * @return True if equals  <br> False otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Person){
            Person pr = (Person)obj;
            return this.ID.equals(pr.ID);
        }
        return false;
    }
}

