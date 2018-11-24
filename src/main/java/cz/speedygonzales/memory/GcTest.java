package cz.speedygonzales.memory;

/**
 * @author vondracek
 * @since 11.9.2016 22:18
 */
public class GcTest {

    private static GcTest reference = null;
    private int id;
    private String name;

    public static void main(String[] args) {

        GcTest myGcTest = new GcTest();
        myGcTest.id = 1001;
        myGcTest.name = "Praveen";
        myGcTest = null;

        // requesting Garbage Collector to execute.
        // internally GC uses Mark and Sweep algorithm to clear heap memory.
        // gc() is a native method in RunTime class.

        System.gc();   // or Runtime.getRuntime().gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n------- After called GC () ---------\n");
        System.out.println("Id :" + reference.id);
        System.out.println("Name :" + reference.name);


    }

    @Override
    protected void finalize() throws Throwable {

        super.finalize();

        System.out.println("In finalize method.");
        System.out.println("In finalize :ID :" + this.id);
        System.out.println("In finalize :ID :" + this.name);

        reference = this;
    }
}
