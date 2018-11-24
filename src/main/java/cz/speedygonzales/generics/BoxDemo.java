package cz.speedygonzales.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vondracek
 * @since 28.9.2016 10:57
 */
public class BoxDemo {

    public static <U> void addBox(U u, List<Box<U>> boxes) {

        Box<U> box = new Box<>();
        box.setT(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {

        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.getT();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {

        List<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        BoxDemo.addBox(10, listOfIntegerBoxes);
        BoxDemo.addBox(20, listOfIntegerBoxes);
        BoxDemo.addBox(30, listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }

}
