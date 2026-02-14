package Java_Realtionships.LiberaryManagement;

public class Reader {

    String name;

    public Reader(String name){
        this.name = name;
    }

    public void readBook(Book book){
         System.out.println("Reading book of"+book.name);
    }
    
}
