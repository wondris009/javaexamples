package cz.speedygonzales.classes;

public class DemoClasses {

    public static void main(String[] args) {

        OuterClass.ProtectedStaticInnerClass innerClass = new OuterClass.ProtectedStaticInnerClass();
        System.out.println(innerClass.value);


    }
}
