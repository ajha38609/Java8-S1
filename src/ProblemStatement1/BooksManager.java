package ProblemStatement1;

import java.util.Scanner;

public class BooksManager {
	
	// Pure function to create n objects of Book in an array
    public static Book[] createBooks(int n) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            Book book = new Book();

            System.out.println("Enter information for Book " + (i + 1) + ":");
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            book.setBookTitle(title);

            System.out.print("Enter book price: ");
            double price = scanner.nextDouble();
            book.setBookPrice(price);

            scanner.nextLine();

            books[i] = book;
        }

           scanner.close();

        return books;
    }

    // Pure function to display books along with their description
    public static void showBooks(Book[] books) {
        System.out.println("Book Title\t\tPrice");
        for (Book book : books) {
      System.out.printf("%-20s\tRs %.2f%n", book.getBookTitle(), book.getBookPrice());
        }
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();

        // Create an array of Book objects
        Book[] books = createBooks(n);

        showBooks(books);

	}
}
