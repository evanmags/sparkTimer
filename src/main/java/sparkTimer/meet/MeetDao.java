package sparkTimer.meet;

import sparkTimer.util.CrudDao;

import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Type;

public class MeetDao extends CrudDao<Meet> {
    public MeetDao(EntityManagerFactory entityManagerFactory, Type entityType) {
        super(entityManagerFactory, entityType);
    }
}
