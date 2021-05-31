package sparkTimer.meet;

import sparkTimer.util.CrudEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Meet extends CrudEntity {
    String name;
    Date startDate; // TODO: this will be come a schedule class

    public Meet() {}

    public Meet(String name, Date date){
        this.name = name;
        this.startDate = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
