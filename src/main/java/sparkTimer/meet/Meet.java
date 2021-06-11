package sparkTimer.meet;

import lombok.Data;
import sparkTimer.event.Event;
import sparkTimer.util.CrudEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Meet extends CrudEntity {
    String name;
    Date startDate;
    Date endDate;
    Event[] events;

    public Meet() {}

    public Meet(String name, Date date){
        this.name = name;
        this.startDate = date;
        this.endDate = date;
    }

    public Meet(String name, Date startDate, Date endDate){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

}
