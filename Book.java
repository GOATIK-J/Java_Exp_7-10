import java.util.*;

class Book {
    int id;
    String title;
    String author;
    double price;

    Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
public class BookInventory {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
      
        try {
            System.out.print("Enter number of books: ");
            int n = sc.nextInt();
            sc.nextLine();

            for(int i=0;i<n;i++) {
                System.out.println("\nEnter Book Details");
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
              
                System.out.print("Title: ");
                String title = sc.nextLine();
              
                System.out.print("Author: ");
                String author = sc.nextLine();
              
                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                Book b = new Book(id,title,author,price);
                books.add(b);
            }
          
            System.out.println("\nBook Inventory:");

            for(Book b : books) {
                b.display();
            }
        }
        catch(Exception e) {
            System.out.println("Invalid input!");
        }
        sc.close();
    }
}
