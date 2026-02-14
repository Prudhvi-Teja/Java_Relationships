package Java_Realtionships.LiberaryManagement;
import java.util.List;
import java.util.ArrayList;
public class ReadingClub {

    String name;

    List<Reader> readers;

    public ReadingClub(String name){
        this.name = name;
        this.readers = new ArrayList<>();
    }
    
    public void addReader(Reader reader){
        this.readers.add(reader);
    }
    
}
