package sparkTimer.team;

import sparkTimer.athlete.Athlete;
import sparkTimer.util.CrudEntity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Team extends CrudEntity {
    @Column(unique = true)
    String name;
    ArrayList<Athlete> members;

    public Team(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(ArrayList<Athlete> members) {
        this.members = members;
    }

    public boolean addMember(Athlete athlete) {
        return members.add(athlete);
    }

    public Athlete[] getMembers() {
        return members.toArray(Athlete[]::new);
    }

    public void removeMember(int id) {
        members.removeIf((m) -> m.getId() != id );
    }
}
