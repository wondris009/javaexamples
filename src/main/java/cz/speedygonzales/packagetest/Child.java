package cz.speedygonzales.packagetest;


class Child extends Parent {

    public Child(String name, String packagePrivateName) {
        super(name, packagePrivateName);
    }


    public static void main(String[] args) {

        Child child = new Child("a", "b");


        System.out.println(child.name);
        System.out.println(child.packagePrivateName);


    }


}
