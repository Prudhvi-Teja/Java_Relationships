package Java_Realtionships.LiberaryManagement;

class Ebook extends Book{
    String fileformat;
    public Ebook(Author author, String format){
        super(format, author);
        this.fileformat = format;
    }
}