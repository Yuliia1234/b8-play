package pojo;

import java.util.List;
import java.util.Map;

public class PetPojo2 {

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Map<String, String>> getResults() {
        return results;
    }

    private int count;
    private String next;
    private String previous;
    private List<Map<String, String> >results;
}
