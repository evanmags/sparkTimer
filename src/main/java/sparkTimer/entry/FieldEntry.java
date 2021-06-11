package sparkTimer.entry;

import lombok.EqualsAndHashCode;
import sparkTimer.athlete.Athlete;
import sparkTimer.entry.seed.MeasureSeed;

@EqualsAndHashCode(callSuper = true)
public class FieldEntry extends Entry<Float>{
    public FieldEntry(Athlete a, float seed) {
        athleteId = a.getId();
        this.seed = new MeasureSeed(seed);
    }
}
