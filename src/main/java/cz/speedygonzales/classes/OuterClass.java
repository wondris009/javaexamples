package cz.speedygonzales.classes;

/**
 */
public class OuterClass {

    public OuterClass() {
        System.out.println("OuterClass");
    }

    private static class PrivateStaticInnerClass {
        private String value = "PrivateStaticInnerClass";
    }

    protected static class ProtectedStaticInnerClass {
        protected String value = "ProtectedStaticInnerClass";
    }

    private class PrivateInnerClass {

        private void doSomething() {
            System.out.println(this.toString());
        }



    }

    public static void main(String[] args) {

        OuterClass.PrivateStaticInnerClass psic = new PrivateStaticInnerClass();

        System.out.println(psic.value);

        OuterClass oc = new OuterClass();
        PrivateInnerClass pic = oc.new PrivateInnerClass();
        pic.doSomething();

    }


}
