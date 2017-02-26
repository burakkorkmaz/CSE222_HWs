/**
 * Created by eksor on 25.02.2017.
 */
public class Book {
    private String ID;
    private String name;
    private String year;
    private String author;
    private String borrower;

    public Book(String id, String name, String year, String author, String borrower) {
        ID = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.borrower = borrower;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }


    @Override
    public String toString() {
        return "| ID: " + getID() + " | Name: " + getName() + " | Year: " + getYear() + " | Author: " +
                getAuthor() + " | Borrower: " + getBorrower() + " |\n";
    }

    @Override
    public boolean equals(Object obs) {

        if (obs instanceof Book) {
            Book bk = (Book) obs;
            return this.name.equals(bk.name);
        }
        return false;

    }
}
