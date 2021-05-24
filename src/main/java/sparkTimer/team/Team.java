package sparkTimer.team;

import sparkTimer.athlete.Athlete;

import java.util.ArrayList;

public class Team {
    String name;
    ArrayList<Athlete> members;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addMember(Athlete athlete) {
        return members.add(athlete);
    }

    public Athlete[] getMembers() {
        return members.toArray(Athlete[]::new);
    }
}
