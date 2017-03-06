package tr.edu.gtu.bkorkmaz.linkedlist;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Database db = new Database();
        Scanner scanner = new Scanner(System.in);
        Person person = null;

        try {
            boolean loginSuccess = false;

            System.out.println("Welcome to the Library Management System!");

            do {
                System.out.print("\nUsername:");

                String username = scanner.nextLine();
                System.out.print("Password:");
                String password = scanner.nextLine();

                if ((person = db.login(username, password)) != null) {
                    loginSuccess = true;

                    if (person.getID().startsWith("s")) {
                        System.out.println("Staff Login is Successful!");
                    } else {
                        System.out.println("User Login is Successful!");
                    }
                }
                else{
                    System.err.println("Username or Password is invalid. Please Try Again!");
                }
            } while (!loginSuccess);

            person.initializeDB(db);


            if (person instanceof Staff) {
                Staff staff = (Staff) person;
                boolean cont = true;
                while (cont) {
                    System.out.println("Choice a operation");
                    System.out.println("1. Add a new Book");
                    System.out.println("2. Remove a Book");
                    System.out.println("3. Register a new Person");
                    System.out.println("4. Remove a Person");
                    System.out.println("5. Show the Database");
                    System.out.println("6. Exit");
                    System.out.println("\n");

                    String choice = scanner.nextLine();

                    int opt = Integer.parseInt(choice);

                    if (opt == 1) {
                        String id, name, year, author;
                        System.out.print("Enter book id:");
                        id = scanner.nextLine();
                        System.out.print("Enter book name:");
                        name = scanner.nextLine();
                        System.out.print("Enter book year:");
                        year = scanner.nextLine();
                        System.out.print("Enter book author:");
                        author = scanner.nextLine();

                        staff.addBook(id, name, year, author);

                    } else if (opt == 2) {
                        System.out.print("Enter BOOK ID to remove:");
                        if (staff.removeBook(scanner.nextLine()))
                            System.out.println("Book removed from Database\nSS");
                    } else if (opt == 3) {
                        String id,name,surname,username,pass;
                        System.out.print("Enter user id:");
                        id = scanner.nextLine();
                        System.out.print("Enter name:");
                        name = scanner.nextLine();
                        System.out.print("Enter surname:");
                        surname = scanner.nextLine();
                        System.out.print("Enter username:");
                        username = scanner.nextLine();
                        System.out.print("Enter password:");
                        pass = scanner.nextLine();

                        staff.registerUser(id,name,surname,username,pass);

                    } else if (opt == 4) {
                        System.out.print("Enter PERSON to remove:");

                        staff.removeUser(scanner.nextLine());
                    }else if (opt == 5) {
                        db.showUsers();
                        db.showBooks();
                    } else if (opt == 6) {
                        cont = false;
                        db.writeUserFile("users.csv");
                        db.writeBookFile("books.csv");
                    } else System.err.println("Please enter a valid input");

                }

            } else {
                User user = (User) person;
                boolean okey = true;
                while (okey) {
                    System.out.println("Choice a operation");
                    System.out.println("1. Borrow a Book");
                    System.out.println("2. Return a Book");
                    System.out.println("3. Show Books");
                    System.out.println("4. Exit");
                    System.out.println("\n");

                    String choice = scanner.nextLine();
                    try {
                        if (Integer.parseInt(choice) == 4) {
                            db.writeUserFile("users.csv");
                            db.writeBookFile("books.csv");
                            okey = false;
                        }
                        if (Integer.parseInt(choice) == 1) {
                            System.out.print("Enter a book name:");
                            String bookName = scanner.nextLine();

                            if (!user.borrowBook(bookName))
                                System.out.println("Please try again or exit");
                        } else if (Integer.parseInt(choice) == 2) {

                            System.out.print("Enter the book name to return:");
                            String bookName = scanner.nextLine();
                            if (!user.returnBook(bookName))
                                System.out.println("Please try again or exit");
                        }
                        else if(Integer.parseInt(choice) == 3) {
                            db.showBookIDs();
                        }

                    } catch (Exception e) {
                        System.err.println("Invalid Input. Try Again");
                    }

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
