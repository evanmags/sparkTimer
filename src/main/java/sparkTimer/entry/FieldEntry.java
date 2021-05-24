package sparkTimer.entry;

import sparkTimer.athlete.Athlete;

public class FieldEntry extends Entry{
    float seed;

    public FieldEntry(Athlete a, float seed) {
        athlete = a;
        this.seed = seed;
    }
}
