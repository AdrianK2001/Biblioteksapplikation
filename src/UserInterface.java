import java.util.Scanner;

public class UserInterface {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. List books");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Add book (Admin)");
            System.out.println("5. Remove book (Admin)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Books.listBooks();
                    break;
                case 2:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    Loan.borrowBook(borrowId, userName);
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    Loan.returnBook(returnId);
                    break;
                case 4:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Books.addBook(title, author);
                    break;
                case 5:
                    System.out.print("Enter book ID to remove: ");
                    int removeId = scanner.nextInt();
                    Books.removeBook(removeId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
