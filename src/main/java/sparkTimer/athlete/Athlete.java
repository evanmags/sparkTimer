package sparkTimer.athlete;

import java.util.Date;

public class Athlete {

    int id;
    Name name;
    Date birthdate;

    public void setName(String first, String middle, String last) {
        name = new Name(first, middle, last);
    }

    public void setName(String first, String last) {
        name = new Name(first, last);
    }

    public Name getName(){
        return name;
    }

    public void setBirthdate(Date birthday) {
        birthdate = birthday;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    private class Name {

        String firstName;
        String middleName;
        String lastName;

        public Name(String first, String middle, String last) {
            firstName = first;
            middleName = middle;
            lastName = last;
        }

        public Name(String first, String last) {
            firstName = first;
            lastName = last;
        }

        @Override
        public String toString() {
            if (middleName != null) {
                return String.format("%s, %s %s", lastName, firstName, middleName);
            }
            return String.format("%s, %s", lastName, firstName);
        }
    }
}
