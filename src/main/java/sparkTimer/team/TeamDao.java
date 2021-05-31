package sparkTimer.team;

import sparkTimer.util.CrudDao;

import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Type;

public class TeamDao extends CrudDao<Team> {
    public TeamDao(EntityManagerFactory entityManagerFactory, Type entityType) {
        super(entityManagerFactory, entityType);
    }
}
