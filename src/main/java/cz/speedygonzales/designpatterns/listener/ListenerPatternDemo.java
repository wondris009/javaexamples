package cz.speedygonzales.designpatterns.listener;

/**
 * Created by: vondracek - 22.2.15 13:24
 */
public class ListenerPatternDemo {

    public static void main(String[] args) {

        Model model = new Model();
        Listener observer = new Listener(model);
        // we change the last name of the person, observer will get notified
        for (Model.Person person : model.getPersons()) {
            person.setLastName(person.getLastName() + "1");
        }
        // we change the name of the person, observer will get notified
        for (Model.Person person : model.getPersons()) {
            person.setFirstName(person.getFirstName() + "1");
        }
    }
}