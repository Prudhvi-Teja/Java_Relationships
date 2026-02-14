package Java_Realtionships.LiberaryManagement;

public class Book implements Read {

    String name;
    Author author;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public void read() {

        System.out.println("Unimplemented method 'read'");
    }

}
