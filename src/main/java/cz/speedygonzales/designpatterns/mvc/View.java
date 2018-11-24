package cz.speedygonzales.designpatterns.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vondracek
 * @since 25.10.2015 21:45
 */
public class View {

    private static final Logger LOG = LoggerFactory.getLogger(View.class);

    public void printStudentDetails(String studentName, String studentRollNo) {

        LOG.info("Model [name: {}, roll no.: {}]", studentName, studentRollNo);
    }
}