package sparkTimer.athlete;

import java.util.ArrayList;

public class AthleteDao {
    ArrayList<Athlete> athletes = new ArrayList<>();

    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }

    public Athlete getAthleteById(int id) {
        return athletes.stream()
                .filter((a) -> a.id == id)
                .findFirst().orElse(null);
    }

    public Athlete getAthleteByName(int id) {
        return athletes.stream()
                .filter((a) -> a.id == id)
                .findFirst().orElse(null);
    }

    public boolean insertAthlete(Athlete a) {
        return athletes.add(a);
    }

    public boolean deleteAthlete(int id) {
        Athlete toRemove = getAthleteById(id);
        return athletes.remove(toRemove);
    }
}
