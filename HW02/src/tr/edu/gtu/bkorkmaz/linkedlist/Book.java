package tr.edu.gtu.bkorkmaz.linkedlist;

/**
 * This class keeps all book information in library<br> Book class has ID, Name, Surname, Username, Password items.
 * <p>_Created by Burak Kağan Korkmaz on 25.02.2017.</p>
 */
public class Book {

    private String ID;
    private String name;
    private String year;
    private String author;
    private String borrower;

    /**
     * CONSTRUCTOR
     * @param id Book unique id.
     * @param name Book name.
     * @param year Book publish year.
     * @param author Book author.
     * @param borrower Person who borrows this book.
     */
    public Book(String id, String name, String year, String author, String borrower) {
        setID(id);
        setName(name);
        setYear(year);
        setAuthor(author);
        setBorrower(borrower);
    }

    /**
     * Gets Book id.
     * @return Book id
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets Book id.
     * @param ID Book id
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets Book name.
     * @return Book name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Book name.
     * @param name Book name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Book Publish year
     * @return Year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets Book publish year.
     * @param year Year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Gets Book Author.
     * @return Book Author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets Book Author.
     * @param author Book Author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets Person who borrowed the book.
     * @return Borrower Person
     */
    public String getBorrower() {
        return borrower;
    }

    /**
     *Gets Person who borrowed the book.
     * @param borrower Borrower Person
     */
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    /**
     * Override toSting method of Book Class.
     * @return Shows all information about Book
     */
    @Override
    public String toString() {
        return "| ID: " + getID() + " | Name: " + getName() + " | Year: " + getYear() + " | Author: " +
                getAuthor() + " | Borrower: " + getBorrower() + " |\n";
    }

    /**
     * Override equals method of Book Class.
     * @param obj Object class which checks the book equality
     * @return True if equals  <br> False otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Book) {
            Book bk = (Book) obj;
            return this.name.equals(bk.name);
        }
        return false;

    }
}
