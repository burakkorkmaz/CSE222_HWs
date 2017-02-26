/**
 * Created by eksor on 25.02.2017.
 */
public class Book {
    private String ISBN;
    private String name;
    private String year;
    private String author;
    private String borrower;
    private String borrowDate;

    public Book(String isbn, String name, String year, String author, String borrower, String borrowDate) {
        ISBN = isbn;
        this.name = name;
        this.year = year;
        this.author = author;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return "| ISBN: " + getISBN() + " | Name: " + getName() + " | Year: " + getYear() + " | Author: " +
                getAuthor() + " | Borrower: " + getBorrower() + " | Borrow Date: " + getBorrowDate() + " |\n";
    }

    @Override
    public boolean equals(Object obs){

        if(obs instanceof Book){
            Book bk = (Book) obs;
            return this.name==bk.name;
        }
        return false;

    }
}
