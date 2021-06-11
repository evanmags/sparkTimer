package sparkTimer.entry;

import lombok.Data;
import sparkTimer.entry.seed.Seed;

@Data
public class Entry<T> {
    int athleteId;
    int eventId;
    Seed<T> seed;

    public int compareTo(Entry<T> other) {
        return seed.compareTo(other.getSeed());
    }
}
