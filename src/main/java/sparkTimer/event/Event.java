package sparkTimer.event;

import lombok.Data;
import sparkTimer.entry.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Event<T> {
    String title;
    ArrayList<Entry<T>> entries =  new ArrayList<>();
    EventStatus status;

    public void sortEntries() {
        Collections.sort((List) entries);
    }
}
