package sparkTimer.athlete;

import sparkTimer.util.CrudApi;

import javax.persistence.EntityManagerFactory;

public class AthleteApi extends CrudApi<Athlete> {
    public AthleteApi(EntityManagerFactory emf) {
        super(emf, Athlete.class);
    }
}
