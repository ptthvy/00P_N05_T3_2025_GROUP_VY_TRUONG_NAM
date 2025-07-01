
public class Book {
    String title;
    String author;
    int numPages;


    Book() {
    }; 

    public Book(String t, String a, int p) {
        title = t;
        author = a;
        numPages = p;
    }

    public static void In() {
        Book myObj = new Book("a", "b", 2);
        Book obj = new Book();
        System.out.println(myObj.title);
        System.out.println("Author default::" +obj.author);
    }
}
