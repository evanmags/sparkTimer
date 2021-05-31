package sparkTimer.team;

import sparkTimer.util.CrudApi;

import javax.persistence.EntityManagerFactory;

public class TeamApi extends CrudApi<Team> {
    public TeamApi(EntityManagerFactory emf) {
        super(emf, Team.class);
    }
}
