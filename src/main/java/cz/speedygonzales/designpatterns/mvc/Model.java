package cz.speedygonzales.designpatterns.mvc;

/**
 * @author vondracek
 * @since 25.10.2015 21:43
 */
public class Model {

    private String rollNo;
    private String name;

    public String getRollNo() {

        return rollNo;
    }

    public void setRollNo(String rollNo) {

        this.rollNo = rollNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}