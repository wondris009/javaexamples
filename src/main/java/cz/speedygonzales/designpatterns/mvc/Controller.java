package cz.speedygonzales.designpatterns.mvc;

/**
 * @author vondracek
 * @since 25.10.2015 21:45
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {

        this.model = model;
        this.view = view;
    }

    public String getStudentName() {

        return model.getName();
    }

    public void setStudentName(String name) {

        model.setName(name);
    }

    public String getStudentRollNo() {

        return model.getRollNo();
    }

    public void setStudentRollNo(String rollNo) {

        model.setRollNo(rollNo);
    }

    public void showCurrentViewState() {

        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}