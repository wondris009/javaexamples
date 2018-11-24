package cz.speedygonzales.designpatterns.listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: vondracek - 22.2.15 13:18
 */
public class Model {

    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";

    private List<Person> persons = new ArrayList<Person>();

    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    public Model() {
        // just for testing we hard-code the persons here:
        persons.add(new Person("Renata", "Vondrackova"));
        persons.add(new Person("Martina", "Zuzlikova"));
    }

    public List<Person> getPersons() {

        return persons;
    }

    private void notifyListeners(String property, String oldValue, String newValue) {

        for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    public void addChangeListener(PropertyChangeListener newListener) {

        listener.add(newListener);
    }

    public class Person {

        private String firstName;

        private String lastName;

        public Person(String firstName, String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {

            return firstName;
        }

        public void setFirstName(String firstName) {

            notifyListeners(FIRSTNAME, this.firstName, this.firstName = firstName);
        }

        public String getLastName() {

            return lastName;
        }

        public void setLastName(String lastName) {

            notifyListeners(LASTNAME, this.lastName, this.lastName = lastName);
        }
    }
}
