package cz.speedygonzales.designpatterns.listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by: vondracek - 22.2.15 13:23
 */
public class Listener implements PropertyChangeListener {

    public Listener(Model model) {

        model.addChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent event) {

        System.out.println("Changed property: " + event.getPropertyName() + " [old -> " + event.getOldValue() + "] | [new -> " + event.getNewValue() + "]");
    }
}