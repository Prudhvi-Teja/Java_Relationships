package Java_Realtionships.LiberaryManagement;
import java.util.*;
class Library{
    String name;
    List<Book> books;
    public Library(String name, Book book){
        this.name = name;
        this.books= new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
}