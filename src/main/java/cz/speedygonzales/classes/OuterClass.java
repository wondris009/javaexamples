package cz.speedygonzales.classes;

/**
 */
public class OuterClass {

    private String value;

    public OuterClass(String value) {
        this.value = value;
    }

    class InnerClass {

        private String value;

        public InnerClass(String value) {
            this.value = value;
        }
    }

    static class StaticClass {

        private String value;

        public StaticClass(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        OuterClass outer = new OuterClass("outer");
    }

    public void instant() {

        InnerClass inner = new InnerClass("inner");

        OuterClass outer = new OuterClass("outer");

        StaticClass s = new StaticClass("static");
    }
}
