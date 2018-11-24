package cz.speedygonzales.memory;

/**
 * @author vondracek
 * @since 23.8.2016 16:13
 */
public class MemoryTester2 {

    public static void main(String[] args) {

        MemoryTester2 tester2 = new MemoryTester2();

        Dog myDog = new Dog("Rover");


        tester2.foo(myDog);

    }

    void foo(Dog someDog) {

        someDog.setName("Max");     // AAA
        someDog = new Dog("Fifi");  // BBB
        someDog.setName("Rowlf");   // CCC


    }
}
