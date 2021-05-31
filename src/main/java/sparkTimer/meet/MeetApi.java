package sparkTimer.meet;

import sparkTimer.util.CrudApi;

import javax.persistence.EntityManagerFactory;

public class MeetApi extends CrudApi<Meet> {
    public MeetApi(EntityManagerFactory emf) {
        super(emf, Meet.class);
    }
}
