package cz.speedygonzales.designpatterns.mvc;

/**
 * @author vondracek
 * @since 25.10.2015 21:46
 */
public class MVCPatternDemo {

    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Model model = retriveFromDatabase();

        //Create a view : to write student details on console
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.showCurrentViewState();

        //update model data
        controller.setStudentName("John");

        controller.showCurrentViewState();
    }

    private static Model retriveFromDatabase() {

        Model student = new Model();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}