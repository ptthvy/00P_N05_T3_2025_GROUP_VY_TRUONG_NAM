import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Lập trình Java"));
        bookList.add(new Book(2, "Cấu trúc dữ liệu"));

        Library library = new Library(bookList);

        for (Book b : library.getList()) {
            // In 
            System.out.println("ID: " + b.getId() + ", Tên: " + b.getName());
        }
    }
}
