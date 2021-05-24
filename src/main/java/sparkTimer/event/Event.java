package sparkTimer.event;

import sparkTimer.athlete.Athlete;
import sparkTimer.entry.Entry;
import sparkTimer.entry.FieldEntry;
import sparkTimer.entry.RaceEntry;

import java.util.ArrayList;

public class Event {
    String title;
    ArrayList<Entry> entries =  new ArrayList<>();
    EventStatus status;

    protected enum Unit {
        MILE,
        METER
    }

    public void enterAthlete(Athlete a, float seed) {
        FieldEntry entry = new FieldEntry(a, seed);
        entries.add(entry);
    }

    public void enterAthlete(Athlete a, String seed) {
        RaceEntry entry = new RaceEntry(a, seed);
        entries.add(entry);
    }

    public void scratchEntry(){}
    public void startEvent(){}
    public void scoreEvent(){}

}
