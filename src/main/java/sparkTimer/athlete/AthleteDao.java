package sparkTimer.athlete;

import sparkTimer.util.CrudDao;

import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Type;

public class AthleteDao extends CrudDao<Athlete> {
    public AthleteDao(EntityManagerFactory emf, Type entityType) {
        super(emf, entityType);
    }
}
