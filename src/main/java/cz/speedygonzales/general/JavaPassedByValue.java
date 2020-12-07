package cz.speedygonzales.general;

public class JavaPassedByValue {


    public static void main(String[] args) throws Exception {

        Dog firstDog = new Dog("Lukas");
        Dog secondDog = firstDog;

        foo(firstDog);

        System.out.println(firstDog.name);
        System.out.println(secondDog.name);
        System.out.println(firstDog == secondDog);

//        Lukas
//        Changed name
//        Name from foo method
//        Changed name
//        Changed name
//        true
    }

    static void foo(Dog d) {
        System.out.println(d.name);
        d.name = "Changed name";
        System.out.println(d.name);
        d = new Dog("Name from foo method");
        System.out.println(d.name);

    }

    static class Dog {

        String name;

        public Dog(String name) {
            this.name = name;
        }
    }

}

